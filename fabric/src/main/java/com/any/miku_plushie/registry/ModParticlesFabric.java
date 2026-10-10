package com.any.miku_plushie.registry;

import com.any.miku_plushie.Constants;
import com.any.miku_plushie.MikuPlushieFabric;
import com.any.miku_plushie.impl.common.registry.ModParticles;
import net.minecraft.core.Registry;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;

public class ModParticlesFabric {

  public static void initialize() {

    MikuPlushieFabric.LOGGER.info("Registering " + Constants.MOD_ID + " Particles");

    ModParticles.MIKU_SPAWN = new SimpleParticleType(false);

    Registry.register(BuiltInRegistries.PARTICLE_TYPE, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "miku_spawn"), ModParticles.MIKU_SPAWN);

  }
}
