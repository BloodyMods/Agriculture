package atm.bloodworkxgaming.agriculture.items

import atm.bloodworkxgaming.agriculture.extensions.registerMe
import net.minecraft.item.Item

class ItemDishBase(name: String) : Item(){
    init {
        registerMe(name)
    }
}