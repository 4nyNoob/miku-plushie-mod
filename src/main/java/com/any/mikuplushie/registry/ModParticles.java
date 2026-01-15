package com.any.mikuplushie.registry;

import com.any.mikuplushie.MikuPlushie;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.VillagerProfession;

public class ModParticles {

    public static final DefaultParticleType MIKU_SPAWN = FabricParticleTypes.simple();

    public static void initialize(){

        MikuPlushie.LOGGER.info("Registering " + MikuPlushie.MOD_ID + " Particles");

        Registry.register(Registries.PARTICLE_TYPE, new Identifier(MikuPlushie.MOD_ID, "miku_spawn"), MIKU_SPAWN);

    }
}
