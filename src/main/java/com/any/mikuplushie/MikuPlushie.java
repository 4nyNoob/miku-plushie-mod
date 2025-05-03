package com.any.mikuplushie;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Mod(MikuPlushie.MOD_ID)
public class MikuPlushie{
	public static final String MOD_ID = "miku_plushie";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.

	public MikuPlushie(IEventBus bus, ModContainer modContainer){
		ModBlocks.BLOCKS.register(bus);
		ModItems.ITEMS.register(bus);

		ModItems.CREATIVE_TABS.register(bus);

		ModSoundEvents.SOUND_EVENTS.register(bus);
	}
}
