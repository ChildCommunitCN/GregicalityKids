package cn.childcommunity.gregicality_kids.common.metatileentities.single;

import gregtech.api.metatileentity.SimpleGeneratorMetaTileEntity;
import gregtech.api.metatileentity.multiblock.MultiblockControllerBase;
import gregtech.api.util.GTUtility;
import gregtech.client.renderer.texture.Textures;
import net.minecraft.util.ResourceLocation;

public class MetaTileEntityBattery extends SimpleGeneratorMetaTileEntity {

    public MultiblockControllerBase multi;

    public MetaTileEntityBattery(MultiblockControllerBase multi, int tier) {
        super(new ResourceLocation("gregicality_kids", multi.metaTileEntityId.getPath())
                , multi.getRecipeMap(), Textures.ASSEMBLER_OVERLAY, tier, GTUtility.largeTankSizeFunction);
        this.multi = multi;
    }

    public String getMetaName() {
        return multi.getMetaName();
    }


}
