package com.any.miku_plushie.impl.common.particle;

import com.any.miku_plushie.impl.common.registry.ModParticles;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.ParticleRenderType;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import org.jspecify.annotations.NonNull;

public class PlushSpawnParticle implements ParticleOptions {

  //TODO RE-DO PARTICLE EFFECT

//  private final SpriteSet spriteProvider;
//
//  protected PlushSpawnParticle(
//      ClientLevel world,
//      double x, double y, double z,
//      double velocityX, double velocityY, double velocityZ,
//      SpriteSet spriteProvider
//  ) {
//    super(world, x, y, z);
//
//    this.gravity = -0.1F;
//    this.friction = 0.9F;
//    this.spriteProvider = spriteProvider;
//
//    this.xd = velocityX + Math.random() * 0.2 - 0.1;
//    this.yd = velocityY + Math.random() * 0.3;
//    this.zd = velocityZ + Math.random() * 0.2 - 0.1;
//
//    this.quadSize = 0.1F * (this.random.nextFloat() * this.random.nextFloat() * 2.0F + 1.0F);
//    this.lifetime = (int) (16.0 / (this.random.nextFloat() * 0.8 + 0.2)) + 2;
//    this.setSpriteFromAge(spriteProvider);
//
//    this.setPos(
//        this.x + (Math.sin(this.lifetime) * 0.5),
//        this.y + ((this.lifetime) * 0.015 - 0.5),
//        this.z + (Math.cos(this.lifetime) * 0.5)
//    );
//  }
//
//  @Override
//  public ParticleRenderType getRenderType() {
//    return ParticleRenderType.PARTICLE_SHEET_TRANSLUCENT;
//  }
//
//  @OverrideTextureSheetParticle
//  public void tick() {
//    super.tick();
//    this.setSpriteFromAge(this.spriteProvider);
//  }
//
  @Override
  public @NonNull ParticleType<?> getType() {
    return ModParticles.MIKU_SPAWN;
  }
//
//
//  public static class Factory implements ParticleProvider<SimpleParticleType> {
//
//    private final SpriteSet spriteProvider;
//
//    public Factory(SpriteSet spriteProvider) {
//      this.spriteProvider = spriteProvider;
//    }
//
//    public Particle createParticle(
//        SimpleParticleType defaultParticleType,
//        ClientLevel clientWorld,
//        double x, double y, double z,
//        double velocityX, double velocityY, double velocityZ
//    ) {
//      return new PlushSpawnParticle(clientWorld, x, y, z, velocityX, velocityY, velocityZ, this.spriteProvider);
//    }
//  }
}
