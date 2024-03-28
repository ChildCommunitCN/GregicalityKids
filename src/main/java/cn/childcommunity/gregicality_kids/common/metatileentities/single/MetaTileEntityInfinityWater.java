package cn.childcommunity.gregicality_kids.common.metatileentities.single;

import codechicken.lib.raytracer.CuboidRayTraceResult;
import codechicken.lib.render.CCRenderState;
import codechicken.lib.render.pipeline.ColourMultiplier;
import codechicken.lib.render.pipeline.IVertexOperation;
import codechicken.lib.vec.Matrix4;
import gregtech.api.GTValues;
import gregtech.api.gui.ModularUI;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.metatileentity.multiblock.IMultiblockPart;
import gregtech.api.unification.material.Materials;
import gregtech.api.util.GTUtility;
import gregtech.client.renderer.ICubeRenderer;
import gregtech.client.renderer.texture.Textures;
import gregtech.client.utils.RenderUtil;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.capability.CapabilityFluidHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.apache.commons.lang3.ArrayUtils;

import java.util.Objects;

public class MetaTileEntityInfinityWater extends MetaTileEntity {
    public MetaTileEntityInfinityWater(ResourceLocation metaTileEntityId) {
        super(metaTileEntityId);
        this.initializeInventory();
    }

    @Override
    public void update() {
        for (EnumFacing facing : EnumFacing.values()) {
            if (getNeighbor(facing) != null) {
                if (Objects.requireNonNull(getNeighbor(facing)).hasCapability(CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY, null)) {
                    Objects.requireNonNull(getNeighbor(facing)).getCapability(CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY, null).fill(Materials.Water.getFluid(1000), true);
                }
            }
        }
    }

    @Override
    public boolean onRightClick(EntityPlayer playerIn, EnumHand hand, EnumFacing facing,
                                CuboidRayTraceResult hitResult) {
        if (playerIn.getHeldItem(hand).getItem() == Items.BUCKET) {
            playerIn.setHeldItem(hand, new ItemStack(Items.WATER_BUCKET));
            return true;
        }
        return false;
    }

    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity tileEntity) {
        return new MetaTileEntityInfinityWater(metaTileEntityId);
    }

    @Override
    protected ModularUI createUI(EntityPlayer entityPlayer) {
        return null;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void renderMetaTileEntity(CCRenderState renderState, Matrix4 translation, IVertexOperation[] pipeline) {
        super.renderMetaTileEntity(renderState, translation, pipeline);
        IVertexOperation[] colouredPipeline = ArrayUtils.add(pipeline,
                new ColourMultiplier(GTUtility.convertRGBtoOpaqueRGBA_CL(getPaintingColorForRendering())));
        Textures.VOLTAGE_CASINGS[GTValues.LV].render(renderState, translation, colouredPipeline);
        Textures.INFINITE_WATER.renderSided(EnumFacing.UP, renderState, translation, colouredPipeline);
    }
}
