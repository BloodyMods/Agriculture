package atm.bloodworkxgaming.agriculture.blocks.machines

import atm.bloodworkxgaming.agriculture.Agriculture
import atm.bloodworkxgaming.agriculture.ownLocation
import net.minecraft.tileentity.TileEntity
import net.minecraft.util.EnumFacing
import net.minecraftforge.client.model.animation.Animation
import net.minecraftforge.common.animation.TimeValues
import net.minecraftforge.common.capabilities.Capability
import net.minecraftforge.common.model.animation.CapabilityAnimation
import net.minecraftforge.client.model.animation.Animation.getPartialTickTime
import net.minecraftforge.client.model.animation.AnimationTESR
import net.minecraftforge.common.animation.Event


class TileCounter : TileEntity() {
    private val cycleLength = TimeValues.VariableValue(4f)
    private val clickTime = TimeValues.VariableValue(Float.NEGATIVE_INFINITY)
    private val asm = Agriculture.proxy.loadASM(ownLocation("asms/block/counter.json"),
            mapOf("cycle_length" to cycleLength, "click_time" to clickTime))

    override fun hasFastRenderer(): Boolean {
        return true
    }

    override fun hasCapability(capability: Capability<*>, facing: EnumFacing?): Boolean {
        return capability == CapabilityAnimation.ANIMATION_CAPABILITY || super.hasCapability(capability, facing)
    }

    override fun <T : Any?> getCapability(capability: Capability<T>, facing: EnumFacing?): T? {
        return when (capability) {
            CapabilityAnimation.ANIMATION_CAPABILITY -> CapabilityAnimation.ANIMATION_CAPABILITY.cast(asm)
            else -> super.getCapability(capability, facing)
        }
    }

    fun click(sneaking: Boolean) {
        if (asm != null) {
            println("asm = ${asm.currentState()} cycle = $cycleLength")

            when {
                sneaking -> cycleLength.setValue(6 - cycleLength.apply(0f))

                asm.currentState() == "default" -> {
                    val time = Animation.getWorldTime(getWorld(), Animation.getPartialTickTime())
                    clickTime.setValue(time)
                    //offset.setValue(time);
                    //asm.transition("moving");
                    asm.transition("starting")
                }

                asm.currentState() == "moving" -> {
                    clickTime.setValue(Animation.getWorldTime(getWorld(), Animation.getPartialTickTime()))
                    asm.transition("stopping")
                }


                /*else if(asm.currentState().equals("closed"))
                    {
                        clickTime.setValue(Animation.getWorldTime(getWorld()));
                        asm.transition("opening");
                    }
                    else if(asm.currentState().equals("open"))
                    {
                        clickTime.setValue(Animation.getWorldTime(getWorld()));
                        asm.transition("closing");
                    }*/
            }


            /*else if(asm.currentState().equals("closed"))
                {
                    clickTime.setValue(Animation.getWorldTime(getWorld()));
                    asm.transition("opening");
                }
                else if(asm.currentState().equals("open"))
                {
                    clickTime.setValue(Animation.getWorldTime(getWorld()));
                    asm.transition("closing");
                }*/
        }
    }

    fun handleEvents(time: Float, pastEvents: MutableIterable<Event>) {
        for (event in pastEvents) {
            println("Event: ${event.event()} ${event.offset()} ${getPos()} $time")
        }
    }
}

class SpecialRendererCounter : AnimationTESR<TileCounter>() {
    override fun handleEvents(te: TileCounter, time: Float, pastEvents: MutableIterable<Event>) {
        te.handleEvents(time, pastEvents)
    }
}