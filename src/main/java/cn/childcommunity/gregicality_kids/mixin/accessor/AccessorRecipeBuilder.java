package cn.childcommunity.gregicality_kids.mixin.accessor;

import gregtech.api.recipes.RecipeBuilder;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value = RecipeBuilder.class, remap = false)
public interface AccessorRecipeBuilder {

    @Accessor("duration")
    public void setDuration(int arg);

}
