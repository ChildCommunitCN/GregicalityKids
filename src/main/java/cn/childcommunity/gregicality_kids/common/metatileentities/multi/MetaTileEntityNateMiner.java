package cn.childcommunity.gregicality_kids.common.metatileentities.multi;

import cn.childcommunity.gregicality_kids.api.recipe.RecipeMaps;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.metatileentity.multiblock.IMultiblockPart;
import gregtech.api.metatileentity.multiblock.MultiblockAbility;
import gregtech.api.metatileentity.multiblock.RecipeMapMultiblockController;
import gregtech.api.pattern.BlockPattern;
import gregtech.api.pattern.FactoryBlockPattern;
import gregtech.client.renderer.ICubeRenderer;
import gregtech.client.renderer.texture.Textures;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.jetbrains.annotations.NotNull;

public class MetaTileEntityNateMiner extends RecipeMapMultiblockController {
    public MetaTileEntityNateMiner(ResourceLocation metaTileEntityId) {
        super(metaTileEntityId, RecipeMaps.NATE_MINER);
    }

    public boolean hasMaintenanceMechanics() {
        return false;
    }

    @Override
    protected void updateFormedValid() {}

    @Override
    protected @NotNull BlockPattern createStructurePattern() {
        return FactoryBlockPattern.start()
                .aisle("ABC", "#D#")
                .where('A', abilities(MultiblockAbility.IMPORT_ITEMS))
                .where('B', selfPredicate())
                .where('C', abilities(MultiblockAbility.EXPORT_ITEMS))
                .where('D', abilities(MultiblockAbility.INPUT_ENERGY))
                .where('#', any())
                .build();
    }

    @Override
    @SideOnly(Side.CLIENT)
    public ICubeRenderer getBaseTexture(IMultiblockPart sourcePart) {
        return Textures.SOLID_STEEL_CASING;
    }

    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity tileEntity) {
        return new MetaTileEntityNateMiner(metaTileEntityId);
    }

    @SideOnly(Side.CLIENT)
    protected @NotNull ICubeRenderer getFrontOverlay() {
        return Textures.ASSEMBLER_OVERLAY;
    }
}
