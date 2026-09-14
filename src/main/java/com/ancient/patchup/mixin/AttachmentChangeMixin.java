package com.ancient.patchup.mixin;

import net.fabricmc.fabric.api.attachment.v1.AttachmentTarget;
import net.fabricmc.fabric.impl.attachment.sync.AttachmentChange;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = AttachmentChange.class, remap = false)
public class AttachmentChangeMixin {

    @Inject(method = "tryApply", at = @At("HEAD"), cancellable = true)
    private void patchup$preventUnknownTargetDisconnect(World world, CallbackInfo ci) {
        AttachmentChange change = (AttachmentChange) (Object) this;
        AttachmentTarget target = change.targetInfo().getTarget(world);
        if (target == null) {
            ci.cancel();
        }
    }
}
