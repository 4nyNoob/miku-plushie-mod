package com.any.miku_plushie.registry;

import com.any.miku_plushie.Constants;
import com.any.miku_plushie.MikuPlushieFabric;
import com.any.miku_plushie.impl.common.registry.ModEntities;
import com.any.miku_plushie.impl.common.registry.ModSounds;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.EntityType;

public class ModSoundEventsFabric {

  private static SoundEvent registerSound(String id) {
    ResourceLocation identifier = ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, id);
    return Registry.register(BuiltInRegistries.SOUND_EVENT, identifier, SoundEvent.createVariableRangeEvent(identifier));
  }

  public static void initialize() {
    MikuPlushieFabric.LOGGER.info("Registering " + Constants.MOD_ID + " Sounds");

    //DYNAMICALLY REGISTER SOUND EVENTS
    for (EntityType<?> plush : ModEntities.PLUSH_ENTITIES) {

      //SKIP KONOHA PLUSH
      if (!plush.equals(ModEntities.KONOHA)) {

        //ADD MIKU SOUND EVENTS
        if (plush.equals(ModEntities.MIKU)) {
          for (String mikuSoundEvent : ModSounds.MIKU_SOUND_EVENT) {
            SoundEvent soundEvent = registerSound(plush.toShortString().replace("_plush", "") + "_" + mikuSoundEvent);
            ModSounds.MIKU_PLUSHIES_SOUND_EVENTS.add(soundEvent);
          }
        }

        //ADD REGULAR SOUND EVENTS
        for (String event : ModSounds.SOUND_EVENT) {
          SoundEvent soundEvent = registerSound(plush.toShortString().replace("_plush", "") + "_" + event);
          ModSounds.MIKU_PLUSHIES_SOUND_EVENTS.add(soundEvent);
        }
      }
    }
  }
}
