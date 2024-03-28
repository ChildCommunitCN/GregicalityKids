package cn.childcommunity.gregicality_kids.mixin.accessor;

import gregtech.api.capability.impl.FluidDrillLogic;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value = FluidDrillLogic.class, remap = false)
public interface AccessorFluidDrillLogic {
    @Accessor("MAX_PROGRESS")
    public static void setMaxProgress(int arg) {
        throw new AssertionError();
    }
}
