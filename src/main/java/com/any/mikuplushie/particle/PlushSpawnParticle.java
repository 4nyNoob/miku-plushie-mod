package com.any.mikuplushie.particle;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.util.RandomSource;
import org.jspecify.annotations.Nullable;

public class PlushSpawnParticle extends SingleQuadParticle {
    private final TextureAtlasSprite spriteProvider;

    protected PlushSpawnParticle(
        ClientLevel world,
        double x, double y, double z,
        double velocityX, double velocityY, double velocityZ,
        TextureAtlasSprite spriteProvider
    ) {
        super(world, x, y, z, spriteProvider);

        this.gravity = -0.1F;
        this.friction = 0.9F;
        this.spriteProvider = spriteProvider;

        this.xd = velocityX + Math.random() * 0.2 - 0.1;
        this.yd = velocityY + Math.random() * 0.3;
        this.zd = velocityZ + Math.random() * 0.2 - 0.1;

        this.quadSize = 0.1F * (this.random.nextFloat() * this.random.nextFloat() * 2.0F + 1.0F);
        this.lifetime = (int) (16.0 / (this.random.nextFloat() * 0.8 + 0.2)) + 2;
        this.setSpriteFromAge((SpriteSet) spriteProvider);

        this.setPos(
            this.x + (Math.sin(this.lifetime) * 0.5),
            this.y + ((this.lifetime) * 0.015 - 0.5),
            this.z + (Math.cos(this.lifetime) * 0.5)
        );
    }

//    @Override
//    public ParticleRenderType getRenderType() {
//        return ParticleRenderType.PARTICLE_SHEET_TRANSLUCENT;
//    }

    @Override
    public void tick() {
        super.tick();
        this.setSpriteFromAge((SpriteSet) this.spriteProvider);
    }

    @Override
    protected Layer getLayer() {
        return Layer.TRANSLUCENT;
    }

    @Environment(EnvType.CLIENT)
    public static class Factory implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet spriteProvider;

        public Factory(SpriteSet spriteProvider) {
            this.spriteProvider = spriteProvider;
        }

        public Particle createParticle(
            SimpleParticleType defaultParticleType,
            ClientLevel clientWorld,
            double x, double y, double z,
            double velocityX, double velocityY, double velocityZ, RandomSource randomSource
        ) {
            return new PlushSpawnParticle(clientWorld, x, y, z, velocityX, velocityY, velocityZ, (TextureAtlasSprite) this.spriteProvider);
        }
    }
}
