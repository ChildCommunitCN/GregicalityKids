package cn.childcommunity.gregicality_kids.api.metatileentity.multi;

import gregtech.api.metatileentity.multiblock.IMultiblockPart;
import gregtech.api.metatileentity.multiblock.MultiblockAbility;
import gregtech.api.metatileentity.multiblock.MultiblockWithDisplayBase;
import gregtech.api.pattern.BlockPattern;
import gregtech.api.pattern.FactoryBlockPattern;
import gregtech.api.util.GTTransferUtils;
import gregtech.client.renderer.ICubeRenderer;
import gregtech.client.renderer.texture.Textures;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.IFluidTank;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.items.IItemHandlerModifiable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public abstract class RainbowMultiMetaTileEntity extends MultiblockWithDisplayBase {
    private List<ItemStack> outputItems = new ArrayList<>();
    private List<FluidStack> outputFluids = new ArrayList<>();
    private final boolean isItem;

    static ThreadLocalRandom random = ThreadLocalRandom.current();

    public RainbowMultiMetaTileEntity(ResourceLocation metaTileEntityId, boolean isItem) {
        super(metaTileEntityId);
        this.isItem = isItem;
    }

    public void setOutput(List<ItemStack> items, List<FluidStack> fluids) {
        this.outputItems = items;
        this.outputFluids = fluids;
    }

    public Iterable<ItemStack> getOutputItems() {
        return outputItems;
    }

    public Iterable<FluidStack> getOutputFluids() {
        return outputFluids;
    }

    @Override
    public boolean hasMaintenanceMechanics() {
        return false;
    }

    @SideOnly(Side.CLIENT)
    public ICubeRenderer getBaseTexture(IMultiblockPart sourcePart) {
        return Textures.SOLID_STEEL_CASING;
    }

    @SideOnly(Side.CLIENT)
    protected @NotNull ICubeRenderer getFrontOverlay() {
        return Textures.ASSEMBLER_OVERLAY;
    }

    public @NotNull BlockPattern createStructurePattern() {
        return FactoryBlockPattern.start()
                .aisle("AB")
                .where('A', this.selfPredicate())
                .where('B', abilities(isItem ? MultiblockAbility.EXPORT_ITEMS : MultiblockAbility.EXPORT_FLUIDS))
                .build();
    }

    public void update() {
        super.update();

        if (isItem) {
            for (IItemHandlerModifiable export : this.getAbilities(MultiblockAbility.EXPORT_ITEMS)) {
                GTTransferUtils.addItemsToItemHandler(export, false, Collections.singletonList(outputItems.get(random.nextInt(0, outputItems.size()))));
            }
        } else {
            for (IFluidTank export : this.getAbilities(MultiblockAbility.EXPORT_FLUIDS)) {
                export.fill(outputFluids.get(random.nextInt(0, outputFluids.size())), true);
            }
        }
    }
}
