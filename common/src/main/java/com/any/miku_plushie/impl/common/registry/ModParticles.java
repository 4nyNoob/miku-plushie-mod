package com.any.miku_plushie.impl.common.registry;

import java.util.function.BiConsumer;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.resources.ResourceLocation;

public class ModParticles {

  public static SimpleParticleType MIKU_SPAWN;

  public static void register(BiConsumer<ParticleType<?>, ResourceLocation> consumer) {}
}
