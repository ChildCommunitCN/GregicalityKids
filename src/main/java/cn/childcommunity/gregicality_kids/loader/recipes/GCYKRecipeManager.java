package cn.childcommunity.gregicality_kids.loader.recipes;

import cn.childcommunity.gregicality_kids.common.ConfigHolder;
import gregtech.api.items.metaitem.MetaItem;
import gregtech.api.recipes.ModHandler;
import gregtech.api.recipes.RecipeMap;
import gregtech.api.recipes.RecipeMaps;
import gregtech.api.recipes.ingredients.GTRecipeInput;
import gregtech.common.items.MetaItem1;
import gregtech.loaders.recipe.CraftingComponent;
import net.minecraft.item.ItemStack;

import static cn.childcommunity.gregicality_kids.common.items.GCYKMetaItems.*;

public class GCYKRecipeManager {

    public static void init() {
        NateMinerRecipes.init();
        MachineRecipes.init();
        QQCYRecipes.init();
        OPRecipes.init();
        updateKit();
        RecipeMaps.EXTRUDER_RECIPES.setMaxInputs(3);
    }

    public static void modifier() {
        for (String cfg : ConfigHolder.child.recipeModifier) {
            var config = cfg.split(";");

            var map = RecipeMap.getByName(config[1]);
            var output = config[3];

            map.onRecipeBuild(builder -> {
                builder.EUt(Integer.parseInt(config[2]));
                builder.duration(Integer.parseInt(config[1]));
                builder.getAllItemOutputs().forEach(stack -> {
                    if (output.contains("*")) {
                        var multiple = Integer.parseInt(output.subSequence(0, output.length() - 1).toString());
                        stack.setCount(stack.getCount() * multiple);
                    }
                });
            });
        }
    }

    public static void generalMold() {
        for (RecipeMap<?> map : RecipeMap.getRecipeMaps()) {
            map.onRecipeBuild(builder -> {
                for (GTRecipeInput input : builder.getInputs()) {
                    for (ItemStack stack : input.getInputStacks()) {
                        if (stack.getTranslationKey().contains("shape") && stack.getItem() instanceof MetaItem1) {
                            map.recipeBuilder()
                                    .buildAndRegister();
                        }
                    }
                }
            });
        }
    }

    public static void updateKit() {
        var items = new MetaItem<?>.MetaValueItem[]{
                UPGRADE_KIT_ULV,
                UPGRADE_KIT_LV,
                UPGRADE_KIT_MV,
                UPGRADE_KIT_HV,
                UPGRADE_KIT_EV,
                UPGRADE_KIT_IV,
                UPGRADE_KIT_LuV,
                UPGRADE_KIT_ZPM,
                UPGRADE_KIT_UV,
                UPGRADE_KIT_UHV,
                UPGRADE_KIT_UEV,
                UPGRADE_KIT_UIV,
                UPGRADE_KIT_UXV,
        };
        for (int i = 0; i < items.length; i++) {
            var item = items[i];
            Object[] ptr = {
                    "AB",
                    'A', CraftingComponent.CIRCUIT.getIngredient(i),
                    'B', CraftingComponent.PLATE.getIngredient(i)
            };

            if (CraftingComponent.CIRCUIT.getIngredient(i) != null && CraftingComponent.PLATE.getIngredient(i) != null) ModHandler.addShapedRecipe(item.unlocalizedName, item.getStackForm(), ptr);
        }
    }

}
