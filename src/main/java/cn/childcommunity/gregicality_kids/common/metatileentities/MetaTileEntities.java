package cn.childcommunity.gregicality_kids.common.metatileentities;

import cn.childcommunity.gregicality_kids.GregicalityKids;
import cn.childcommunity.gregicality_kids.common.metatileentities.multi.MetaTileEntityNateMiner;
import cn.childcommunity.gregicality_kids.common.metatileentities.multi.MetaTileEntityRainbowMiner;
import cn.childcommunity.gregicality_kids.common.metatileentities.multi.MetaTileEntityRainbowTank;
import cn.childcommunity.gregicality_kids.common.metatileentities.single.MetaTileEntityInfinityWater;

import static cn.childcommunity.gregicality_kids.GregicalityKids.gcykId;
import static gregtech.common.metatileentities.MetaTileEntities.registerMetaTileEntity;

public class MetaTileEntities {

    public static MetaTileEntityInfinityWater INF_WATER;

    public static MetaTileEntityRainbowMiner RAINBOW_MINER;
    public static MetaTileEntityRainbowTank RAINBOW_TANK;

    public static MetaTileEntityNateMiner NATE_MINER;

    public static void init() {
        GregicalityKids.logger.info("Registering MetaTileEntities");
        INF_WATER = registerMetaTileEntity(19999,
                new MetaTileEntityInfinityWater(gcykId("inf_water")));

        RAINBOW_MINER = registerMetaTileEntity(20000,
                new MetaTileEntityRainbowMiner(gcykId("rainbow_miner")));
        RAINBOW_TANK = registerMetaTileEntity(20001,
                new MetaTileEntityRainbowTank(gcykId("rainbow_tank")));
        NATE_MINER = registerMetaTileEntity(20002,
                new MetaTileEntityNateMiner(gcykId("nate_miner")));

    }

}
