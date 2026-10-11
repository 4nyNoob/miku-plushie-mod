package com.any.mikuplushie.particle;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.particle.*;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particle.SimpleParticleType;

public class PlushSpawnParticle extends BillboardParticle {
    private final SpriteProvider spriteProvider;

    protected PlushSpawnParticle(
        ClientWorld world,
        double x, double y, double z,
        double velocityX, double velocityY, double velocityZ,
        SpriteProvider spriteProvider
    ) {
        super(world, x, y, z, spriteProvider.getFirst());

        this.gravityStrength = -0.1F;
        this.velocityMultiplier = 0.9F;
        this.spriteProvider = spriteProvider;

        this.velocityX = velocityX + Math.random() * 0.2 - 0.1;
        this.velocityY = velocityY + Math.random() * 0.3;
        this.velocityZ = velocityZ + Math.random() * 0.2 - 0.1;

        this.scale = 0.1F * (this.random.nextFloat() * this.random.nextFloat() * 2.0F + 1.0F);
        this.maxAge = (int) (16.0 / (this.random.nextFloat() * 0.8 + 0.2)) + 2;
        this.updateSprite(spriteProvider);

        this.setPos(
            this.x + (Math.sin(this.maxAge) * 0.5),
            this.y + ((this.maxAge) * 0.015 - 0.5),
            this.z + (Math.cos(this.maxAge) * 0.5)
        );
    }

    @Override
    public BillboardParticle.RenderType getRenderType() {
        return BillboardParticle.RenderType.PARTICLE_ATLAS_TRANSLUCENT;
    }

    @Override
    public void tick() {
        super.tick();
        this.updateSprite(this.spriteProvider);
    }

    @Environment(EnvType.CLIENT)
    public static class Factory implements ParticleFactory<SimpleParticleType> {
        private final SpriteProvider spriteProvider;

        public Factory(SpriteProvider spriteProvider) {
            this.spriteProvider = spriteProvider;
        }

        public Particle createParticle(
            SimpleParticleType defaultParticleType,
            ClientWorld clientWorld,
            double x, double y, double z,
            double velocityX, double velocityY, double velocityZ, net.minecraft.util.math.random.Random random
        ) {
            return new PlushSpawnParticle(clientWorld, x, y, z, velocityX, velocityY, velocityZ, this.spriteProvider);
        }
    }
}
