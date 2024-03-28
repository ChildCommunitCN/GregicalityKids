package cn.childcommunity.gregicality_kids.common.metatileentities.multi;

import cn.childcommunity.gregicality_kids.api.metatileentity.multi.RainbowMultiMetaTileEntity;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

import java.util.ArrayList;
import java.util.List;

public class MetaTileEntityRainbowTank extends RainbowMultiMetaTileEntity {
    public MetaTileEntityRainbowTank(ResourceLocation metaTileEntityId) {
        super(metaTileEntityId, false);

        List<FluidStack> stacks = new ArrayList<>();
        for (Fluid fluid : FluidRegistry.getRegisteredFluids().values()) {
            stacks.add(new FluidStack(fluid, 1));
        }
        setOutput(new ArrayList<>(), stacks);
    }

    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity tileEntity) {
        return new MetaTileEntityRainbowTank(this.metaTileEntityId);
    }

    protected void updateFormedValid() {
    }
}
