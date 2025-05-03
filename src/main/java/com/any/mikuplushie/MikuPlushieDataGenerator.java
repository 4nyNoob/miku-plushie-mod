package com.any.mikuplushie;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

import com.any.mikuplushie.datagen.ModItemModelProvider;
import com.any.mikuplushie.datagen.ModLootTableProvider;
import com.any.mikuplushie.datagen.ModModelProvider;
import com.any.mikuplushie.datagen.ModRecipeProvider;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

@EventBusSubscriber(modid = MikuPlushie.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class MikuPlushieDataGenerator {

	@SubscribeEvent
	public static void onInitializeDataGenerator(GatherDataEvent event) {
		DataGenerator generator=event.getGenerator();
		PackOutput packOutput=generator.getPackOutput();
		ExistingFileHelper existingFileHelper=event.getExistingFileHelper();
		CompletableFuture<HolderLookup.Provider> lookupProvider=event.getLookupProvider();

		generator.addProvider(event.includeClient(),new ModItemModelProvider(packOutput,existingFileHelper));
		generator.addProvider(event.includeClient(),new ModModelProvider(packOutput,existingFileHelper));

		generator.addProvider(event.includeServer(),new ModRecipeProvider(packOutput,lookupProvider));

		generator.addProvider(event.includeServer(),new LootTableProvider(packOutput, Collections.emptySet(), List.of(new LootTableProvider.SubProviderEntry(ModLootTableProvider::new, LootContextParamSets.BLOCK)),lookupProvider));
	}
}
