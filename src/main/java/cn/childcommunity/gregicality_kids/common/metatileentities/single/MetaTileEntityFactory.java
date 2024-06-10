package cn.childcommunity.gregicality_kids.common.metatileentities.single;

import gregtech.api.metatileentity.SimpleMachineMetaTileEntity;
import gregtech.api.metatileentity.multiblock.MultiMapMultiblockController;
import gregtech.api.metatileentity.multiblock.MultiblockControllerBase;
import gregtech.api.recipes.RecipeMap;
import gregtech.api.util.GTUtility;
import gregtech.client.renderer.texture.Textures;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Objects;

public class MetaTileEntityFactory extends SimpleMachineMetaTileEntity {

    public MultiblockControllerBase multi;
    public boolean isMultiMap = false;

    public MetaTileEntityFactory(MultiblockControllerBase multi, int tier) {
        super(new ResourceLocation("gregicality_kids", multi.metaTileEntityId.getPath()),
                multi.getRecipeMap(),
                Textures.ASSEMBLER_OVERLAY,
                tier,
                multi.hasFrontFacing(),
                GTUtility.largeTankSizeFunction
        );
        this.multi = multi;
    }

    public MetaTileEntityFactory(MultiblockControllerBase multi, RecipeMap<?> map, int tier) {
        super(new ResourceLocation("gregicality_kids", multi instanceof MultiMapMultiblockController ? multi.metaTileEntityId.getPath() + "_recipemap_" + map.unlocalizedName : multi.metaTileEntityId.getPath()),
                map,
                Textures.ASSEMBLER_OVERLAY,
                tier,
                multi.hasFrontFacing(),
                GTUtility.largeTankSizeFunction
        );
        this.multi = multi;
        isMultiMap = true;
    }

    public String getMetaName() {
        return multi.getMetaName();
    }

    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World player, List<String> tooltip, boolean advanced) {
        super.addInformation(stack, player, tooltip, advanced);
        tooltip.add(1, I18n.format("gregicality_kids.info.single_factories", Objects.requireNonNull(getRecipeMap()).getLocalizedName()));
    }

}
