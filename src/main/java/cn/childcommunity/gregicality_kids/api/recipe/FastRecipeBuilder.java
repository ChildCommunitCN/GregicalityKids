package cn.childcommunity.gregicality_kids.api.recipe;

import gregtech.api.recipes.RecipeBuilder;

public class FastRecipeBuilder extends RecipeBuilder<FastRecipeBuilder> {

    @Override
    public void buildAndRegister() {
        EUt(1).duration(1);
        super.buildAndRegister();
    }

}
