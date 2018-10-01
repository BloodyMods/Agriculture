package atm.bloodworkxgaming.agriculture.proxy

import atm.bloodworkxgaming.agriculture.blocks.machines.SpecialRendererCounter
import atm.bloodworkxgaming.agriculture.blocks.machines.TileCounter
import atm.bloodworkxgaming.bloodyLib.proxy.CommonProxy
import com.google.common.collect.ImmutableMap
import net.minecraft.util.ResourceLocation
import net.minecraftforge.client.model.ModelLoaderRegistry
import net.minecraftforge.common.animation.ITimeValue
import net.minecraftforge.common.model.animation.IAnimationStateMachine
import net.minecraftforge.fml.client.registry.ClientRegistry
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent


abstract class SubCommonProxy : CommonProxy() {
    abstract fun loadASM(location: ResourceLocation, parameters: Map<String, ITimeValue> = emptyMap()): IAnimationStateMachine?
    abstract fun preInit(event: FMLPreInitializationEvent)
}

class ServerProxy : SubCommonProxy() {
    override fun preInit(event: FMLPreInitializationEvent) {}

    override fun loadASM(location: ResourceLocation, parameters: Map<String, ITimeValue>): IAnimationStateMachine? = null

}

class ClientProxy : SubCommonProxy() {
    override fun preInit(event: FMLPreInitializationEvent) {
        ClientRegistry.bindTileEntitySpecialRenderer(TileCounter::class.java, SpecialRendererCounter())
    }

    override fun loadASM(location: ResourceLocation, parameters: Map<String, ITimeValue>): IAnimationStateMachine? =
            ModelLoaderRegistry.loadASM(location, ImmutableMap.copyOf(parameters))
}