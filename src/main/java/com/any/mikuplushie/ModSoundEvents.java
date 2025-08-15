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

	//TETO VOICE
	public static final SoundEvent TETO_OIE = registerSound("teto_oie");
	public static final SoundEvent TETO_DOR = registerSound("teto_dor");
	public static final SoundEvent TETO_BYE = registerSound("teto_bye");
	public static final SoundEvent TETO_EQUIP = registerSound("teto_equip");

	//AKITA NERU VOICE
	public static final SoundEvent AKITA_NERU_OIE = registerSound("neru_oie");
	public static final SoundEvent AKITA_NERU_DOR = registerSound("neru_dor");
	public static final SoundEvent AKITA_NERU_BYE = registerSound("neru_bye");
	public static final SoundEvent AKITA_NERU_EQUIP = registerSound("neru_equip");

	//RIN VOICE
	public static final SoundEvent RIN_OIE = registerSound("rin_oie");
	public static final SoundEvent RIN_DOR = registerSound("rin_dor");
	public static final SoundEvent RIN_BYE = registerSound("rin_bye");
	public static final SoundEvent RIN_EQUIP = registerSound("rin_equip");

	//LEN VOICE
	public static final SoundEvent LEN_OIE = registerSound("len_oie");
	public static final SoundEvent LEN_DOR = registerSound("len_dor");
	public static final SoundEvent LEN_BYE = registerSound("len_bye");
	public static final SoundEvent LEN_EQUIP = registerSound("len_equip");

	//LUKA VOICE
	public static final SoundEvent LUKA_OIE = registerSound("luka_oie");
	public static final SoundEvent LUKA_DOR = registerSound("luka_dor");
	public static final SoundEvent LUKA_BYE = registerSound("luka_bye");
	public static final SoundEvent LUKA_EQUIP = registerSound("luka_equip");

	private static SoundEvent registerSound(String id) {
		Identifier identifier = Identifier.of(MikuPlushie.MOD_ID, id);
		return Registry.register(Registries.SOUND_EVENT, identifier, SoundEvent.of(identifier));
	}

	public static void initialize() {
		MikuPlushie.LOGGER.info("Registering " + MikuPlushie.MOD_ID + " Sounds");
	}
}
