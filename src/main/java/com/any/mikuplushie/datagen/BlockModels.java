package com.any.mikuplushie.datagen;

import com.any.mikuplushie.MikuPlushie;
import com.google.gson.JsonElement;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import net.minecraft.block.Block;
import net.minecraft.data.client.*;
import net.minecraft.item.Item;
import net.minecraft.state.property.Property;
import net.minecraft.util.Identifier;

import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class BlockModels {
    public final Consumer<BlockStateSupplier> blockStateCollector;
    public final BiConsumer<Identifier, Supplier<JsonElement>> modelCollector;

    public BlockModels(Consumer<BlockStateSupplier> blockStateCollector, BiConsumer<Identifier, Supplier<JsonElement>> modelCollector) {
        this.blockStateCollector = blockStateCollector;
        this.modelCollector = modelCollector;
    }

    private static Model block(String parent, TextureKey... requiredTextureKeys) {
        return new Model(Optional.of(new Identifier(MikuPlushie.MOD_ID, "block/" + parent)), Optional.empty(), requiredTextureKeys);
    }

    //PARENT MODELS
    public static final Model LEEK = block("leek", TextureKey.CROSS);

    //LEEK DATAGEN
    public static void registerCrop(BlockStateModelGenerator blockstateModelGenerator, Block crop, Property<Integer> ageProperty, int... ageTextureIndices) {
        if (ageProperty.getValues().size() != ageTextureIndices.length) {
            throw new IllegalArgumentException();
        } else {
            Int2ObjectMap<Identifier> int2ObjectMap = new Int2ObjectOpenHashMap<>();
            BlockStateVariantMap blockStateVariantMap = BlockStateVariantMap.create(ageProperty).register((integer) -> {
                int agreIntProp = ageTextureIndices[integer];
                Identifier identifier = int2ObjectMap.computeIfAbsent(agreIntProp, (j) -> blockstateModelGenerator.createSubModel(crop, "_stage" + agreIntProp, LEEK, TextureMap::cross));
                return BlockStateVariant.create().put(VariantSettings.MODEL, identifier);
            });
//            blockstateModelGenerator.registerItemModel(crop.asItem());
            blockstateModelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(crop).coordinate(blockStateVariantMap));
        }
    }

}
