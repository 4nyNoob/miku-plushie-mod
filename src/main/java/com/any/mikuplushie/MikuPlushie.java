package com.any.mikuplushie;

import com.any.mikuplushie.commands.SpawnMikusCommand;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MikuPlushie implements ModInitializer {
	public static final String MOD_ID = "miku-plushie";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

//    private final CommandDispatcher<ServerCommandSource> dispatcher = new CommandDispatcher<>();

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.

	@Override
	public void onInitialize() {
		LOGGER.info("Miku is now joining Fabric!!!");
		ModItems.initialize();
		ModBlocks.initialize();
		ModSoundEvents.initialize();

        CommandRegistrationCallback.EVENT.register(((
            commandDispatcher, commandRegistryAccess, registrationEnvironment) ->
            SpawnMikusCommand.register(commandDispatcher))
        );
	}
}
