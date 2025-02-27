package cn.childcommunity.gregicality_kids.loader.recipes;

import cn.childcommunity.gregicality_kids.api.recipe.RecipeMaps;
import gregtech.api.GregTechAPI;
import gregtech.api.unification.material.Material;
import gregtech.api.unification.material.properties.PropertyKey;
import gregtech.api.unification.material.registry.MaterialRegistry;
import gregtech.api.unification.ore.OrePrefix;

public class NateMinerRecipes {

    public static void init() {
        for (MaterialRegistry registry : GregTechAPI.materialManager.getRegistries()) {
            for (Material material : registry.getAllMaterials()) {
                if (material.hasProperty(PropertyKey.ORE)) {
                    RecipeMaps.NATE_MINER.recipeBuilder()
                            .EUt(1).duration(1)
                            .notConsumable(OrePrefix.ore, material)
                            .output(OrePrefix.ore, material, 256)
                            .buildAndRegister();
                }
            }
        }
    }

}
