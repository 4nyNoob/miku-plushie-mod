package com.any.mikuplushie.registry;

import com.any.mikuplushie.MikuPlushie;
import net.minecraft.entity.EntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.List;

public class ModSoundEvents {
	private ModSoundEvents() {
	}

	public static List<SoundEvent> MIKU_PLUSHIES_SOUND_EVENTS = new ArrayList<>();
	protected static List<String> SOUND_EVENT = List.of("oie", "dor", "bye", "equip");
	protected static List<String> MIKU_SOUND_EVENT = List.of("canudinho", "eat");

	private static SoundEvent registerSound(String id) {
		Identifier identifier = Identifier.of(MikuPlushie.MOD_ID, id);
		return Registry.register(Registries.SOUND_EVENT, identifier, SoundEvent.of(identifier));
	}

	public static void initialize() {
		MikuPlushie.LOGGER.info("Registering " + MikuPlushie.MOD_ID + " Sounds");

		//DYNAMICALLY REGISTER SOUND EVENTS
		for (EntityType<?> plush : ModEntities.PLUSH_ENTITIES){

			//SKIP KONOHA PLUSH
			if (!plush.equals(ModEntities.KONOHA)){

				//ADD MIKU SOUND EVENTS
				if (plush.equals(ModEntities.MIKU)){
					for (String mikuSoundEvent : MIKU_SOUND_EVENT){
						SoundEvent soundEvent = registerSound(plush.getUntranslatedName().replace("_plush", "") + "_" + mikuSoundEvent);
						MIKU_PLUSHIES_SOUND_EVENTS.add(soundEvent);
					}
				}

				//ADD REGULAR SOUND EVENTS
				for (String event : SOUND_EVENT){
					SoundEvent soundEvent = registerSound(plush.getUntranslatedName().replace("_plush", "") + "_" + event);
					MIKU_PLUSHIES_SOUND_EVENTS.add(soundEvent);
				}
			}
		}
//		//PRINT SOUND EVENTS
//		for (SoundEvent soundEvent : MIKU_PLUSHIES_SOUND_EVENTS){
//			System.out.println(soundEvent.getId());
//		}
	}
}
