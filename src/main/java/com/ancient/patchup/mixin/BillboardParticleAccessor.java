package com.ancient.patchup.mixin;

import net.minecraft.client.particle.BillboardParticle;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(BillboardParticle.class)
public interface BillboardParticleAccessor {
    @Accessor("scale")
    void setScale(float scale);

    @Accessor("scale")
    float getScale();
}
