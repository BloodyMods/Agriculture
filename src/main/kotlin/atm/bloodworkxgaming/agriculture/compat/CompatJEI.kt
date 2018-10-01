package atm.bloodworkxgaming.agriculture.compat

import atm.bloodworkxgaming.agriculture.ModBlocks
import mezz.jei.api.IModPlugin
import mezz.jei.api.IModRegistry
import mezz.jei.api.JEIPlugin
import net.minecraft.item.ItemStack

@JEIPlugin
class CompatJEI : IModPlugin {
    override fun register(registry: IModRegistry) {
        // registry.addRecipeCatalyst(ItemStack(ModBlocks.advancedReconstructor), RECONSTRUCTOR_NAME)
    }

    companion object {
        const val RECONSTRUCTOR_NAME = "actuallyadditions.reconstructor"
    }
}