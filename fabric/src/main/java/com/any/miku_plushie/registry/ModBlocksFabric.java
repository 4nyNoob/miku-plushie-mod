package com.any.miku_plushie.registry;

import com.any.miku_plushie.Constants;
import com.any.miku_plushie.MikuPlushieFabric;
import com.any.miku_plushie.block.LeekCropBlock;
import com.any.miku_plushie.block.MikuPlushieBlock;
import com.any.miku_plushie.block.WildLeekCropBlock;
import com.any.miku_plushie.impl.common.registry.ModBlocks;
import java.util.Objects;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import org.jetbrains.annotations.Nullable;

public class ModBlocksFabric {

  public static void initialize() {

    MikuPlushieFabric.LOGGER.info("Registering " + Constants.MOD_ID + " Blocks");

    ModBlocks.MIKU_PLUSH_BR = registerPlush("miku_plush_br", null);
    ModBlocks.MIKU_PLUSH_BR_BA = registerPlush("miku_plush_br_ba", null);
    ModBlocks.MIKU_PLUSH_BIK = registerPlush("miku_plush_bik", null);
    ModBlocks.MIKU_PLUSH_BR_BEACH = registerPlush("miku_plush_br_beach", null);
    ModBlocks.MIKU_PLUSH_BR_BRAID = registerPlush("miku_plush_br_braid", null);
    ModBlocks.MIKU_PLUSH_BR_BA_DRUM = registerPlush("miku_plush_br_ba_drum", null);
    ModBlocks.MIKU_PLUSH_BR_PA = registerPlush("miku_plush_br_pa", null);
    ModBlocks.MIKU_PLUSH_BR_SP = registerPlush("miku_plush_br_sp", null);
    ModBlocks.MIKU_PLUSH_BR_MG = registerPlush("miku_plush_br_mg", null);
    ModBlocks.MIKU_PLUSH_BR_BROWN_BRO = registerPlush("miku_plush_br_brown_bro", null);
    ModBlocks.MIKU_PLUSH_BR_ELECTRICIAN = registerPlush("miku_plush_br_electrician", null);
    ModBlocks.MIKU_PLUSH_BR_BIK_ORANGE = registerPlush("miku_plush_br_bik_orange", null);
    ModBlocks.MIKU_PLUSH_BR_AM = registerPlush("miku_plush_br_am", null);
    ModBlocks.MIKU_PLUSH_BR_FUT_FLA = registerPlush("miku_plush_br_fut_fla", null);
    ModBlocks.MIKU_PLUSH_BR_FUT_CAM = registerPlush("miku_plush_br_fut_cam", null);
    ModBlocks.MIKU_PLUSH_BR_GO = registerPlush("miku_plush_br_go", null);
    ModBlocks.MIKU_PLUSH_BR_SCHOOL_PE = registerPlush("miku_plush_br_school_pe", null);
    ModBlocks.MIKU_PLUSH_BR_FUT_CRVG = registerPlush("miku_plush_br_fut_crvg", null);
    ModBlocks.MIKU_PLUSH_BR_RS = registerPlush("miku_plush_br_rs", null);
    ModBlocks.MIKU_PLUSH_FROG = registerPlush("miku_plush_frog", null);
    ModBlocks.MIKU_PLUSH_MUSHROOM = registerPlush("miku_plush_mushroom", null);
    ModBlocks.MIKU_PLUSH_SENBONZAKURA = registerPlush("miku_plush_senbonzakura", null);
    ModBlocks.MIKU_PLUSH_URAOTOMELOVERS = registerPlush("miku_plush_uraotomelovers", null);
    ModBlocks.MIKU_PLUSH_PERSONADANCING = registerPlush("miku_plush_personadancing", null);
    ModBlocks.MIKU_PLUSH_HELLOPLANET = registerPlush("miku_plush_helloplanet", null);
    ModBlocks.MIKU_PLUSH_HACHUNE = registerPlush("miku_plush_hachune", null);
    ModBlocks.MIKU_PLUSH_ZATSUNE = registerPlush("miku_plush_zatsune", null);
    ModBlocks.MIKU_PLUSH_INFINITY = registerPlush("miku_plush_infinity", null);
    ModBlocks.MIKU_PLUSH_VAMPIRE = registerPlush("miku_plush_vampire", null);
    ModBlocks.MIKU_PLUSH_WEREWOMAN = registerPlush("miku_plush_werewoman", null);
    ModBlocks.MIKU_PLUSH_JASON = registerPlush("miku_plush_jason", null);
    ModBlocks.MIKU_PLUSH_MICHAEL_MYERS = registerPlush("miku_plush_michael_myers", null);
    ModBlocks.MIKU_PLUSH_PUMPKIN = registerPlush("miku_plush_pumpkin", null);
    ModBlocks.MIKU_PLUSH_GHOSTFACE = registerPlush("miku_plush_ghostface", null);
    ModBlocks.MIKU_PLUSH_FRANKENSTEIN = registerPlush("miku_plush_frankenstein", null);
    ModBlocks.MIKU_PLUSH_MUMMY = registerPlush("miku_plush_mummy", null);
    ModBlocks.MIKU_PLUSH_GHOST = registerPlush("miku_plush_ghost", SoundType.GLASS);
    ModBlocks.MIKU_PLUSH_PATATI = registerPlush("miku_plush_patati", null);
    ModBlocks.MIKU_PLUSH_PATATA = registerPlush("miku_plush_patata", null);
    ModBlocks.MIKU_PLUSH_DEVIL = registerPlush("miku_plush_devil", null);
    ModBlocks.MIKU_PLUSH_WITCH = registerPlush("miku_plush_witch", null);
    ModBlocks.MIKU_PLUSH_SANTA = registerPlush("miku_plush_santa", null);
    ModBlocks.MIKU_PLUSH_REINDEER = registerPlush("miku_plush_reindeer", null);
    ModBlocks.MIKU_PLUSH_SANTA_ELF = registerPlush("miku_plush_santa_elf", null);
    ModBlocks.MIKU_PLUSH_XMAS_TREE = registerPlush("miku_plush_xmas_tree", null);
    ModBlocks.AIKO_PLUSH = registerPlush("aiko_plush", null);
    ModBlocks.TETO_PLUSH = registerPlush("teto_plush", null);
    ModBlocks.AKITA_NERU_PLUSH = registerPlush("akita_neru_plush", null);
    ModBlocks.MIKU_PLUSH = registerPlush("miku_plush", null);
    ModBlocks.RIN_PLUSH = registerPlush("rin_plush", null);
    ModBlocks.LEN_PLUSH = registerPlush("len_plush", null);
    ModBlocks.MIKU_PLUSH_SONIC_CROSSWORLDS = registerPlush("miku_plush_sonic_crossworlds", null);
    ModBlocks.MIKU_PLUSH_FORTNITE_NEKO = registerPlush("miku_plush_fortnite_neko", null);
    ModBlocks.MIKU_PLUSH_V4 = registerPlush("miku_plush_v4", null);
    ModBlocks.MIKU_PLUSH_MESMERIZER = registerPlush("miku_plush_mesmerizer", null);
    ModBlocks.TETO_PLUSH_MESMERIZER = registerPlush("teto_plush_mesmerizer", null);
    ModBlocks.MIKU_PLUSH_SONIC = registerPlush("miku_plush_sonic", null);
    ModBlocks.TETO_PLUSH_SHADOW = registerPlush("teto_plush_shadow", null);
    ModBlocks.AKITA_NERU_PLUSH_TAILS = registerPlush("akita_neru_plush_tails", null);
    ModBlocks.TETO_PLUSH_BIRDBRAIN = registerPlush("teto_plush_birdbrain", null);
    ModBlocks.MIKU_PLUSH_DIGITAL_STARS_2025 = registerPlush("miku_plush_digital_stars_2025", null);
    ModBlocks.MIKU_PLUSH_ROTTEN_GIRL = registerPlush("miku_plush_rotten_girl", null);
    ModBlocks.TETO_PLUSH_REGRET_ROCK = registerPlush("teto_plush_regret_rock", null);
    ModBlocks.MIKU_PLUSH_PSYCHO_MODE = registerPlush("miku_plush_psycho_mode", null);
    ModBlocks.MIKU_PLUSH_DONT_BELIEVE_IN_T = registerPlush("miku_plush_dont_believe_in_t", null);
    ModBlocks.TETO_PLUSH_DONT_BELIEVE_IN_T = registerPlush("teto_plush_dont_believe_in_t", null);
    ModBlocks.TETO_PLUSH_LIAR_DANCER = registerPlush("teto_plush_liar_dancer", null);
    ModBlocks.MIKU_PLUSH_STATIC = registerPlush("miku_plush_static", null);
    ModBlocks.MIKU_PLUSH_MOCHIMOCHI = registerPlush("miku_plush_mochimochi", null);
    ModBlocks.TETO_PLUSH_WHATCHACALLITSNAME = registerPlush("teto_plush_whatchacallitsname", null);
    ModBlocks.MIKU_PLUSH_MONITORING = registerPlush("miku_plush_monitoring", null);
    ModBlocks.KONOHA_PLUSH = registerPlush("konoha_plush", null);
    ModBlocks.LUKA_PLUSH = registerPlush("luka_plush", null);
    ModBlocks.TETO_PLUSH_SOME_MORE_OF_THAT_SONG = registerPlush("teto_plush_some_more_of_that_song", null);
    ModBlocks.TETO_PLUSH_LOBSTER = registerPlush("teto_plush_lobster", null);
    ModBlocks.MIKU_PLUSH_HOLLOW_KNIGHT = registerPlush("miku_plush_hollow_knight", null);
    ModBlocks.MIKU_PLUSH_HORNET = registerPlush("miku_plush_hornet", null);
    ModBlocks.TETO_PLUSH_SYNTHV = registerPlush("teto_plush_synthv", null);
    ModBlocks.MIKU_PLUSH_WORLD_IS_MINE = registerPlush("miku_plush_world_is_mine", null);
    ModBlocks.MIKU_PLUSH_ROLLING_GIRL = registerPlush("miku_plush_rolling_girl", null);
    ModBlocks.TETO_PLUSH_SPOKEN_FOR = registerPlush("teto_plush_spoken_for", null);
    ModBlocks.MEIKO_PLUSH = registerPlush("meiko_plush", null);
    ModBlocks.MEIKO_PLUSH_V3 = registerPlush("meiko_plush_v3", null);
    ModBlocks.MEIKO_PLUSH_V4 = registerPlush("meiko_plush_v4", null);
    ModBlocks.GUMI_PLUSH = registerPlush("gumi_plush", null);
    ModBlocks.GUMI_PLUSH_V3 = registerPlush("gumi_plush_v3", null);
    ModBlocks.GUMI_PLUSH_V4 = registerPlush("gumi_plush_v4", null);
    ModBlocks.GUMI_PLUSH_V6 = registerPlush("gumi_plush_v6", null);
    ModBlocks.MIKU_PLUSH_DEEP_SEA_GIRL = registerPlush("miku_plush_deep_sea_girl", null);
    ModBlocks.MIKU_PLUSH_LUCARIO_Z = registerPlush("miku_plush_lucario_z", null);
    ModBlocks.TETO_PLUSH_PPPP = registerPlush("teto_plush_pppp", null);
    ModBlocks.MIKU_PLUSH_PPPP = registerPlush("miku_plush_pppp", null);
    ModBlocks.TETO_PLUSH_SHRIMP = registerPlush("teto_plush_shrimp", null);
    ModBlocks.MIKU_PLUSH_LINK = registerPlush("miku_plush_link", null);
    ModBlocks.MIKU_PLUSH_RENAISSANCE = registerPlush("miku_plush_renaissance", null);
    ModBlocks.KAITO_PLUSH = registerPlush("kaito_plush", null);
    ModBlocks.KAITO_PLUSH_V3 = registerPlush("kaito_plush_v3", null);
    ModBlocks.KAITO_PLUSH_V4 = registerPlush("kaito_plush_v4", null);

    ModBlocks.LEEK_CROP = register(
        new LeekCropBlock(BlockBehaviour.Properties.of()
            .noOcclusion().noCollission().randomTicks().instabreak().sound(SoundType.CROP)),
        "leek_crop",
        false
    );
    ModBlocks.WILD_LEEK_CROP = register(
        new WildLeekCropBlock(BlockBehaviour.Properties.of()
            .noOcclusion().noCollission().randomTicks().instabreak().sound(SoundType.CROP)),
        "wild_leek_crop",
        false
    );
  }

  //REGISTER PLUSHIES
  public static Block registerPlush(String name, @Nullable SoundType blockSound) {
    //IF THE BLOCK SOUND IS NULL SET TO WOOL
    SoundType blockSoundGroup = null;
    blockSoundGroup = Objects.requireNonNullElse(blockSound, SoundType.WOOL);
    //REGISTER BLOCK NORMALLY
    return register(
        new MikuPlushieBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT)
            .sound(blockSoundGroup).noOcclusion()), name, false);
  }

  //REGISTER REGULAR BLOCKS
  public static Block register(Block block, String name, boolean shouldRegisterItem) {
    //CREATE IDENTIFIER
    ResourceLocation id = ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, name);

    //REGISTER ITEM IF REQUESTED
    if (shouldRegisterItem) {
      BlockItem blockItem = new BlockItem(block, new Item.Properties());
      Registry.register(BuiltInRegistries.ITEM, id, blockItem);
    }

    Block blockRegister = Registry.register(BuiltInRegistries.BLOCK, id, block);

    //IF BLOCK IS A PLUSH ADD IT TO THE LIST
    if (block instanceof MikuPlushieBlock) {
      ModBlocks.PLUSH_BLOCKS.add(block);
    }

    return blockRegister;
  }
}
