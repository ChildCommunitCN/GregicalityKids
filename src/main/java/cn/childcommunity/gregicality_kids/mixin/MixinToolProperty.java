package cn.childcommunity.gregicality_kids.mixin;

import cn.childcommunity.gregicality_kids.common.ConfigHolder;
import gregtech.api.unification.material.properties.ToolProperty;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArgs;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.invoke.arg.Args;

@Mixin(value = ToolProperty.Builder.class, remap = false)
public abstract class MixinToolProperty {

    @Shadow public abstract ToolProperty.Builder attackSpeed(float attackSpeed);

    @ModifyArgs(method = "of", at = @At(value = "INVOKE", target = "Lgregtech/api/unification/material/properties/ToolProperty$Builder;<init>(FFII)V"))
    private static void injected(Args args) {
        if (ConfigHolder.child.enableToolChanges) {
            float harvestSpeed = args.get(0);
            float attackDamage = args.get(1);
            int durability = args.get(2);
            args.set(0, harvestSpeed * 3);
            args.set(1, attackDamage + 5.5f);
            args.set(2, durability * 10);
        }
    }

    @Redirect(method = "enchantability", at = @At(value = "INVOKE", target = "Lgregtech/api/unification/material/properties/ToolProperty;setToolEnchantability(I)V"))
    private void injected(ToolProperty instance, int toolEnchantability) {
        if (ConfigHolder.child.enableToolChanges) {
            instance.setToolEnchantability(toolEnchantability + 2);
        }
    }

    @Redirect(method = "attackSpeed", at = @At(value = "INVOKE", target = "Lgregtech/api/unification/material/properties/ToolProperty;setToolAttackSpeed(F)V"))
    private void injected(ToolProperty instance, float toolAttackSpeed) {
        if (ConfigHolder.child.enableToolChanges) {
            instance.setToolAttackSpeed(toolAttackSpeed + 2);
        }
    }
}
