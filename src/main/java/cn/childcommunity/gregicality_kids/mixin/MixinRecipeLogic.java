package cn.childcommunity.gregicality_kids.mixin;

import cn.childcommunity.gregicality_kids.common.ConfigHolder;
import gregtech.api.capability.impl.AbstractRecipeLogic;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = AbstractRecipeLogic.class, remap = false)
public abstract class MixinRecipeLogic {

    @Shadow public abstract void setParallelLimit(int amount);

    @Inject(method = "getParallelLimit", at = @At("HEAD"))
    private void injected(CallbackInfoReturnable<Integer> cir) {
        setParallelLimit(ConfigHolder.child.parallel);
    }

}
