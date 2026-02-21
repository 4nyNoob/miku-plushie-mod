package com.any.mikuplushie.registry;

import com.any.mikuplushie.MikuPlushie;
import com.any.mikuplushie.entity.KonohaEntity;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.EntityType;

public class ModSoundEvents {
	private ModSoundEvents() {
	}

	public static List<SoundEvent> MIKU_PLUSHIES_SOUND_EVENTS = new ArrayList<>();
	protected static List<String> SOUND_EVENT = List.of("oie", "dor", "bye", "equip");
	protected static List<String> MIKU_SOUND_EVENT = List.of("canudinho", "eat");

	private static SoundEvent registerSound(String id) {
		Identifier identifier = Identifier.fromNamespaceAndPath(MikuPlushie.MOD_ID, id);
		return Registry.register(BuiltInRegistries.SOUND_EVENT, identifier, SoundEvent.createVariableRangeEvent(identifier));
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
						SoundEvent soundEvent = registerSound(plush.toShortString().replace("_plush", "") + "_" + mikuSoundEvent);
						MIKU_PLUSHIES_SOUND_EVENTS.add(soundEvent);
					}
				}

				//ADD REGULAR SOUND EVENTS
				for (String event : SOUND_EVENT){
					SoundEvent soundEvent = registerSound(plush.toShortString().replace("_plush", "") + "_" + event);
					MIKU_PLUSHIES_SOUND_EVENTS.add(soundEvent);
				}
			}
		}
	}
}
