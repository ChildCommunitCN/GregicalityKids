package cn.childcommunity.gregicality_kids.common.items;

import cn.childcommunity.gregicality_kids.common.EventHandler;
import cn.childcommunity.gregicality_kids.common.items.behaviors.UpgradeKitBehavior;
import gregtech.api.GregTechAPI;
import gregtech.api.items.metaitem.MetaItem;
import gregtech.api.items.metaitem.StandardMetaItem;
import gregtech.common.items.behaviors.TooltipBehavior;
import net.minecraft.client.resources.I18n;

public class GCYKMetaItems {
    private static int ID = 0;

    private static StandardMetaItem META_ITEM_1;

    public static MetaItem<?>.MetaValueItem UPGRADE_KIT_ULV;
    public static MetaItem<?>.MetaValueItem UPGRADE_KIT_LV;
    public static MetaItem<?>.MetaValueItem UPGRADE_KIT_MV;
    public static MetaItem<?>.MetaValueItem UPGRADE_KIT_HV;
    public static MetaItem<?>.MetaValueItem UPGRADE_KIT_EV;
    public static MetaItem<?>.MetaValueItem UPGRADE_KIT_IV;
    public static MetaItem<?>.MetaValueItem UPGRADE_KIT_LuV;
    public static MetaItem<?>.MetaValueItem UPGRADE_KIT_ZPM;
    public static MetaItem<?>.MetaValueItem UPGRADE_KIT_UV;
    public static MetaItem<?>.MetaValueItem UPGRADE_KIT_UHV;
    public static MetaItem<?>.MetaValueItem UPGRADE_KIT_UEV;
    public static MetaItem<?>.MetaValueItem UPGRADE_KIT_UIV;
    public static MetaItem<?>.MetaValueItem UPGRADE_KIT_UXV;
    public static MetaItem<?>.MetaValueItem UPGRADE_KIT_OpV;

    public static void registerSubItems() {
        UPGRADE_KIT_ULV = addUpgradeKit("ulv");
        UPGRADE_KIT_LV = addUpgradeKit("lv");
        UPGRADE_KIT_MV = addUpgradeKit("mv");
        UPGRADE_KIT_HV = addUpgradeKit("hv");
        UPGRADE_KIT_EV = addUpgradeKit("ev");
        UPGRADE_KIT_IV = addUpgradeKit("iv");
        UPGRADE_KIT_LuV = addUpgradeKit("luv");
        UPGRADE_KIT_ZPM = addUpgradeKit("zpm");
        UPGRADE_KIT_UV = addUpgradeKit("uv");
        UPGRADE_KIT_UHV = addUpgradeKit("uhv").setInvisibleIf(!GregTechAPI.isHighTier());
        UPGRADE_KIT_UEV = addUpgradeKit("uev").setInvisibleIf(!GregTechAPI.isHighTier());
        UPGRADE_KIT_UIV = addUpgradeKit("uiv").setInvisibleIf(!GregTechAPI.isHighTier());
        UPGRADE_KIT_UXV = addUpgradeKit("uxv").setInvisibleIf(!GregTechAPI.isHighTier());
        UPGRADE_KIT_OpV = addUpgradeKit("opv").setInvisibleIf(!GregTechAPI.isHighTier());
    }

    private static int ID() {
        return ++ID;
    }

    private static MetaItem<?>.MetaValueItem addUpgradeKit(String voltage) {
        return META_ITEM_1.addItem(ID(), String.format("upgrade.kit.%s", voltage))
                .addComponents(new TooltipBehavior((list) -> {
                    list.add(I18n.format("gregicality_kids.tooltips.upgrade_kit"));
                }))
                .addComponents(new UpgradeKitBehavior(voltage));
    }

    public static void init() {
        META_ITEM_1 = new StandardMetaItem();
        META_ITEM_1.setRegistryName("meta_item_gcyk");
        META_ITEM_1.setCreativeTab(EventHandler.TAB);
    }

}
