package atm.bloodworkxgaming.agriculture

import atm.bloodworkxgaming.agriculture.extensions.registerMe
import atm.bloodworkxgaming.agriculture.items.ItemDishBase
import atm.bloodworkxgaming.agriculture.items.food.FoodItems
import atm.bloodworkxgaming.bloodyLib.BloodyLib
import atm.bloodworkxgaming.bloodyLib.registry.AbstractModItems
import net.minecraft.item.Item

object ModItems : AbstractModItems(DataRegistry) {
    init {
        Class.forName(FoodItems::class.qualifiedName)
    }

    val CERAMIC_BOWL = ItemDishBase("ceramic_bowl")
    val CERAMIC_CUP = ItemDishBase("ceramic_cup")
    val CERAMIC_PLATE = ItemDishBase("ceramic_plate")
    val CLAY_BOWL = ItemDishBase("clay_bowl")
    val CLAY_CUP = ItemDishBase("clay_cup")
    val CLAY_PLATE = ItemDishBase("clay_plate")

    val OVEN_RACK = ItemDummy("oven_rack")
}

class ItemDummy(name: String) : Item(){
    init {
        registerMe(name)
        BloodyLib.LOGGER.warn("DUMMY OBJECT exists with name $name")
    }
}