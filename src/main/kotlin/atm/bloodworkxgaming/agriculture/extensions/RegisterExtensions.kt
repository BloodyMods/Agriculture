package atm.bloodworkxgaming.agriculture.extensions

import atm.bloodworkxgaming.agriculture.Agriculture
import atm.bloodworkxgaming.agriculture.DataRegistry
import net.minecraft.block.Block
import net.minecraft.item.Item
import net.minecraft.util.ResourceLocation

fun Item.registerMe(name: String) {
    this.registryName = ResourceLocation(Agriculture.MOD_ID, name)
    this.unlocalizedName = name

    DataRegistry.ITEMS += this
}

fun Block.registerMe(name: String) {
    this.registryName = ResourceLocation(Agriculture.MOD_ID, name)
    this.unlocalizedName = name

    DataRegistry.BLOCKS += this
}