package com.any.mikuplushie.registry;

import com.any.mikuplushie.MikuPlushie;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

import java.util.List;

public class ModSoundEvents {
	private ModSoundEvents() {
	}


	public static List<SoundEvent> MIKU_PLUSHIES_SOUND_EVENTS = List.of(
		//MIKU
		registerSound("miku_canudinho"),
		registerSound("miku_oie"),
		registerSound("miku_dor"),
		registerSound("miku_bye"),
		registerSound("miku_equip"),
		registerSound("miku_eat"),

		//AIKO
		registerSound("aiko_oie"),
		registerSound("aiko_dor"),
		registerSound("aiko_bye"),
		registerSound("aiko_equip"),

		//TETO
		registerSound("teto_oie"),
		registerSound("teto_dor"),
		registerSound("teto_bye"),
		registerSound("teto_equip"),

		//AKITA NERU
		registerSound("akita_oie"),
		registerSound("akita_dor"),
		registerSound("akita_bye"),
		registerSound("akita_equip"),

		//RIN
		registerSound("rin_oie"),
		registerSound("rin_dor"),
		registerSound("rin_bye"),
		registerSound("rin_equip"),

		//LEN
		registerSound("len_oie"),
		registerSound("len_dor"),
		registerSound("len_bye"),
		registerSound("len_equip"),

		//LUKA
		registerSound("luka_oie"),
		registerSound("luka_dor"),
		registerSound("luka_bye"),
		registerSound("luka_equip"),

		//MEIKO
		registerSound("meiko_oie"),
		registerSound("meiko_dor"),
		registerSound("meiko_bye"),
		registerSound("meiko_equip"),

		//GUMI
		registerSound("gumi_oie"),
		registerSound("gumi_dor"),
		registerSound("gumi_bye"),
		registerSound("gumi_equip"),

		//KAITO
		registerSound("kaito_oie"),
		registerSound("kaito_dor"),
		registerSound("kaito_bye"),
		registerSound("kaito_equip")
	);

	private static SoundEvent registerSound(String id) {
		Identifier identifier = Identifier.of(MikuPlushie.MOD_ID, id);
		return Registry.register(Registries.SOUND_EVENT, identifier, SoundEvent.of(identifier));
	}

	public static void initialize() {
		MikuPlushie.LOGGER.info("Registering " + MikuPlushie.MOD_ID + " Sounds");
	}
}
