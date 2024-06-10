package cn.childcommunity.gregicality_kids.loader.recipes;

import cn.childcommunity.gregicality_kids.api.recipe.RecipeMaps;
import gregtech.common.blocks.MetaBlocks;
import gregtech.common.items.MetaItems;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class QQCYRecipes {

    public static void init() {
        tree();
        animals();
        crops();
        hostile();
    }

    private static void hostile() {
        RecipeMaps.QQCY.recipeBuilder()
                .circuitMeta(20)
                .outputs(
                        new ItemStack(Items.STRING, 64),
                        new ItemStack(Items.GUNPOWDER, 64),
                        new ItemStack(Items.SLIME_BALL, 64),

                        new ItemStack(Items.BONE, 64),
                        new ItemStack(Items.ENDER_PEARL, 64),
                        new ItemStack(Items.BLAZE_ROD, 64),
                        new ItemStack(Items.NETHER_STAR, 1),
                        new ItemStack(Items.ROTTEN_FLESH, 64)
                )
                .EUt(1).duration(1).buildAndRegister();
    }

    private static void crops() {
        RecipeMaps.QQCY.recipeBuilder()
                .circuitMeta(15)
                .outputs(
                        new ItemStack(Items.WHEAT, 64),
                        new ItemStack(Items.WHEAT_SEEDS, 64),
                        new ItemStack(Items.REEDS, 64),

                        new ItemStack(Items.PUMPKIN_SEEDS, 64),
                        new ItemStack(Blocks.PUMPKIN, 64),
                        new ItemStack(Items.MELON_SEEDS, 64),
                        new ItemStack(Blocks.MELON_BLOCK, 64),
                        new ItemStack(Items.MELON, 64),

                        new ItemStack(Items.NETHER_WART, 64),
                        new ItemStack(Items.CHORUS_FRUIT, 64),

                        new ItemStack(Blocks.CACTUS, 64),
                        new ItemStack(Items.APPLE, 64),

                        new ItemStack(Items.CARROT, 64),
                        new ItemStack(Items.POTATO, 64),
                        new ItemStack(Items.BAKED_POTATO, 64),

                        new ItemStack(Items.BEETROOT_SEEDS, 64),
                        new ItemStack(Items.BEETROOT, 64),
                        new ItemStack(Items.DYE, 64, 3),
                        new ItemStack(Blocks.VINE, 64),
                        new ItemStack(Blocks.WATERLILY, 64)
                )
                .EUt(1).duration(1).buildAndRegister();
    }

    private static void animals() {
        RecipeMaps.QQCY.recipeBuilder()
                .circuitMeta(10)
                .outputs(
                        new ItemStack(Items.COOKED_CHICKEN, 64),
                        new ItemStack(Items.CHICKEN, 64),
                        new ItemStack(Items.FEATHER, 64),

                        new ItemStack(Items.COOKED_BEEF, 64),
                        new ItemStack(Items.BEEF, 64),
                        new ItemStack(Items.LEATHER, 64),

                        new ItemStack(Items.COOKED_PORKCHOP, 64),
                        new ItemStack(Items.PORKCHOP, 64),

                        new ItemStack(Items.FISH, 64),
                        new ItemStack(Items.COOKED_FISH, 64),

                        new ItemStack(Items.RABBIT, 64),
                        new ItemStack(Items.COOKED_RABBIT, 64),

                        new ItemStack(Items.COOKED_MUTTON, 64),
                        new ItemStack(Items.MUTTON, 64),
                        new ItemStack(Blocks.WOOL, 64),

                        new ItemStack(Items.DYE, 64),
                        new ItemStack(Items.FISH, 64, 1),
                        new ItemStack(Items.FISH, 64, 2),

                        new ItemStack(Items.FISH, 64, 3),
                        new ItemStack(Items.COOKED_FISH, 64, 1),
                        new ItemStack(Items.EGG, 64)
                )
                .EUt(1).duration(1).buildAndRegister();
    }

    private static void tree() {
        RecipeMaps.QQCY.recipeBuilder()
                .circuitMeta(1)
                .notConsumable(new ItemStack(Blocks.SAPLING))
                .outputs(
                        new ItemStack(Blocks.LOG, 64),
                        new ItemStack(Blocks.SAPLING, 64)
                )
                .EUt(1).duration(1).buildAndRegister();

        RecipeMaps.QQCY.recipeBuilder()
                .circuitMeta(2)
                .notConsumable(new ItemStack(Blocks.SAPLING, 1))
                .outputs(
                        new ItemStack(Blocks.LOG, 64, 1),
                        new ItemStack(Blocks.SAPLING, 64, 1)
                )
                .EUt(1).duration(1).buildAndRegister();

        RecipeMaps.QQCY.recipeBuilder()
                .circuitMeta(3)
                .notConsumable(new ItemStack(Blocks.SAPLING, 2))
                .outputs(
                        new ItemStack(Blocks.LOG, 64, 2),
                        new ItemStack(Blocks.SAPLING, 64, 2)
                )
                .EUt(1).duration(1).buildAndRegister();

        RecipeMaps.QQCY.recipeBuilder()
                .circuitMeta(4)
                .notConsumable(new ItemStack(Blocks.SAPLING, 3))
                .outputs(
                        new ItemStack(Blocks.LOG, 64, 3),
                        new ItemStack(Blocks.SAPLING, 64, 3)
                )
                .EUt(1).duration(1).buildAndRegister();

        RecipeMaps.QQCY.recipeBuilder()
                .circuitMeta(5)
                .notConsumable(new ItemStack(Blocks.SAPLING, 4))
                .outputs(
                        new ItemStack(Blocks.LOG2, 64, 0),
                        new ItemStack(Blocks.SAPLING, 64, 4)
                )
                .EUt(1).duration(1).buildAndRegister();

        RecipeMaps.QQCY.recipeBuilder()
                .circuitMeta(6)
                .notConsumable(new ItemStack(Blocks.SAPLING, 5))
                .outputs(
                        new ItemStack(Blocks.LOG2, 64, 1),
                        new ItemStack(Blocks.SAPLING, 64, 5)
                )
                .EUt(1).duration(1).buildAndRegister();

        RecipeMaps.QQCY.recipeBuilder()
                .circuitMeta(7)
                .notConsumable(new ItemStack(MetaBlocks.RUBBER_SAPLING))
                .outputs(
                        new ItemStack(MetaBlocks.RUBBER_LOG, 64),
                        new ItemStack(MetaBlocks.RUBBER_SAPLING, 64),
                        MetaItems.STICKY_RESIN.getStackForm(64)
                )
                .EUt(1).duration(1).buildAndRegister();
    }

}
