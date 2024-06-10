package cn.childcommunity.gregicality_kids.loader.recipes;

import cn.childcommunity.gregicality_kids.common.metatileentities.MetaTileEntities;
import cn.childcommunity.gregicality_kids.common.metatileentities.single.MetaTileEntityBattery;
import cn.childcommunity.gregicality_kids.common.metatileentities.single.MetaTileEntityFactory;
import gregtech.api.GregTechAPI;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.recipes.ModHandler;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class MachineRecipes {

    public static void init() {
        ModHandler.addSmeltingRecipe(new ItemStack(Items.STONE_PICKAXE), MetaTileEntities.RAINBOW_MINER.getStackForm());
        ModHandler.addSmeltingRecipe(MetaTileEntities.RAINBOW_MINER.getStackForm(), MetaTileEntities.NATE_MINER.getStackForm());
        ModHandler.addSmeltingRecipe(new ItemStack(Items.BUCKET), MetaTileEntities.RAINBOW_TANK.getStackForm());

        ModHandler.addSmeltingRecipe(new ItemStack(Blocks.FURNACE), MetaTileEntities.OP.getStackForm());
        ModHandler.addSmeltingRecipe(new ItemStack(Blocks.DIRT), MetaTileEntities.QQCY.getStackForm());

        for (MetaTileEntity mte : GregTechAPI.MTE_REGISTRY) {
            if (mte instanceof MetaTileEntityFactory factory) {
                ModHandler.addShapelessRecipe(factory.metaTileEntityId.toString(), factory.getStackForm(), factory.multi.getStackForm());
            }
            if (mte instanceof MetaTileEntityBattery factory) ModHandler.addShapelessRecipe(factory.metaTileEntityId.toString(), factory.getStackForm(), factory.multi.getStackForm());
        }
    }

}
