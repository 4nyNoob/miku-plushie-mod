package com.any.miku_plushie.impl.common.registry;

import com.any.miku_plushie.Constants;
import com.any.miku_plushie.impl.common.commands.SpawnMikusCommand;
import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.commands.CommandBuildContext;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands.CommandSelection;

public class ModCommands {

  public static void register(CommandDispatcher<CommandSourceStack> commandDispatcher, CommandBuildContext commandBuildContext, CommandSelection commandSelection) {

    Constants.LOG.info("Registering " + Constants.MOD_ID + " Commands");

    SpawnMikusCommand.register(commandDispatcher);
  }
}
