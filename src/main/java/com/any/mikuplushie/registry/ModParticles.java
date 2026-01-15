package com.any.mikuplushie.registry;

import com.any.mikuplushie.MikuPlushie;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.particle.SimpleParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModParticles {

    public static final SimpleParticleType MIKU_SPAWN = FabricParticleTypes.simple();

    public static void initialize(){

        MikuPlushie.LOGGER.info("Registering " + MikuPlushie.MOD_ID + " Particles");

        Registry.register(Registries.PARTICLE_TYPE, Identifier.of(MikuPlushie.MOD_ID, "miku_spawn"), MIKU_SPAWN);

    }
}
