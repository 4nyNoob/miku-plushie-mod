package com.any.mikuplushie.registry;

import com.any.mikuplushie.MikuPlushie;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.core.Registry;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;

public class ModParticles {

    public static final SimpleParticleType MIKU_SPAWN = FabricParticleTypes.simple();

    public static void initialize(){

        MikuPlushie.LOGGER.info("Registering " + MikuPlushie.MOD_ID + " Particles");

        Registry.register(BuiltInRegistries.PARTICLE_TYPE, ResourceLocation.fromNamespaceAndPath(MikuPlushie.MOD_ID, "miku_spawn"), MIKU_SPAWN);

    }
}
