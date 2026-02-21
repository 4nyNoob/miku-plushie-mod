package com.any.mikuplushie.datagen;

import com.any.mikuplushie.MikuPlushie;
import com.any.mikuplushie.util.ModUtil;
import com.google.gson.JsonElement;
import it.unimi.dsi.fastutil.ints.Int2ObjectFunction;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelOutput;
import net.minecraft.client.data.models.MultiVariant;
import net.minecraft.client.data.models.blockstates.BlockModelDefinitionGenerator;
import net.minecraft.client.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.client.data.models.blockstates.PropertyDispatch;
import net.minecraft.client.data.models.model.*;
import net.minecraft.client.renderer.block.model.BlockModel;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.Property;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import static net.minecraft.client.data.models.BlockModelGenerators.createAxisAlignedPillarBlock;
import static net.minecraft.client.data.models.BlockModelGenerators.plainVariant;
import static net.minecraft.client.data.models.model.TexturedModel.createDefault;

public class BlockModels {
//    public final Consumer<BlockStateGenerator> blockStateCollector;
//    public final BiConsumer<ResourceLocation, Supplier<JsonElement>> modelCollector;


    public final Consumer<BlockModelDefinitionGenerator> blockStateOutput;
    public final ItemModelOutput itemModelOutput;
    public final BiConsumer<Identifier, ModelInstance> modelOutput;

    public BlockModels(Consumer<BlockModelDefinitionGenerator> blockStateOutput, ItemModelOutput itemModelOutput, BiConsumer<Identifier, ModelInstance> modelOutput) {
        this.blockStateOutput = blockStateOutput;
        this.itemModelOutput = itemModelOutput;
        this.modelOutput = modelOutput;
    }


//    private static ModelTemplate block(String parent, TextureSlot... requiredTextureKeys) {
//        return new ModelTemplate(Optional.of(ResourceLocation.fromNamespaceAndPath(MikuPlushie.MOD_ID, "block/" + parent)), Optional.empty(), requiredTextureKeys);
//    }

    //PARENT MODELS
    public static final ModelTemplate LEEK_MODEL = create("leek", TextureSlot.CROSS);

    private static ModelTemplate create(TextureSlot... textureSlots) {
        return new ModelTemplate(Optional.empty(), Optional.empty(), textureSlots);
    }

    private static ModelTemplate create(String string, TextureSlot... textureSlots) {
        return new ModelTemplate(Optional.of(Identifier.withDefaultNamespace("block/" + string)), Optional.empty(), textureSlots);
    }


    //CROP BLOCKSTATE GEN
//    public static void registerCrop(BlockModelGenerators blockstateModelGenerator, Block crop, Property<Integer> ageProperty, int... ageTextureIndices) {
//        if (ageProperty.getPossibleValues().size() != ageTextureIndices.length) {
//            throw new IllegalArgumentException();
//        } else {
//            Int2ObjectMap<ResourceLocation> int2ObjectMap = new Int2ObjectOpenHashMap<>();
//            PropertyDispatch blockStateVariantMap = PropertyDispatch.property(ageProperty).generate((integer) -> {
//                int agreIntProp = ageTextureIndices[integer];
//                ResourceLocation identifier = int2ObjectMap.computeIfAbsent(agreIntProp, (j) -> blockstateModelGenerator.createSuffixedVariant(crop, "_stage" + agreIntProp, LEEK_MODEL, TextureMapping::cross));
//                return Variant.variant().with(VariantProperties.MODEL, identifier);
//            });
//            blockstateModelGenerator.blockStateOutput.accept(MultiVariantGenerator.multiVariant(crop).with(blockStateVariantMap));
//        }
//    }



    public static void registerCrop(BlockModelGenerators blockStateModelGenerator, Block block, Property<Integer> property, int... is) {
        blockStateModelGenerator.registerSimpleFlatItemModel(block.asItem());
        if (property.getPossibleValues().size() != is.length) {
            throw new IllegalArgumentException();
        } else {
            Int2ObjectMap<Identifier> int2ObjectMap = new Int2ObjectOpenHashMap<>();
            blockStateModelGenerator.blockStateOutput
                .accept(
                    MultiVariantGenerator.dispatch(block)
                        .with(
                            PropertyDispatch.initial(property)
                                .generate(
                                    integer -> {
                                        int i = is[integer];
                                        return plainVariant(
                                            int2ObjectMap.computeIfAbsent(
                                                i, (Int2ObjectFunction<? extends Identifier>)(ix -> blockStateModelGenerator.createSuffixedVariant(block, "_stage" + ix, LEEK_MODEL, TextureMapping::crop))
                                            )
                                        );
                                    }
                                )
                        )
                );
        }
    }
//    public static final void registerWildCrop(BlockModelGenerators blockStateModelGenerator, Block block) {
//
//    }

    public static final TexturedModel.Provider CARPET = createDefault(TextureMapping::cross, ModelTemplates.CROSS);

    public static void registerWildCrop(BlockModelGenerators blockStateModelGenerator, Block block, BlockModelGenerators.PlantType plantType) {
        MultiVariant multiVariant = plainVariant(plantType.getCross().create(block, plantType.getTextureMapping(block), blockStateModelGenerator.modelOutput));
        blockStateModelGenerator.blockStateOutput.accept(BlockModelGenerators.createSimpleBlock(block, multiVariant));
    }



////    CROP BLOCKSTATE GEN
//    public static void registerWildCrop(BlockModelGenerators blockstateModelGenerator, Block block, Block tamedBlock) {
//        int maxAge = CropBlock.MAX_AGE;
//        TextureMapping textureMap = TextureMapping.cross(
//            ResourceLocation.fromNamespaceAndPath(MikuPlushie.MOD_ID, "block/" + ModUtil.getBlockIdFromBlock(tamedBlock) + "_stage" + maxAge)
//        );
//        blockstateModelGenerator.createCrossBlock(block, BlockModelGenerators.TintState.NOT_TINTED, textureMap);
//    }

}
