package cn.childcommunity.gregicality_kids.mixin.accessor;

import gregtech.api.capability.impl.miner.MultiblockMinerLogic;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value = MultiblockMinerLogic.class, remap = false)
public interface AccessorMultiblockMinerLogic {

    @Accessor("CHUNK_LENGTH")
    public static void setChunkLength(int arg) {
        throw new AssertionError();
    }

}
