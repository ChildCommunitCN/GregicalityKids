package cn.childcommunity.gregicality_kids.common;

import cn.childcommunity.gregicality_kids.GregicalityKids;
import cn.childcommunity.gregicality_kids.Tags;
import cn.childcommunity.gregicality_kids.common.items.GCYKMetaItems;
import cn.childcommunity.gregicality_kids.loader.recipes.GCYKRecipeManager;
import gregicality.multiblocks.GregicalityMultiblocks;
import gregicality.multiblocks.api.utils.GCYMLog;
import gregicality.multiblocks.loaders.recipe.GCYMRecipeLoader;
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

    @SubscribeEvent
    public void registerItems(RegistryEvent.Register<Item> event) {
        GCYKMetaItems.registerSubItems();
    }

}
