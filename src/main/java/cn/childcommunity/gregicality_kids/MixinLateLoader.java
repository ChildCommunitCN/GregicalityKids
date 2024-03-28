package cn.childcommunity.gregicality_kids;

import zone.rong.mixinbooter.ILateMixinLoader;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MixinLateLoader implements ILateMixinLoader {
    @Override
    public List<String> getMixinConfigs() {
        return Collections.singletonList("mixins.gregicality_kids.json");
    }
}
