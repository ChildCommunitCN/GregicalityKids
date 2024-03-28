package cn.childcommunity.gregicality_kids.mixin;

import cn.childcommunity.gregicality_kids.common.ConfigHolder;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.pipenet.tile.TileEntityPipeBase;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = {MetaTileEntity.class, TileEntityPipeBase.class}, remap = false)
public abstract class MixinTileEntityExplosion {

    @Inject(method = "doExplosion", at = @At("HEAD"), cancellable = true)
    private void injected(float explosionPower, CallbackInfo ci) {
        if (ConfigHolder.explosion.enableExplosionChange) {
            ci.cancel();
        }
    }

}
