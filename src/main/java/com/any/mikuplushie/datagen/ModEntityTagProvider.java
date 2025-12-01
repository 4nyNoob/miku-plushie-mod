package com.any.mikuplushie.datagen;

import com.any.mikuplushie.MikuPlushie;
import com.any.mikuplushie.ModEntities;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.entity.EntityType;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

public class ModEntityTagProvider extends FabricTagProvider.EntityTypeTagProvider {

    public ModEntityTagProvider(FabricDataOutput output,
                                CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    public static final TagKey<EntityType<?>> PLUSH_ENTITY = TagKey.of(RegistryKeys.ENTITY_TYPE, Identifier.of(MikuPlushie.MOD_ID, "plush_entity"));

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(PLUSH_ENTITY)
            .add(ModEntities.MIKU)
            .add(ModEntities.TETO)
            .add(ModEntities.AIKO)
            .add(ModEntities.NERU)
            .add(ModEntities.RIN)
            .add(ModEntities.LEN)
            .add(ModEntities.KONOHA)
            .add(ModEntities.LUKA)
            .add(ModEntities.MEIKO)
        ;
    }
}
