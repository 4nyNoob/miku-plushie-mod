package com.any.mikuplushie;

import com.any.mikuplushie.entity.variant.PlushVariants;
import com.any.mikuplushie.registry.*;
import com.any.mikuplushie.worldgen.generators.ModWorldGeneration;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MikuPlushie implements ModInitializer {
	public static final String MOD_ID = "miku-plushie";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Miku is now Joining Fabric!!!");
		ModBlocks.initialize();
		ModItems.initialize();
		ModSoundEvents.initialize();
        ModCommands.initialize();
        ModEntities.initialize();
        ModResourcePacks.initialize();
		ModVillagerTrades.initialize();
		ModParticles.initialize();
		ModWorldGeneration.generateModWorldGeneration();
		PlushVariants.initialize();
        LOGGER.info("Miku: (^v^)/ Hi!!!");
	}
}
