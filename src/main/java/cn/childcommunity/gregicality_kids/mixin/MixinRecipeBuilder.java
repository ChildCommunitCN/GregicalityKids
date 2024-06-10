package cn.childcommunity.gregicality_kids.mixin;

import cn.childcommunity.gregicality_kids.common.ConfigHolder;
import gregtech.api.recipes.RecipeBuilder;
import gregtech.api.recipes.builders.FuelRecipeBuilder;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value = RecipeBuilder.class, remap = false)
public abstract class MixinRecipeBuilder {

    @Shadow protected int duration;

    @Redirect(method = "duration", at = @At(value = "FIELD", target = "Lgregtech/api/recipes/RecipeBuilder;duration:I", opcode = Opcodes.PUTFIELD))
    private void injected(RecipeBuilder instance, int value) {
        if (ConfigHolder.child.enableDurationChange) {
            if (instance instanceof FuelRecipeBuilder) {
                duration = value * 5;
            } else {
                duration = ConfigHolder.child.duration;
            }
        }
    }

}
