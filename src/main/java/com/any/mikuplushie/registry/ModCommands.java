package com.any.mikuplushie.registry;

import com.any.mikuplushie.MikuPlushie;
import com.any.mikuplushie.commands.SpawnMikusCommand;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;

public class ModCommands {
    public static void initialize(){
        MikuPlushie.LOGGER.info("Registering " + MikuPlushie.MOD_ID + " Commands");
        CommandRegistrationCallback.EVENT.register(((
            commandDispatcher, commandRegistryAccess, registrationEnvironment) ->
            SpawnMikusCommand.register(commandDispatcher))
        );
    }
}
