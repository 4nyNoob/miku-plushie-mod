package com.any.mikuplushie;

import com.any.mikuplushie.datagen.ModLootTableProvider;
import com.any.mikuplushie.datagen.ModModelProvider;
import com.any.mikuplushie.datagen.ModRecipeProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class MikuPlushieDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
		pack.addProvider(ModModelProvider ::new);
		pack.addProvider(ModLootTableProvider ::new);
		pack.addProvider(ModRecipeProvider ::new);
	}
}
