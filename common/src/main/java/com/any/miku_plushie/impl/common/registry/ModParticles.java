package com.any.miku_plushie.impl.common.registry;

import com.any.miku_plushie.Constants;
import com.any.miku_plushie.MikuPlushie;
import java.util.function.BiConsumer;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.resources.Identifier;

public class ModParticles {

  public static SimpleParticleType MIKU_SPAWN;

  public static void register(BiConsumer<ParticleType<?>, Identifier> consumer) {

    Constants.LOG.info("Registering " + Constants.MOD_ID + " Particles");
  // TODO REGISTER PARTICLES WHEN DONE

//    MIKU_SPAWN = new SimpleParticleType(false);
//    consumer.accept(MIKU_SPAWN, MikuPlushie.id("miku_spawn"));
  }
}
