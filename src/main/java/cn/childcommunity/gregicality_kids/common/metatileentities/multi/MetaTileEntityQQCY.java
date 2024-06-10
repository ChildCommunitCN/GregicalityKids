package cn.childcommunity.gregicality_kids.common.metatileentities.multi;

import cn.childcommunity.gregicality_kids.api.recipe.RecipeMaps;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.metatileentity.multiblock.IMultiblockPart;
import gregtech.api.metatileentity.multiblock.RecipeMapMultiblockController;
import gregtech.api.pattern.BlockPattern;
import gregtech.api.pattern.FactoryBlockPattern;
import gregtech.client.renderer.ICubeRenderer;
import gregtech.client.renderer.texture.Textures;
import net.minecraft.init.Blocks;
import net.minecraft.util.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public class MetaTileEntityQQCY extends RecipeMapMultiblockController {
    public MetaTileEntityQQCY(ResourceLocation metaTileEntityId) {
        super(metaTileEntityId, RecipeMaps.QQCY);
    }

    @Override
    protected @NotNull BlockPattern createStructurePattern() {
        return FactoryBlockPattern.start()
                .aisle("AAAAA")
                .aisle("AAAAA")
                .aisle("AAAAA")
                .aisle("AAAAA")
                .aisle("AASAA")
                .where('S', selfPredicate())
                .where('A', blocks(Blocks.IRON_BLOCK).or(autoAbilities(true, true, true, true, true, true, false)))
                .build();
    }

    @Override
    public ICubeRenderer getBaseTexture(IMultiblockPart iMultiblockPart) {
        return Textures.SOLID_STEEL_CASING;
    }

    @Override
    protected @NotNull ICubeRenderer getFrontOverlay() {
        return Textures.ALLOY_SMELTER_OVERLAY;
    }

    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity iGregTechTileEntity) {
        return new MetaTileEntityQQCY(metaTileEntityId);
    }
}
