package com.any.miku_plushie.impl.common.datagen;

import com.any.miku_plushie.Constants;
import com.any.miku_plushie.impl.common.util.ModUtil;
import com.google.gson.JsonElement;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

import net.minecraft.client.data.models.model.*;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.client.data.models.blockstates.PropertyDispatch;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.properties.Property;

import static net.minecraft.client.data.models.BlockModelGenerators.plainVariant;

public record BlockModels(Consumer<BlockStateGenerator> blockStateCollector, BiConsumer<Identifier, Supplier<JsonElement>> modelCollector) {

  //PARENT MODELS
  public static final ModelTemplate LEEK_MODEL = block("leek", TextureSlot.CROSS);
  public static final ModelTemplate CROSS_CUTOUT = block("cross_cutout", TextureSlot.CROSS);

  private static ModelTemplate block(String parent, TextureSlot... requiredTextureKeys) {
    return new ModelTemplate(Optional.of(Identifier.fromNamespaceAndPath(Constants.MOD_ID, "block/" + parent)), Optional.empty(), requiredTextureKeys);
  }

  //CROP BLOCKSTATE GEN
//  public static void registerCrop(BlockModelGenerators blockstateModelGenerator, Block crop, Property<Integer> ageProperty, int... ageTextureIndices) {
//    if (ageProperty.getPossibleValues().size() != ageTextureIndices.length) {
//      throw new IllegalArgumentException();
//    } else {
//      Int2ObjectMap<Identifier> int2ObjectMap = new Int2ObjectOpenHashMap<>();
//      PropertyDispatch blockStateVariantMap = PropertyDispatch.property(ageProperty).generate((integer) -> {
//        int agreIntProp = ageTextureIndices[integer];
//        Identifier identifier = int2ObjectMap.computeIfAbsent(agreIntProp,
//            (j) -> blockstateModelGenerator.createSuffixedVariant(crop, "_stage" + agreIntProp, LEEK_MODEL, TextureMapping::cross));
//        return Variant.variant().with(VariantProperties.MODEL, identifier);
//      });
//      blockstateModelGenerator.blockStateOutput.accept(MultiVariantGenerator.multiVariant(crop).with(blockStateVariantMap));
//    }
//  }

  public void createCropBlock(BlockModelGenerators blockModelGenerators, Block block, Property<Integer> property, int... stages) {
//    this.registerSimpleFlatItemModel(block.asItem());
    if (property.getPossibleValues().size() != stages.length) {
      throw new IllegalArgumentException();
    } else {
      Int2ObjectMap<Identifier> models = new Int2ObjectOpenHashMap<>();
      blockModelGenerators.blockStateOutput
        .accept(
          MultiVariantGenerator.dispatch(block)
            .with(
              PropertyDispatch.initial(property)
                .generate(
                  i -> {
                    int stage = stages[i];
                    return plainVariant(
                      models.computeIfAbsent(
                        stage, s -> blockModelGenerators.createSuffixedVariant(block, "_stage" + s, LEEK_MODEL, TextureMapping::crop)
                      )
                    );
                  }
                )
            )
        );
    }
  }

  //CROP BLOCKSTATE GEN
  public static void registerWildCrop(BlockModelGenerators blockstateModelGenerator, Block block, Block tamedBlock) {
    int maxAge = CropBlock.MAX_AGE;
    TextureMapping textureMap = TextureMapping.cross(
        Identifier.fromNamespaceAndPath(Constants.MOD_ID, "block/" + ModUtil.getBlockIdFromBlock(tamedBlock) + "_stage" + maxAge)
    );
    Identifier model = CROSS_CUTOUT.create(block, textureMap, blockstateModelGenerator.modelOutput);
    blockstateModelGenerator.blockStateOutput.accept(BlockModelGenerators.createSimpleBlock(block, model));
  }

}
