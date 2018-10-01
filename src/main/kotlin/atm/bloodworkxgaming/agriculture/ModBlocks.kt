package atm.bloodworkxgaming.agriculture

import atm.bloodworkxgaming.agriculture.blocks.machines.BlockBaseMachine
import atm.bloodworkxgaming.agriculture.blocks.machines.BlockCounter
import atm.bloodworkxgaming.agriculture.blocks.machines.TileCounter
import atm.bloodworkxgaming.bloodyLib.registry.AbstractModBlocks
import atm.bloodworkxgaming.bloodyLib.util.RegistryUtils
import net.minecraft.block.Block
import net.minecraftforge.registries.IForgeRegistry

object ModBlocks : AbstractModBlocks(DataRegistry) {
    // val advancedReconstructor = AdvancedReconstructor()
    // val advancedFluidizer = AdvancedFluidizer()

    val COUNTER = BlockCounter()
    val BREWER = BlockBaseMachine("brewer")
    val PROCESSOR = BlockBaseMachine("processor")
    val FRYER = BlockBaseMachine("fryer")
    val OVEN = BlockBaseMachine("oven")
    val FREEZER = BlockBaseMachine("freezer")


    override fun registerBlocks(registry: IForgeRegistry<Block>) {
        super.registerBlocks(registry)

        RegistryUtils.registerTileEntity<TileCounter>(ownLocation("tile_counter"))
        // RegistryUtils.registerTileEntity<TileAdvancedFluidizer>(ResourceLocation(ActuallyAddon.MOD_ID, "advanced_fluidizer"))
    }
}