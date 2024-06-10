package cn.childcommunity.gregicality_kids.common.items;

import cn.childcommunity.gregicality_kids.common.items.behaviors.UpgradeKitBehavior;
import gregtech.api.GregTechAPI;
import gregtech.api.items.metaitem.MetaItem;
import gregtech.api.items.metaitem.StandardMetaItem;
import gregtech.common.items.behaviors.TooltipBehavior;
import net.minecraft.client.resources.I18n;

import static cn.childcommunity.gregicality_kids.common.items.GCYKMetaItems.*;
import static cn.childcommunity.gregicality_kids.common.items.behaviors.UpgradeKitBehavior.toVolName;

public class GCYKMetaItem1 extends StandardMetaItem {

    private static int ID = 0;

    private static int ID() {
        return ++ID;
    }

    public void registerSubItems() {
        UPGRADE_KIT_ULV = addUpgradeKit(1);
        UPGRADE_KIT_LV = addUpgradeKit(2);
        UPGRADE_KIT_MV = addUpgradeKit(3);
        UPGRADE_KIT_HV = addUpgradeKit(4);
        UPGRADE_KIT_EV = addUpgradeKit(5);
        UPGRADE_KIT_IV = addUpgradeKit(6);
        UPGRADE_KIT_LuV = addUpgradeKit(7);
        UPGRADE_KIT_ZPM = addUpgradeKit(8);
        UPGRADE_KIT_UV = addUpgradeKit(9);
        UPGRADE_KIT_UHV = addUpgradeKit(10).setInvisibleIf(!GregTechAPI.isHighTier());
        UPGRADE_KIT_UEV = addUpgradeKit(11).setInvisibleIf(!GregTechAPI.isHighTier());
        UPGRADE_KIT_UIV = addUpgradeKit(12).setInvisibleIf(!GregTechAPI.isHighTier());
        UPGRADE_KIT_UXV = addUpgradeKit(13).setInvisibleIf(!GregTechAPI.isHighTier());

        GENERAL_MOLD = addItem(ID(), "mold.general");
    }

    private MetaItem<?>.MetaValueItem addUpgradeKit(int voltage) {
        return addItem(ID(), String.format("upgrade.kit.%s", toVolName(voltage)))
                .addComponents(new TooltipBehavior((list) -> list.add(I18n.format("gregicality_kids.tooltips.upgrade_kit"))))
                .addComponents(new UpgradeKitBehavior(voltage));
    }

}
