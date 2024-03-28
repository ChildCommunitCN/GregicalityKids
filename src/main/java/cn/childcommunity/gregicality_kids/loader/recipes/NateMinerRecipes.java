package cn.childcommunity.gregicality_kids.loader.recipes;

import cn.childcommunity.gregicality_kids.api.recipe.RecipeMaps;
import gregtech.api.GregTechAPI;
import gregtech.api.metatileentity.multiblock.MultiblockAbility;
import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.material.Material;
import gregtech.api.unification.material.properties.PropertyKey;
import gregtech.api.unification.material.registry.MaterialRegistry;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.api.util.GTTransferUtils;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.IItemHandlerModifiable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class NateMinerRecipes {

    public static void init() {
        for (MaterialRegistry registry : GregTechAPI.materialManager.getRegistries()) {
            for (Material material : registry.getAllMaterials()) {
                if (material.hasProperty(PropertyKey.ORE)) {
                    var stack = OreDictUnifier.get(OrePrefix.ore, material);
                    RecipeMaps.NATE_MINER.recipeBuilder()
                            .EUt(5).duration(1)
                            .notConsumable(OrePrefix.ore, material)
                            .output(OrePrefix.ore, material, 64)
                            .buildAndRegister();
                }
            }
        }
    }

}
