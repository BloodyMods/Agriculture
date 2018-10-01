package atm.bloodworkxgaming.agriculture.items.food

import atm.bloodworkxgaming.agriculture.extensions.registerMe
import net.minecraft.item.ItemFood

class BaseFoodItem(name: String, value: Int, saturation: Float, isWolfFood: Boolean = false) : ItemFood(value, saturation, isWolfFood) {
    init {
        registerMe(name)
    }
}