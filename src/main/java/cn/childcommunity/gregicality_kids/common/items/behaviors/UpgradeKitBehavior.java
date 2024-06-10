package cn.childcommunity.gregicality_kids.common.items.behaviors;

import gregtech.api.GTValues;
import gregtech.api.GregTechAPI;
import gregtech.api.items.metaitem.stats.IItemBehaviour;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.SimpleMachineMetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class UpgradeKitBehavior implements IItemBehaviour {

    private final int targetTier;

    public UpgradeKitBehavior(int targetTier) {
        this.targetTier = targetTier;
    }

    public static String toVolName(int vol) {
        return GTValues.VN[vol].toLowerCase();
    }

    @Override
    public EnumActionResult onItemUseFirst(EntityPlayer player, World world, BlockPos pos, EnumFacing side, float hitX,
                                            float hitY, float hitZ, EnumHand hand) {
        TileEntity tileEntity = world.getTileEntity(pos);
        if (!(tileEntity instanceof IGregTechTileEntity)) return EnumActionResult.PASS;
        MetaTileEntity mte = ((IGregTechTileEntity) tileEntity).getMetaTileEntity();

        if (mte instanceof SimpleMachineMetaTileEntity machineMetaTileEntity) {
            if (machineMetaTileEntity.getTier() + 1 == targetTier) {
                var machine = GregTechAPI.MTE_REGISTRY.getObject(new ResourceLocation(machineMetaTileEntity.metaTileEntityId.toString().replace(toVolName(machineMetaTileEntity.getTier()), toVolName(targetTier))));
                ((IGregTechTileEntity) tileEntity).setMetaTileEntity(machine);
            }
        }

        return EnumActionResult.PASS;
    }

}
