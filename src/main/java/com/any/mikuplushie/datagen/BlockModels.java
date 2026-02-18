package com.any.mikuplushie.datagen;

import com.any.mikuplushie.MikuPlushie;
import com.any.mikuplushie.util.ModUtil;
import com.google.gson.JsonElement;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import net.minecraft.data.models.BlockModelGenerators;
import net.minecraft.data.models.blockstates.BlockStateGenerator;
import net.minecraft.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.data.models.blockstates.PropertyDispatch;
import net.minecraft.data.models.blockstates.Variant;
import net.minecraft.data.models.blockstates.VariantProperties;
import net.minecraft.data.models.model.ModelTemplate;
import net.minecraft.data.models.model.TextureMapping;
import net.minecraft.data.models.model.TextureSlot;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.properties.Property;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class BlockModels {
    public final Consumer<BlockStateGenerator> blockStateCollector;
    public final BiConsumer<ResourceLocation, Supplier<JsonElement>> modelCollector;

    public BlockModels(Consumer<BlockStateGenerator> blockStateCollector, BiConsumer<ResourceLocation, Supplier<JsonElement>> modelCollector) {
        this.blockStateCollector = blockStateCollector;
        this.modelCollector = modelCollector;
    }

    private static ModelTemplate block(String parent, TextureSlot... requiredTextureKeys) {
        return new ModelTemplate(Optional.of(ResourceLocation.fromNamespaceAndPath(MikuPlushie.MOD_ID, "block/" + parent)), Optional.empty(), requiredTextureKeys);
    }

    //PARENT MODELS
    public static final ModelTemplate LEEK_MODEL = block("leek", TextureSlot.CROSS);

    //CROP BLOCKSTATE GEN
    public static void registerCrop(BlockModelGenerators blockstateModelGenerator, Block crop, Property<Integer> ageProperty, int... ageTextureIndices) {
        if (ageProperty.getPossibleValues().size() != ageTextureIndices.length) {
            throw new IllegalArgumentException();
        } else {
            Int2ObjectMap<ResourceLocation> int2ObjectMap = new Int2ObjectOpenHashMap<>();
            PropertyDispatch blockStateVariantMap = PropertyDispatch.property(ageProperty).generate((integer) -> {
                int agreIntProp = ageTextureIndices[integer];
                ResourceLocation identifier = int2ObjectMap.computeIfAbsent(agreIntProp, (j) -> blockstateModelGenerator.createSuffixedVariant(crop, "_stage" + agreIntProp, LEEK_MODEL, TextureMapping::cross));
                return Variant.variant().with(VariantProperties.MODEL, identifier);
            });
            blockstateModelGenerator.blockStateOutput.accept(MultiVariantGenerator.multiVariant(crop).with(blockStateVariantMap));
        }
    }

    //CROP BLOCKSTATE GEN
    public static void registerWildCrop(BlockModelGenerators blockstateModelGenerator, Block block, Block tamedBlock) {
        int maxAge = CropBlock.MAX_AGE;
        TextureMapping textureMap = TextureMapping.cross(
            ResourceLocation.fromNamespaceAndPath(MikuPlushie.MOD_ID, "block/" + ModUtil.getBlockIdFromBlock(tamedBlock) + "_stage" + maxAge)
        );
        blockstateModelGenerator.createCrossBlock(block, BlockModelGenerators.TintState.NOT_TINTED, textureMap);
    }

}
