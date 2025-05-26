package com.any.mikuplushie;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ModSoundEvents {
	private ModSoundEvents() {
	}

	//MIKU VOICE
	public static final SoundEvent MIKU_CANUDINHO = registerSound("canudinho");
	public static final SoundEvent MIKU_OIE = registerSound("oie");
	public static final SoundEvent MIKU_DOR = registerSound("dor");
	public static final SoundEvent MIKU_BYE = registerSound("bye");
	public static final SoundEvent MIKU_EQUIP = registerSound("equip");

	//AIKO VOICE
	public static final SoundEvent AIKO_OIE = registerSound("aiko_oie");
	public static final SoundEvent AIKO_DOR = registerSound("aiko_dor");
	public static final SoundEvent AIKO_BYE = registerSound("aiko_bye");
	public static final SoundEvent AIKO_EQUIP = registerSound("aiko_equip");

	private static SoundEvent registerSound(String id) {
		Identifier identifier = Identifier.of(MikuPlushie.MOD_ID, id);
		return Registry.register(Registries.SOUND_EVENT, identifier, SoundEvent.of(identifier));
	}

	public static void initialize() {
		MikuPlushie.LOGGER.info("Registering " + MikuPlushie.MOD_ID + " Sounds");
	}
}
