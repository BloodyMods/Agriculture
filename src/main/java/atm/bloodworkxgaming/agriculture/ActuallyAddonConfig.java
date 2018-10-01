package atm.bloodworkxgaming.agriculture;

import net.minecraftforge.common.config.Config;

@Config(modid = Agriculture.MOD_ID, name = "bloodymods/agriculture")
public class ActuallyAddonConfig {
    @Config.Comment("How much more energy than a normal reconstructor it should use")
    public static double energyModifier = 1.5;

    @Config.Comment("How long to wait in between checking for new items")
    public static int sleepTime = 20;

    public static AdvancedReconstructor advancedReconstructor = new AdvancedReconstructor();
    public static AdvancedFluidizer advancedFluidizer = new AdvancedFluidizer();

    public static class AdvancedReconstructor  {
        public int maxPowerCapacity = 10000;
        public int maxPowerIn = 10000;
    }

    public static class AdvancedFluidizer {
        public int powerPerStep = 100;
        public int fluidCapacity = 10000;
        public int maxPowerCapacity = 10000;
        public int maxPowerIn = 10000;
    }
}
