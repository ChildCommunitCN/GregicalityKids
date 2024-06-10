package cn.childcommunity.gregicality_kids.common;

import cn.childcommunity.gregicality_kids.GregicalityKids;
import cn.childcommunity.gregicality_kids.Tags;
import cn.childcommunity.gregicality_kids.common.items.GCYKMetaItem1;
import cn.childcommunity.gregicality_kids.common.metatileentities.single.MetaTileEntityBattery;
import cn.childcommunity.gregicality_kids.common.metatileentities.single.MetaTileEntityFactory;
import cn.childcommunity.gregicality_kids.loader.recipes.GCYKRecipeManager;
import gregtech.api.GTValues;
import gregtech.api.GregTechAPI;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.multiblock.MultiMapMultiblockController;
import gregtech.api.metatileentity.multiblock.MultiblockControllerBase;
import gregtech.api.recipes.RecipeMap;
import gregtech.api.recipes.builders.FuelRecipeBuilder;
import gregtech.common.metatileentities.MetaTileEntities;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;
import net.minecraftforge.registries.IForgeRegistry;

import javax.annotation.Nonnull;
import java.time.LocalDate;

@Mod.EventBusSubscriber(modid = Tags.MOD_ID)
public class EventHandler {

    public static final CreativeTabs TAB = new CreativeTabs("gregicality_kids") {
        @Override
        @Nonnull
        public ItemStack createIcon() {
            return new ItemStack(Items.BOOK);
        }
    };

    @SubscribeEvent
    public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
        LocalDate date = LocalDate.now();
        if (date.getMonthValue() == 6 && date.getDayOfMonth() == 1) {
            event.player.sendMessage(new TextComponentTranslation("message.gcyk.brainchildren"));
        }
    }

    @SubscribeEvent
    public static void syncConfigValues(ConfigChangedEvent.OnConfigChangedEvent event) {
        if (event.getModID().equals(Tags.MOD_ID)) {
            ConfigManager.sync(Tags.MOD_ID, Config.Type.INSTANCE);
        }
    }

    @SubscribeEvent
    public static void registerRecipes(RegistryEvent.Register<IRecipe> event) {
        GregicalityKids.logger.info("Registering recipes");

        GCYKRecipeManager.init();
    }

    public static void registerFactory() {
        int id = 30000;

        for (MetaTileEntity metaTileEntity : GregTechAPI.MTE_REGISTRY) {
            if (metaTileEntity instanceof MultiblockControllerBase multi) {
                if (multi.getRecipeMap() != null && !multi.metaTileEntityId.getNamespace().equals(Tags.MOD_ID)) {

                    if (multi.getRecipeMap().recipeBuilder() instanceof FuelRecipeBuilder) {
                        MetaTileEntities.registerMetaTileEntity(id++, new MetaTileEntityBattery(multi, GTValues.MAX));
                    }

                    if (multi instanceof MultiMapMultiblockController multiMap) {
                        for (RecipeMap<?> map : multiMap.getAvailableRecipeMaps()) {
                            MetaTileEntities.registerMetaTileEntity(id++, new MetaTileEntityFactory(multi, map, GTValues.MAX));
                        }
                    } else {
                        MetaTileEntities.registerMetaTileEntity(id++, new MetaTileEntityFactory(multi, GTValues.MAX));
                    }
                }
            }
        }
    }

    @SubscribeEvent
    public void registerItems(RegistryEvent.Register<Item> event) {
        IForgeRegistry<Item> registry = event.getRegistry();
        GCYKMetaItem1.registerItems();
    }

}
