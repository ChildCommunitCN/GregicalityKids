package cn.childcommunity.gregicality_kids.mixin;

import cn.childcommunity.gregicality_kids.common.ConfigHolder;
import gregtech.api.unification.material.properties.WireProperties;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value = WireProperties.class, remap = false)
public abstract class MixinWireProperties {

    @Redirect(method = "<init>(IIIZI)V", at = @At(value = "FIELD", target = "Lgregtech/api/unification/material/properties/WireProperties;lossPerBlock:I", opcode = Opcodes.PUTFIELD))
    private void injected(WireProperties instance, int value) {
        if (ConfigHolder.child.enableWireChanges) {
            instance.setLossPerBlock(0);
        }
    }

    @Redirect(method = "<init>(IIIZI)V", at = @At(value = "FIELD", target = "Lgregtech/api/unification/material/properties/WireProperties;superconductorCriticalTemperature:I", opcode = Opcodes.PUTFIELD))
    private void injected_1(WireProperties instance, int value) {
        if (ConfigHolder.child.enableWireChanges) {
            if (value != 0) instance.setSuperconductorCriticalTemperature(value);
            if (value == 0) instance.setSuperconductorCriticalTemperature(1);
        }
    }

}
