package com.any.mikuplushie;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ModSoundEvents {
	private ModSoundEvents() {
	}

	public static final SoundEvent CANUDINHO = registerSound("canudinho");
	public static final SoundEvent OIE = registerSound("oie");
	public static final SoundEvent DOR = registerSound("dor");
	public static final SoundEvent BYE = registerSound("bye");
	public static final SoundEvent EQUIP = registerSound("equip");

	private static SoundEvent registerSound(String id) {
		Identifier identifier = Identifier.of(MikuPlushie.MOD_ID, id);
		return Registry.register(Registries.SOUND_EVENT, identifier, SoundEvent.of(identifier));
	}

	public static void initialize() {
		MikuPlushie.LOGGER.info("Registering " + MikuPlushie.MOD_ID + " Sounds");
	}
}
