package com.any.miku_plushie;

import com.any.miku_plushie.entity.variant.PlushVariants;
import com.any.miku_plushie.registry.ModBlocks;
import com.any.miku_plushie.registry.ModCommands;
import com.any.miku_plushie.registry.ModEntities;
import com.any.miku_plushie.registry.ModItems;
import com.any.miku_plushie.registry.ModParticles;
import com.any.miku_plushie.registry.ModResourcePacks;
import com.any.miku_plushie.registry.ModSoundEvents;
import com.any.miku_plushie.registry.ModVillagerTrades;
import com.any.miku_plushie.worldgen.generators.ModWorldGeneration;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MikuPlushieFabric implements ModInitializer {

  public static final String MOD_ID = "miku-plushie";
  public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

  @Override
  public void onInitialize() {

    MikuPlushie.init();

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
