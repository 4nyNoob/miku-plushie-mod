package com.any.miku_plushie.impl.common.datagen;

import com.any.miku_plushie.Constants;
import com.any.miku_plushie.MikuPlushie;
import com.any.miku_plushie.impl.common.registry.ModBlocks;
import com.any.miku_plushie.impl.common.registry.ModItems;
import com.any.miku_plushie.impl.common.util.ModUtil;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.minecraft.ChatFormatting;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.advancements.AdvancementType;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.Registry;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class ModAdvancements extends FabricAdvancementProvider {
  protected ModAdvancements(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registryLookup) {
    super(output, registryLookup);
  }

  @Override
  public void generateAdvancement(HolderLookup.Provider registryLookup, Consumer<AdvancementHolder> consumer) {
    // CRAFT MIKU PLUSH
    AdvancementHolder craftMiku = Advancement.Builder.advancement()
      .display(
        ModBlocks.MIKU_PLUSH,
        Component.translatable("advancements.miku_plushie.craft_miku.title"),
        Component.translatable("advancements.miku_plushie.craft_miku.description"),
        ResourceLocation.withDefaultNamespace("textures/gui/advancements/backgrounds/adventure.png"),
        AdvancementType.TASK,
        true,
        false,
        true)
      .addCriterion("craft_miku", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.MIKU_PLUSH))
      .save(consumer, Constants.MOD_ID + "/craft_miku");

    // ADD ADVANCEMENT FOR EACH PLUSH KIND
    for (String plushName : Constants.PLUSH_NAMES){

      if (!(plushName.equals("konoha") | plushName.equals("len") | plushName.equals("rin"))) {

        // CREATE PLUSH KIND DISPLAY
        AdvancementHolder plushMain = null;
        Block displayBlock = ModBlocks.MIKU_PLUSH;

        for (Block block : ModBlocks.PLUSH_BLOCKS){
          // CREATE MAIN PLUSH ADVANCEMENT
          if (ModUtil.getBlockIdFromBlock(block).contains(plushName)){
            // BLOCK TO DISPLAY ON COLLECTION ADVANCEMENT
            displayBlock = block;
            plushMain = Advancement.Builder.advancement()
              .parent(craftMiku)
              .display(
                block,
                Component.translatable("advancements.miku_plushie.craft_" + plushName + ".title"),
                Component.translatable("advancements.miku_plushie.craft_" + plushName + ".description"),
                null,
                AdvancementType.TASK,
                true,
                false,
                false)
              .addCriterion("craft_" + plushName, InventoryChangeTrigger.TriggerInstance.hasItems(block))
              .save(consumer, Constants.MOD_ID + "/craft_" + plushName);
          }
        }

        // CREATE COLLECTION ADVANCEMENT
        Advancement.Builder plushCollection = Advancement.Builder.advancement().parent(plushMain).display(
          displayBlock,
          Component.translatable("advancements.miku_plushie.collect_" + plushName + ".title"),
          Component.translatable("advancements.miku_plushie.collect_" + plushName + ".description"),
          null, AdvancementType.CHALLENGE, true, false, false
        );

        // CREATE CRITERION FOR EVERY PLUSH
        for (Block block : ModBlocks.PLUSH_BLOCKS) {
          if (ModUtil.getBlockIdFromBlock(block).contains(plushName)){
            plushCollection.addCriterion("collect_" + block, InventoryChangeTrigger.TriggerInstance.hasItems(block));
          }
        }

        // CREATE COLLECTION ADVANCEMENT
        plushCollection.save(consumer, Constants.MOD_ID + "/collect_" + plushName);

      }
    }

    //CREATE RIN AND LEN ADVANCEMENT
    AdvancementHolder craftRinLen = Advancement.Builder.advancement()
    .parent(craftMiku)
    .display(
        ModBlocks.RIN_PLUSH,
        Component.translatable("advancements.miku_plushie.craft_rin_len.title"),
        Component.translatable("advancements.miku_plushie.craft_rin_len.description"),
        null,
        AdvancementType.TASK,
        true,
        false,
        false)
    .addCriterion("craft_rin", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.RIN_PLUSH))
    .addCriterion("craft_len", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.LEN_PLUSH))
    .save(consumer, Constants.MOD_ID + "/craft_rin_len");
  }
}
