package cn.childcommunity.gregicality_kids.common.items.behaviors;

import cn.childcommunity.gregicality_kids.common.metatileentities.MetaTileEntities;
import gregtech.api.items.metaitem.stats.IItemBehaviour;
import gregtech.api.metatileentity.ITieredMetaTileEntity;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.MetaTileEntityHolder;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class UpgradeKitBehavior implements IItemBehaviour {

    private String targetTier;

    public UpgradeKitBehavior(String targetTier) {
        this.targetTier = targetTier;
    }

    @Override
    public EnumActionResult onItemUseFirst(EntityPlayer player, World world, BlockPos pos, EnumFacing side, float hitX,
                                            float hitY, float hitZ, EnumHand hand) {
        TileEntity tileEntity = world.getTileEntity(pos);
        if (!(tileEntity instanceof IGregTechTileEntity)) return EnumActionResult.PASS;
        MetaTileEntity mte = ((IGregTechTileEntity) tileEntity).getMetaTileEntity();
        if (mte instanceof ITieredMetaTileEntity tieredMTE) {
            world.setBlockToAir(pos);
            world.removeTileEntity(pos);

            ((MetaTileEntityHolder) tileEntity).setMetaTileEntity(MetaTileEntities.INF_WATER);
        }

        return EnumActionResult.PASS;
    }

}
