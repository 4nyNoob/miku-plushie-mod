package com.any.mikuplushie;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModSoundEvents {
	private ModSoundEvents() {
	}

	public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
			DeferredRegister.create(BuiltInRegistries.SOUND_EVENT, MikuPlushie.MOD_ID);

	public static final Holder<SoundEvent> MIKU_CANUDINHO = SOUND_EVENTS.register("canudinho", SoundEvent::createVariableRangeEvent);
	public static final Holder<SoundEvent> MIKU_OIE = SOUND_EVENTS.register("oie", SoundEvent::createVariableRangeEvent);
	public static final Holder<SoundEvent> MIKU_DOR = SOUND_EVENTS.register("dor", SoundEvent::createVariableRangeEvent);
	public static final Holder<SoundEvent> MIKU_BYE = SOUND_EVENTS.register("bye", SoundEvent::createVariableRangeEvent);
	public static final Holder<SoundEvent> MIKU_EQUIP = SOUND_EVENTS.register("equip", SoundEvent::createVariableRangeEvent);

	public static final Holder<SoundEvent> AIKO_OIE = SOUND_EVENTS.register("aiko_oie", SoundEvent::createVariableRangeEvent);
	public static final Holder<SoundEvent> AIKO_DOR = SOUND_EVENTS.register("aiko_dor", SoundEvent::createVariableRangeEvent);
	public static final Holder<SoundEvent> AIKO_BYE = SOUND_EVENTS.register("aiko_bye", SoundEvent::createVariableRangeEvent);
	public static final Holder<SoundEvent> AIKO_EQUIP = SOUND_EVENTS.register("aiko_equip", SoundEvent::createVariableRangeEvent);

	public static final Holder<SoundEvent> TETO_OIE = SOUND_EVENTS.register("teto_oie", SoundEvent::createVariableRangeEvent);
	public static final Holder<SoundEvent> TETO_DOR = SOUND_EVENTS.register("teto_dor", SoundEvent::createVariableRangeEvent);
	public static final Holder<SoundEvent> TETO_BYE = SOUND_EVENTS.register("teto_bye", SoundEvent::createVariableRangeEvent);
	public static final Holder<SoundEvent> TETO_EQUIP = SOUND_EVENTS.register("teto_equip", SoundEvent::createVariableRangeEvent);

	public static final Holder<SoundEvent> NERU_OIE = SOUND_EVENTS.register("neru_oie", SoundEvent::createVariableRangeEvent);
	public static final Holder<SoundEvent> NERU_DOR = SOUND_EVENTS.register("neru_dor", SoundEvent::createVariableRangeEvent);
	public static final Holder<SoundEvent> NERU_BYE = SOUND_EVENTS.register("neru_bye", SoundEvent::createVariableRangeEvent);
	public static final Holder<SoundEvent> NERU_EQUIP = SOUND_EVENTS.register("neru_equip", SoundEvent::createVariableRangeEvent);

	public static final Holder<SoundEvent> RIN_OIE = SOUND_EVENTS.register("rin_oie", SoundEvent::createVariableRangeEvent);
	public static final Holder<SoundEvent> RIN_DOR = SOUND_EVENTS.register("rin_dor", SoundEvent::createVariableRangeEvent);
	public static final Holder<SoundEvent> RIN_BYE = SOUND_EVENTS.register("rin_bye", SoundEvent::createVariableRangeEvent);
	public static final Holder<SoundEvent> RIN_EQUIP = SOUND_EVENTS.register("rin_equip", SoundEvent::createVariableRangeEvent);

	public static final Holder<SoundEvent> LEN_OIE = SOUND_EVENTS.register("len_oie", SoundEvent::createVariableRangeEvent);
	public static final Holder<SoundEvent> LEN_DOR = SOUND_EVENTS.register("len_dor", SoundEvent::createVariableRangeEvent);
	public static final Holder<SoundEvent> LEN_BYE = SOUND_EVENTS.register("len_bye", SoundEvent::createVariableRangeEvent);
	public static final Holder<SoundEvent> LEN_EQUIP = SOUND_EVENTS.register("len_equip", SoundEvent::createVariableRangeEvent);
}
