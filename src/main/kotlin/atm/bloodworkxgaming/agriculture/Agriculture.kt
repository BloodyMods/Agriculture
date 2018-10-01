package atm.bloodworkxgaming.agriculture

import atm.bloodworkxgaming.agriculture.Agriculture.MOD_ID
import atm.bloodworkxgaming.agriculture.Agriculture.MOD_NAME
import atm.bloodworkxgaming.agriculture.Agriculture.VERSION
import atm.bloodworkxgaming.agriculture.proxy.GuiProxy
import atm.bloodworkxgaming.agriculture.proxy.SubCommonProxy
import atm.bloodworkxgaming.bloodyLib.registry.AbstractDataRegistry
import atm.bloodworkxgaming.bloodyLib.util.AbstractCommonHandler
import atm.bloodworkxgaming.bloodyLib.util.BloodyModMain
import net.minecraft.util.ResourceLocation
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.common.SidedProxy
import net.minecraftforge.fml.common.event.FMLInitializationEvent
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent
import net.minecraftforge.fml.common.network.NetworkRegistry
import org.apache.logging.log4j.LogManager

@Mod(
        modid = MOD_ID,
        modLanguageAdapter = "net.shadowfacts.forgelin.KotlinAdapter",
        version = VERSION,
        dependencies = "required-after:bloodylib",
        name = MOD_NAME)
object Agriculture : BloodyModMain(CommonHandler) {
    const val MOD_ID = "agriculture"
    const val MOD_NAME = "Agriculture"
    const val VERSION = "@VERSION@"

    var LOGGER = LogManager.getLogger("Agriculture")

    @Mod.Instance
    lateinit var instance: Agriculture

    @SidedProxy(serverSide = "atm.bloodworkxgaming.agriculture.proxy.ServerProxy", clientSide = "atm.bloodworkxgaming.agriculture.proxy.ClientProxy")
    lateinit var proxy: SubCommonProxy

    @Mod.EventHandler
    fun preInit(event: FMLPreInitializationEvent) {
        proxy.preInit(event)
    }

    @Mod.EventHandler
    fun init(event: FMLInitializationEvent) {
        NetworkRegistry.INSTANCE.registerGuiHandler(instance, GuiProxy)
    }
}

inline fun ownLocation(name: String): ResourceLocation = ResourceLocation(MOD_ID, name)

object DataRegistry : AbstractDataRegistry()
object CommonHandler : AbstractCommonHandler(modItems = ModItems, modBlocks = ModBlocks)