package cn.childcommunity.gregicality_kids.common.items;

import cn.childcommunity.gregicality_kids.common.EventHandler;
import gregtech.api.items.metaitem.MetaItem;

public class GCYKMetaItems {

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

    public static MetaItem<?>.MetaValueItem GENERAL_MOLD;

    public static void init() {
        GCYKMetaItem1 item1 = new GCYKMetaItem1();
        item1.setRegistryName("meta_item_gcyk");
        item1.setCreativeTab(EventHandler.TAB);
    }

}
