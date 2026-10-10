package com.any.miku_plushie.registry;

import com.any.miku_plushie.MikuPlushieFabric;
import com.any.miku_plushie.commands.SpawnMikusCommand;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;

public class ModCommands {

  public static void initialize() {
    MikuPlushieFabric.LOGGER.info("Registering " + MikuPlushieFabric.MOD_ID + " Commands");
    CommandRegistrationCallback.EVENT.register(((
        commandDispatcher, commandRegistryAccess, registrationEnvironment) ->
        SpawnMikusCommand.register(commandDispatcher))
    );
  }
}
