package cn.childcommunity.gregicality_kids.api.recipe;

import gregtech.api.recipes.RecipeMap;
import gregtech.api.recipes.builders.SimpleRecipeBuilder;

public class RecipeMaps {

    public static final RecipeMap<SimpleRecipeBuilder> NATE_MINER = new RecipeMap<>("nate_miner", 1, 4, 0, 0,
            new SimpleRecipeBuilder(), false);

    public static final RecipeMap<SimpleRecipeBuilder> QQCY = new RecipeMap<>("qqcy", 2, 40, 0, 5, new SimpleRecipeBuilder(), false);
    public static final RecipeMap<SimpleRecipeBuilder> OP = new RecipeMap<>("op", 2, 10, 1, 5, new SimpleRecipeBuilder(), false);

}
