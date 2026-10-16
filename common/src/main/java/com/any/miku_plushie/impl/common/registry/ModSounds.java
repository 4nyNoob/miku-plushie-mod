package com.any.miku_plushie.impl.common.registry;

import com.any.miku_plushie.Constants;
import com.any.miku_plushie.MikuPlushie;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.EntityType;

public class ModSounds {

  public static final List<String> SOUND_EVENT = List.of("oie", "dor", "bye", "equip");
  public static final List<String> MIKU_SOUND_EVENT = List.of("canudinho", "eat");

  public static final List<SoundEvent> MIKU_PLUSHIES_SOUND_EVENTS = new ArrayList<>();

  public static void register(BiConsumer<SoundEvent, ResourceLocation> consumer) {

    Constants.LOG.info("Registering " + Constants.MOD_ID + " Sounds");

    //DYNAMICALLY REGISTER SOUND EVENTS
    for (String plush : Constants.CHARACTER_NAMES) {

      //SKIP KONOHA PLUSH
      if (plush.equals("konoha")) {
        continue; // move on to the next plushie, skipping the following logic for KONOHA only
      }

      //ADD MIKU SOUND EVENTS
      if (plush.equals("miku")) {
        for (String mikuSoundEvent : ModSounds.MIKU_SOUND_EVENT) {
          SoundEvent soundEvent = registerSound(plush + "_" + mikuSoundEvent, consumer);
          ModSounds.MIKU_PLUSHIES_SOUND_EVENTS.add(soundEvent);
        }
      }

      //ADD REGULAR SOUND EVENTS
      for (String event : ModSounds.SOUND_EVENT) {
        SoundEvent soundEvent = registerSound(plush + "_" + event, consumer);
        ModSounds.MIKU_PLUSHIES_SOUND_EVENTS.add(soundEvent);
      }
    }
  }

  private static SoundEvent registerSound(String id, BiConsumer<SoundEvent, ResourceLocation> consumer) {
    ResourceLocation identifier = MikuPlushie.id(id);

    SoundEvent sound = SoundEvent.createVariableRangeEvent(identifier);
    consumer.accept(sound, identifier);

    return sound;
  }
}
