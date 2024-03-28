package cn.childcommunity.gregicality_kids.common.metatileentities.multi;

import cn.childcommunity.gregicality_kids.api.metatileentity.multi.RainbowMultiMetaTileEntity;
import gregtech.api.GregTechAPI;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.material.Material;
import gregtech.api.unification.material.properties.PropertyKey;
import gregtech.api.unification.material.registry.MaterialRegistry;
import gregtech.api.unification.ore.OrePrefix;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import java.util.ArrayList;
import java.util.List;

public class MetaTileEntityRainbowMiner extends RainbowMultiMetaTileEntity {
    public MetaTileEntityRainbowMiner(ResourceLocation metaTileEntityId) {
        super(metaTileEntityId, true);

        List<ItemStack> stacks = new ArrayList<>();
        for (MaterialRegistry registry : GregTechAPI.materialManager.getRegistries()) {
            for (Material material : registry.getAllMaterials()) {
                if (material.hasProperty(PropertyKey.ORE)) {
                    stacks.add(OreDictUnifier.get(OrePrefix.ore, material));
                }
            }
        }
        setOutput(stacks, new ArrayList<>());
    }

    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity tileEntity) {
        return new MetaTileEntityRainbowMiner(this.metaTileEntityId);
    }


    protected void updateFormedValid() {
    }
}
