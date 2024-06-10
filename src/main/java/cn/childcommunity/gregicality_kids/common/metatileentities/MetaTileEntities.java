package cn.childcommunity.gregicality_kids.common.metatileentities;

import cn.childcommunity.gregicality_kids.GregicalityKids;
import cn.childcommunity.gregicality_kids.api.recipe.RecipeMaps;
import cn.childcommunity.gregicality_kids.common.EventHandler;
import cn.childcommunity.gregicality_kids.common.metatileentities.multi.MetaTileEntityISupermarketGenshinOP;
import cn.childcommunity.gregicality_kids.common.metatileentities.multi.MetaTileEntityQQCY;
import cn.childcommunity.gregicality_kids.common.metatileentities.multi.MetaTileEntityRainbowMiner;
import cn.childcommunity.gregicality_kids.common.metatileentities.multi.MetaTileEntityRainbowTank;
import gregtech.api.GTValues;
import gregtech.api.metatileentity.SimpleMachineMetaTileEntity;
import gregtech.client.renderer.texture.Textures;

import static cn.childcommunity.gregicality_kids.GregicalityKids.gcykId;
import static gregtech.common.metatileentities.MetaTileEntities.registerMetaTileEntity;

public class MetaTileEntities {
    public static MetaTileEntityRainbowMiner RAINBOW_MINER;
    public static MetaTileEntityRainbowTank RAINBOW_TANK;
    public static SimpleMachineMetaTileEntity NATE_MINER;
    public static MetaTileEntityQQCY QQCY;
    public static MetaTileEntityISupermarketGenshinOP OP;

    public static void init() {
        GregicalityKids.logger.info("Registering MetaTileEntities");

        RAINBOW_MINER = registerMetaTileEntity(20000,
                new MetaTileEntityRainbowMiner(gcykId("rainbow_miner")));
        RAINBOW_TANK = registerMetaTileEntity(20001,
                new MetaTileEntityRainbowTank(gcykId("rainbow_tank")));

        NATE_MINER = registerMetaTileEntity(20002,
                new SimpleMachineMetaTileEntity(gcykId("nate_miner"), RecipeMaps.NATE_MINER, Textures.ALLOY_SMELTER_OVERLAY, GTValues.LV, true));

        QQCY = registerMetaTileEntity(20003, new MetaTileEntityQQCY(gcykId("qqcy")));
        OP = registerMetaTileEntity(20004, new MetaTileEntityISupermarketGenshinOP(gcykId("op")));

        EventHandler.registerFactory();
    }

}
