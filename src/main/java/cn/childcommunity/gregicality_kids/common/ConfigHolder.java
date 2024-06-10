package cn.childcommunity.gregicality_kids.common;

import com.cleanroommc.configanytime.ConfigAnytime;
import net.minecraftforge.common.config.Config;

@Config(modid = "GregicalityKids")
public class ConfigHolder {

    @Config.Name("Child Settings")
    public static ChildSettings child = new ChildSettings();

    @Config.Name("Child Settings")
    public static ExplosionSettings explosion = new ExplosionSettings();

    public static class ChildSettings {
        @Config.Comment("Make fluid drill progress time to 1 tick")
        public boolean enableFluidDrillChange = true;

        @Config.Comment("Make multiblock miner base chunk more")
        public boolean enableMinerChange = true;

        @Config.Comment("All recipe duration change")
        public boolean enableDurationChange = true;

        @Config.Comment("Recipe duration")
        public int duration = 2;

        @Config.Comment("Enable tool changes")
        public boolean enableToolChanges = true;

        @Config.Comment("Enable wire changes")
        public boolean enableWireChanges = true;

        @Config.Comment("Enable tank changes")
        public boolean enableTankChanges = true;

        @Config.Comment("Parallel")
        public int parallel = 10;

        public String[] recipeModifier = new String[]{
                "forge_hammer;1;1;10*",
                "macerator;1;1;10+",
                "alloy_smelter;1;1;10-",
        };
    }

    public static class ExplosionSettings {
        @Config.Comment("Disable explosion event")
        public boolean enableExplosionChange = true;
    }

    static {
        ConfigAnytime.register(ConfigHolder.class);
    }

}
