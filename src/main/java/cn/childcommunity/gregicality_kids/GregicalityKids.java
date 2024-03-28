package cn.childcommunity.gregicality_kids;

import cn.childcommunity.gregicality_kids.common.ConfigHolder;
import cn.childcommunity.gregicality_kids.common.items.GCYKMetaItems;
import cn.childcommunity.gregicality_kids.common.metatileentities.MetaTileEntities;
import cn.childcommunity.gregicality_kids.mixin.accessor.AccessorFluidDrillLogic;
import cn.childcommunity.gregicality_kids.mixin.accessor.AccessorGTUtility;
import cn.childcommunity.gregicality_kids.mixin.accessor.AccessorMultiblockMinerLogic;
import gregtech.GTInternalTags;
import gregtech.api.GTValues;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLConstructionEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(
        modid = Tags.MOD_ID,
        name = Tags.MOD_NAME,
        version = Tags.VERSION,
        dependencies = "required-after:gregtech;"
)
public class GregicalityKids {
    public static final Logger logger = LogManager.getLogger(Tags.MOD_ID);

    public static ResourceLocation gcykId(String path) {
        return new ResourceLocation(Tags.MOD_ID, path);
    }

    @Mod.EventHandler
    public void onPreInit(FMLPreInitializationEvent event) {
        MetaTileEntities.init();
        GCYKMetaItems.init();
    }


    static {
        if (ConfigHolder.child.enableFluidDrillChange) AccessorFluidDrillLogic.setMaxProgress(1);
        if (ConfigHolder.child.enableMinerChange) AccessorMultiblockMinerLogic.setChunkLength(64);

        if (ConfigHolder.child.enableTankChanges) {
            AccessorGTUtility.setDefaultTankSizeFunction(tier -> {
                if (tier <= GTValues.LV)
                    return 8000000;
                if (tier == GTValues.MV)
                    return 12000000;
                if (tier == GTValues.HV)
                    return 16000000;
                if (tier == GTValues.EV)
                    return 32000000;
                // IV+
                return 64000000;
            });
            AccessorGTUtility.setHvCappedTankSizeFunction(tier -> {
                if (tier <= GTValues.LV)
                    return 8000000;
                if (tier == GTValues.MV)
                    return 12000000;
                // HV+
                return 16000000;
            });
            AccessorGTUtility.setLargeTankSizeFunction(tier -> {
                if (tier <= GTValues.LV)
                    return 32000000;
                if (tier == GTValues.MV)
                    return 48000000;
                // HV+
                return 64000000;
            });
        }
    }

}
