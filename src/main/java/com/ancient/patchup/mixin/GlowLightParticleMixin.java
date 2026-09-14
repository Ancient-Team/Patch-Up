package com.ancient.patchup.mixin;

import net.mehvahdjukaar.snowyspirit.client.GlowLightParticle;
import net.minecraft.client.particle.SpriteBillboardParticle;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.util.math.MathHelper;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(GlowLightParticle.class)
public abstract class GlowLightParticleMixin extends SpriteBillboardParticle {
    @Shadow @Final private float scale;
    @Shadow private float oldQuadSize;
    @Shadow @Final private float deltaRot;

    protected GlowLightParticleMixin(ClientWorld clientWorld, double d, double e, double f) {
        super(clientWorld, d, e, f);
    }

    /**
     * @author Antigravity
     * @reason Fix IllegalAccessError caused by Yarn remapping clash on final field GlowLightParticle.scale
     */
    @Overwrite
    public void tick() {
        super.tick();
        float f = MathHelper.sin((float) ((Math.PI * (double) this.age) / (double) this.maxAge));
        this.alpha = (float) Math.pow(f, 0.2);
        this.oldQuadSize = ((BillboardParticleAccessor) this).getScale();
        ((BillboardParticleAccessor) this).setScale((float) ((double) this.scale * Math.pow(f, 0.4)));
        this.prevAngle = this.angle;
        this.angle += this.deltaRot;
    }

    /**
     * @author Antigravity
     * @reason Correctly lerp using current billboard scale instead of constant scale
     */
    @Overwrite
    public float getSize(float tickDelta) {
        return MathHelper.lerp(tickDelta, this.oldQuadSize, ((BillboardParticleAccessor) this).getScale());
    }
}
