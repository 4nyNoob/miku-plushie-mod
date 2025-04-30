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

	public static final Holder<SoundEvent> CANUDINHO = SOUND_EVENTS.register("canudinho", SoundEvent::createVariableRangeEvent);
	public static final Holder<SoundEvent> OIE = SOUND_EVENTS.register("oie", SoundEvent::createVariableRangeEvent);
	public static final Holder<SoundEvent> DOR = SOUND_EVENTS.register("dor", SoundEvent::createVariableRangeEvent);
	public static final Holder<SoundEvent> BYE = SOUND_EVENTS.register("bye", SoundEvent::createVariableRangeEvent);
	public static final Holder<SoundEvent> EQUIP = SOUND_EVENTS.register("equip", SoundEvent::createVariableRangeEvent);
}
