package com.any.miku_plushie.impl.common.util;

import com.any.miku_plushie.Constants;
import com.any.miku_plushie.impl.common.entity.AbstractPlushEntity;
import com.any.miku_plushie.impl.common.registry.ModBlocks;
import com.any.miku_plushie.impl.common.registry.ModSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

import java.util.Objects;

public class ModUtil {

  public static String getBlockIdFromBlockPos(Level world, BlockPos pos) {
    return world.getBlockState(pos).getBlock().getDescriptionId().split("[.]")[2];
  }

  public static String getBlockIdFromBlockState(BlockState state) {
    return state.getBlock().getDescriptionId().split("[.]")[2];
  }

  public static String getBlockIdFromItem(Item itemConvertible) {
    return itemConvertible.getDescriptionId().split("[.]")[2];
  }

  public static String getBlockIdFromBlock(Block block) {
    return block.getDescriptionId().split("[.]")[2];
  }

  public static String getEntityNameFromBlockId(String blockId) {
    String[] blockIdWords = blockId.split("_");
    return blockIdWords[0] + "_" + blockIdWords[1];
  }

  public static String getFirstNameFromBlockId(String blockId) {
    String[] blockIdWords = blockId.split("_");
    return blockIdWords[0];
  }

  public static SoundEvent getPlushSoundEvent(String plushName, String action) {
    String firstName = getFirstNameFromBlockId(plushName);

    for (SoundEvent soundEvent : ModSounds.MIKU_PLUSHIES_SOUND_EVENTS) {
      //GET SOUND EVENT
      String soundEventId = soundEvent.getLocation().toString().split(":")[1];
      if (soundEventId.contains(firstName) && soundEventId.contains("_" + action)) {
        return soundEvent;
      }
    }

    return ModSounds.MIKU_PLUSHIES_SOUND_EVENTS.getFirst();
  }

  public static void playPlushSound(Level world, BlockPos position, String plushName, String action) {
    if (!plushName.equals(ModUtil.getBlockIdFromBlock(ModBlocks.KONOHA_PLUSH))) {
      SoundEvent soundEvent = getPlushSoundEvent(plushName, action);
      world.playLocalSound(position.getX(), position.getY(), position.getZ(),
          soundEvent, SoundSource.BLOCKS, 0.5F, 1, true);
    }
  }

  public static AbstractPlushEntity createPlushFromBlock(String blockName, Level world, Vec3 pos) {

    Registry<EntityType<?>> entityTypeRegistry = world.registryAccess().registryOrThrow(Registries.ENTITY_TYPE);
    AbstractPlushEntity spawnedEntity = null;

    for (String entity : Constants.PLUSH_NAMES){
      // IF SELECTED BLOCK CONTAINS ENTITY NAME
      if (blockName.contains(entity)){
        // CALCULATE ENTITY RESOURCE LOCATION
        ResourceLocation entityResourceLocation = ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, entity + "_plush");
        // GET ENTITY TYPE
        EntityType<?> entityType = entityTypeRegistry.get(entityResourceLocation);

        // CREATE ENTITY
        AbstractPlushEntity spawned = (AbstractPlushEntity) Objects.requireNonNull(entityType).create(world);
        Objects.requireNonNull(spawned).setPos(pos);
        spawned.setVariantByBlock(blockName);

        // RETURN ENTITY
        spawnedEntity = spawned;
      }
    }
    return spawnedEntity;
  }
}
