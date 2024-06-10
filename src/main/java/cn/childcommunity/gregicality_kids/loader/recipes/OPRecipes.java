package cn.childcommunity.gregicality_kids.loader.recipes;

import cn.childcommunity.gregicality_kids.api.recipe.RecipeMaps;
import gregtech.api.GregTechAPI;
import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.material.Material;
import gregtech.api.unification.material.properties.PropertyKey;
import gregtech.api.unification.material.registry.MaterialRegistry;
import gregtech.api.unification.ore.OrePrefix;
import net.minecraft.item.ItemStack;

import java.util.ArrayList;

public class OPRecipes {

    public static void init() {
        for (MaterialRegistry registry : GregTechAPI.materialManager.getRegistries()) {
            for (Material material : registry.getAllMaterials()) {
                if (material.hasProperty(PropertyKey.ORE)) {
                    var other = new ArrayList<ItemStack>();
                    material.getProperty(PropertyKey.ORE).getOreByProducts().forEach((material1 -> other.add(OreDictUnifier.get(OrePrefix.dust, material1, 16))));

                    RecipeMaps.OP.recipeBuilder()
                            .input(OrePrefix.ore, material)
                            .output(material.hasProperty(PropertyKey.INGOT) ? OrePrefix.ingot : OrePrefix.dust, material, 64)
                            .outputs(other)
                            .EUt(1).duration(1)
                            .buildAndRegister();
                }
            }
        }
    }

}
