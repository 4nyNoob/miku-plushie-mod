package com.any.mikuplushie;

import com.any.mikuplushie.datagen.ModTagProvider;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.command.argument.Vec3ArgumentType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.decoration.ArmorStandEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> {
            dispatcher
                .register(CommandManager.literal("spawn_mikus")
                .then(CommandManager.argument("pos", Vec3ArgumentType.vec3())
                    .executes(context -> {

                        //GLOBAL VARIABLES
                        ServerWorld world = context.getSource().getWorld();
                        Vec3d sourcePos = Vec3ArgumentType.getVec3(context, "pos");
                        int spacing = 3;

                        //GET PLUSHIES FROM ITEM TAG
                        Registry<Item> registry = world.getRegistryManager().get(RegistryKeys.ITEM);
                        List<ItemStack> PLUSHIES = new ArrayList<>();

                        for (int item = 0; item < registry.size(); item++) {
                            if (Objects.requireNonNull(registry.get(item)).getDefaultStack().isIn(ModTagProvider.PLUSHIES)){
                                PLUSHIES.add(Objects.requireNonNull(registry.get(item)).getDefaultStack());
                            }
                        }

                        //INITIAL ARMOR STAND POS
                        BlockPos plushiesSpawnPos =
                            BlockPos.ofFloored(
                                sourcePos.x,
                                sourcePos.y,
                                sourcePos.z
                            );

                        //HANDLE PLUSHIES SPAWNING
                        int plushies_rows = (int) Math.ceil(Math.sqrt(PLUSHIES.size()));
                        int plushies_columns = 9;
                        int plushies = 0;

                        //ROWS SPAWN
                        for (int r = 0; r < plushies_rows; r++) {
                            //COLUMNS SPAWN
                            for (int c = 0; c < plushies_columns; c++) {
                                //AVOID SPAWNING MORE ARMOR STANDS THAN NECESSARY
                                if (plushies < PLUSHIES.size()) {

                                    ItemStack itemStack = PLUSHIES.get(plushies);

                                    ArmorStandEntity armorStandEntity = new ArmorStandEntity(world,
                                        plushiesSpawnPos.getX() + c * spacing + 0.5,
                                        plushiesSpawnPos.getY(),
                                        plushiesSpawnPos.getZ() + r * spacing + 0.5
                                    );

                                    armorStandEntity.equipStack(EquipmentSlot.HEAD, itemStack);
                                    armorStandEntity.equipStack(EquipmentSlot.MAINHAND, itemStack);
                                    armorStandEntity.equipStack(EquipmentSlot.OFFHAND, itemStack);

                                    armorStandEntity.setShowArms(true);
                                    armorStandEntity.setYaw(180F);
                                    armorStandEntity.setNoGravity(true);
                                    armorStandEntity.setCustomName(Text.of("Plush"));
                                    world.spawnEntity(armorStandEntity);
                                }
                                plushies ++;
                            }
                        }

                        List<ItemStack> PICKAXES = new ArrayList<>();

                        for (int item = 0; item < registry.size(); item++) {
                            if (Objects.requireNonNull(registry.get(item)).getDefaultStack().isIn(ModTagProvider.TETO_PICKAXE)){
                                PICKAXES.add(Objects.requireNonNull(registry.get(item)).getDefaultStack());
                            }
                        }

                        BlockPos pickaxeSpawnPos = plushiesSpawnPos.offset(Direction.UP, 5);

                        //HANDLE PLUSHIES SPAWNING
                        int pickaxesRows = (int) Math.ceil(Math.sqrt(PICKAXES.size()));
                        int pickaxesColumns = 9;
                        int pickaxe = 0;

                        //ROWS SPAWN
                        for (int r = 0; r < pickaxesRows; r++) {
                            //COLUMNS SPAWN
                            for (int c = 0; c < pickaxesColumns; c++) {
                                //AVOID SPAWNING MORE ARMOR STANDS THAN NECESSARY
                                if (pickaxe < PICKAXES.size()) {
                                    ArmorStandEntity armorStandEntity = new ArmorStandEntity(world,
                                        pickaxeSpawnPos.getX() + c * spacing + 0.5,
                                        pickaxeSpawnPos.getY(),
                                        pickaxeSpawnPos.getZ() + r * spacing + 0.5
                                    );

                                    armorStandEntity.equipStack(EquipmentSlot.HEAD, PICKAXES.get(pickaxe));
                                    armorStandEntity.equipStack(EquipmentSlot.MAINHAND, PICKAXES.get(pickaxe));
                                    armorStandEntity.equipStack(EquipmentSlot.OFFHAND, PICKAXES.get(pickaxe));

                                    armorStandEntity.setShowArms(true);
                                    armorStandEntity.setYaw(180F);
                                    armorStandEntity.setNoGravity(true);
                                    armorStandEntity.setCustomName(Text.of("Plush"));
                                    world.spawnEntity(armorStandEntity);
                                }
                                pickaxe ++;
                            }
                        }

                        return 1;
                    }
                )
            ));
        });

	}
}
