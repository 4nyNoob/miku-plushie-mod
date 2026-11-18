package com.any.miku_plushie.impl.common.registry;

import com.any.miku_plushie.Constants;
import com.any.miku_plushie.MikuPlushie;
import com.any.miku_plushie.impl.common.block.LeekCropBlock;
import com.any.miku_plushie.impl.common.block.MikuPlushieBlock;
import com.any.miku_plushie.impl.common.block.WildLeekCropBlock;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.BiConsumer;

import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import org.jetbrains.annotations.Nullable;
import oshi.util.tuples.Pair;

public class ModBlocks {

  public static final List<Block> PLUSH_BLOCKS = new ArrayList<>();
  public static final List<Pair<Block, Identifier>> NEEDS_BLOCK_ITEM = new ArrayList<>();

  public static Block MIKU_PLUSH_BR;
  public static Block MIKU_PLUSH_BR_BA;
  public static Block MIKU_PLUSH_BIK;
  public static Block MIKU_PLUSH_BR_BEACH;
  public static Block MIKU_PLUSH_BR_BRAID;
  public static Block MIKU_PLUSH_BR_BA_DRUM;
  public static Block MIKU_PLUSH_BR_PA;
  public static Block MIKU_PLUSH_BR_SP;
  public static Block MIKU_PLUSH_BR_MG;
  public static Block MIKU_PLUSH_BR_BROWN_BRO;
  public static Block MIKU_PLUSH_BR_ELECTRICIAN;
  public static Block MIKU_PLUSH_BR_BIK_ORANGE;
  public static Block MIKU_PLUSH_BR_AM;
  public static Block MIKU_PLUSH_BR_FUT_FLA;
  public static Block MIKU_PLUSH_BR_FUT_CAM;
  public static Block MIKU_PLUSH_BR_GO;
  public static Block MIKU_PLUSH_BR_SCHOOL_PE;
  public static Block MIKU_PLUSH_BR_FUT_CRVG;
  public static Block MIKU_PLUSH_BR_RS;
  public static Block MIKU_PLUSH_FROG;
  public static Block MIKU_PLUSH_MUSHROOM;
  public static Block MIKU_PLUSH_SENBONZAKURA;
  public static Block MIKU_PLUSH_URAOTOMELOVERS;
  public static Block MIKU_PLUSH_PERSONADANCING;
  public static Block MIKU_PLUSH_HELLOPLANET;
  public static Block MIKU_PLUSH_HACHUNE;
  public static Block MIKU_PLUSH_ZATSUNE;
  public static Block MIKU_PLUSH_INFINITY;
  public static Block MIKU_PLUSH_VAMPIRE;
  public static Block MIKU_PLUSH_WEREWOMAN;
  public static Block MIKU_PLUSH_JASON;
  public static Block MIKU_PLUSH_MICHAEL_MYERS;
  public static Block MIKU_PLUSH_PUMPKIN;
  public static Block MIKU_PLUSH_GHOSTFACE;
  public static Block MIKU_PLUSH_FRANKENSTEIN;
  public static Block MIKU_PLUSH_MUMMY;
  public static Block MIKU_PLUSH_GHOST;
  public static Block MIKU_PLUSH_PATATI;
  public static Block MIKU_PLUSH_PATATA;
  public static Block MIKU_PLUSH_DEVIL;
  public static Block MIKU_PLUSH_WITCH;
  public static Block MIKU_PLUSH_SANTA;
  public static Block MIKU_PLUSH_REINDEER;
  public static Block MIKU_PLUSH_SANTA_ELF;
  public static Block MIKU_PLUSH_XMAS_TREE;
  public static Block AIKO_PLUSH;
  public static Block TETO_PLUSH;
  public static Block AKITA_NERU_PLUSH;
  public static Block MIKU_PLUSH;
  public static Block RIN_PLUSH;
  public static Block LEN_PLUSH;
  public static Block MIKU_PLUSH_SONIC_CROSSWORLDS;
  public static Block MIKU_PLUSH_FORTNITE_NEKO;
  public static Block MIKU_PLUSH_V4;
  public static Block MIKU_PLUSH_MESMERIZER;
  public static Block TETO_PLUSH_MESMERIZER;
  public static Block MIKU_PLUSH_SONIC;
  public static Block TETO_PLUSH_SHADOW;
  public static Block AKITA_NERU_PLUSH_TAILS;
  public static Block TETO_PLUSH_BIRDBRAIN;
  public static Block MIKU_PLUSH_DIGITAL_STARS_2025;
  public static Block MIKU_PLUSH_ROTTEN_GIRL;
  public static Block TETO_PLUSH_REGRET_ROCK;
  public static Block MIKU_PLUSH_PSYCHO_MODE;
  public static Block MIKU_PLUSH_DONT_BELIEVE_IN_T;
  public static Block TETO_PLUSH_DONT_BELIEVE_IN_T;
  public static Block TETO_PLUSH_LIAR_DANCER;
  public static Block MIKU_PLUSH_STATIC;
  public static Block MIKU_PLUSH_MOCHIMOCHI;
  public static Block TETO_PLUSH_WHATCHACALLITSNAME;
  public static Block MIKU_PLUSH_MONITORING;
  public static Block KONOHA_PLUSH;
  public static Block LUKA_PLUSH;
  public static Block TETO_PLUSH_SOME_MORE_OF_THAT_SONG;
  public static Block TETO_PLUSH_LOBSTER;
  public static Block MIKU_PLUSH_HOLLOW_KNIGHT;
  public static Block MIKU_PLUSH_HORNET;
  public static Block TETO_PLUSH_SYNTHV;
  public static Block MIKU_PLUSH_WORLD_IS_MINE;
  public static Block MIKU_PLUSH_ROLLING_GIRL;
  public static Block TETO_PLUSH_SPOKEN_FOR;
  public static Block MEIKO_PLUSH;
  public static Block MEIKO_PLUSH_V3;
  public static Block MEIKO_PLUSH_V4;
  public static Block GUMI_PLUSH;
  public static Block GUMI_PLUSH_V3;
  public static Block GUMI_PLUSH_V4;
  public static Block GUMI_PLUSH_V6;
  public static Block MIKU_PLUSH_DEEP_SEA_GIRL;
  public static Block MIKU_PLUSH_LUCARIO_Z;
  public static Block TETO_PLUSH_PPPP;
  public static Block MIKU_PLUSH_PPPP;
  public static Block TETO_PLUSH_SHRIMP;
  public static Block MIKU_PLUSH_LINK;
  public static Block MIKU_PLUSH_RENAISSANCE;
  public static Block KAITO_PLUSH;
  public static Block KAITO_PLUSH_V3;
  public static Block KAITO_PLUSH_V4;

  // region non-plush
  public static Block LEEK_CROP;
  public static Block WILD_LEEK_CROP;
  // endregion non-plush

  public static void register(BiConsumer<Block, Identifier> consumer) {

    Constants.LOG.info("Registering " + Constants.MOD_ID + " Blocks");

    MIKU_PLUSH_BR = registerPlush(consumer, "miku_plush_br", null);
    MIKU_PLUSH_BR_BA = registerPlush(consumer, "miku_plush_br_ba", null);
    MIKU_PLUSH_BIK = registerPlush(consumer, "miku_plush_bik", null);
    MIKU_PLUSH_BR_BEACH = registerPlush(consumer, "miku_plush_br_beach", null);
    MIKU_PLUSH_BR_BRAID = registerPlush(consumer, "miku_plush_br_braid", null);
    MIKU_PLUSH_BR_BA_DRUM = registerPlush(consumer, "miku_plush_br_ba_drum", null);
    MIKU_PLUSH_BR_PA = registerPlush(consumer, "miku_plush_br_pa", null);
    MIKU_PLUSH_BR_SP = registerPlush(consumer, "miku_plush_br_sp", null);
    MIKU_PLUSH_BR_MG = registerPlush(consumer, "miku_plush_br_mg", null);
    MIKU_PLUSH_BR_BROWN_BRO = registerPlush(consumer, "miku_plush_br_brown_bro", null);
    MIKU_PLUSH_BR_ELECTRICIAN = registerPlush(consumer, "miku_plush_br_electrician", null);
    MIKU_PLUSH_BR_BIK_ORANGE = registerPlush(consumer, "miku_plush_br_bik_orange", null);
    MIKU_PLUSH_BR_AM = registerPlush(consumer, "miku_plush_br_am", null);
    MIKU_PLUSH_BR_FUT_FLA = registerPlush(consumer, "miku_plush_br_fut_fla", null);
    MIKU_PLUSH_BR_FUT_CAM = registerPlush(consumer, "miku_plush_br_fut_cam", null);
    MIKU_PLUSH_BR_GO = registerPlush(consumer, "miku_plush_br_go", null);
    MIKU_PLUSH_BR_SCHOOL_PE = registerPlush(consumer, "miku_plush_br_school_pe", null);
    MIKU_PLUSH_BR_FUT_CRVG = registerPlush(consumer, "miku_plush_br_fut_crvg", null);
    MIKU_PLUSH_BR_RS = registerPlush(consumer, "miku_plush_br_rs", null);
    MIKU_PLUSH_FROG = registerPlush(consumer, "miku_plush_frog", null);
    MIKU_PLUSH_MUSHROOM = registerPlush(consumer, "miku_plush_mushroom", null);
    MIKU_PLUSH_SENBONZAKURA = registerPlush(consumer, "miku_plush_senbonzakura", null);
    MIKU_PLUSH_URAOTOMELOVERS = registerPlush(consumer, "miku_plush_uraotomelovers", null);
    MIKU_PLUSH_PERSONADANCING = registerPlush(consumer, "miku_plush_personadancing", null);
    MIKU_PLUSH_HELLOPLANET = registerPlush(consumer, "miku_plush_helloplanet", null);
    MIKU_PLUSH_HACHUNE = registerPlush(consumer, "miku_plush_hachune", null);
    MIKU_PLUSH_ZATSUNE = registerPlush(consumer, "miku_plush_zatsune", null);
    MIKU_PLUSH_INFINITY = registerPlush(consumer, "miku_plush_infinity", null);
    MIKU_PLUSH_VAMPIRE = registerPlush(consumer, "miku_plush_vampire", null);
    MIKU_PLUSH_WEREWOMAN = registerPlush(consumer, "miku_plush_werewoman", null);
    MIKU_PLUSH_JASON = registerPlush(consumer, "miku_plush_jason", null);
    MIKU_PLUSH_MICHAEL_MYERS = registerPlush(consumer, "miku_plush_michael_myers", null);
    MIKU_PLUSH_PUMPKIN = registerPlush(consumer, "miku_plush_pumpkin", null);
    MIKU_PLUSH_GHOSTFACE = registerPlush(consumer, "miku_plush_ghostface", null);
    MIKU_PLUSH_FRANKENSTEIN = registerPlush(consumer, "miku_plush_frankenstein", null);
    MIKU_PLUSH_MUMMY = registerPlush(consumer, "miku_plush_mummy", null);
    MIKU_PLUSH_GHOST = registerPlush(consumer, "miku_plush_ghost", SoundType.GLASS);
    MIKU_PLUSH_PATATI = registerPlush(consumer, "miku_plush_patati", null);
    MIKU_PLUSH_PATATA = registerPlush(consumer, "miku_plush_patata", null);
    MIKU_PLUSH_DEVIL = registerPlush(consumer, "miku_plush_devil", null);
    MIKU_PLUSH_WITCH = registerPlush(consumer, "miku_plush_witch", null);
    MIKU_PLUSH_SANTA = registerPlush(consumer, "miku_plush_santa", null);
    MIKU_PLUSH_REINDEER = registerPlush(consumer, "miku_plush_reindeer", null);
    MIKU_PLUSH_SANTA_ELF = registerPlush(consumer, "miku_plush_santa_elf", null);
    MIKU_PLUSH_XMAS_TREE = registerPlush(consumer, "miku_plush_xmas_tree", null);
    AIKO_PLUSH = registerPlush(consumer, "aiko_plush", null);
    TETO_PLUSH = registerPlush(consumer, "teto_plush", null);
    AKITA_NERU_PLUSH = registerPlush(consumer, "akita_neru_plush", null);
    MIKU_PLUSH = registerPlush(consumer, "miku_plush", null);
    RIN_PLUSH = registerPlush(consumer, "rin_plush", null);
    LEN_PLUSH = registerPlush(consumer, "len_plush", null);
    MIKU_PLUSH_SONIC_CROSSWORLDS = registerPlush(consumer, "miku_plush_sonic_crossworlds", null);
    MIKU_PLUSH_FORTNITE_NEKO = registerPlush(consumer, "miku_plush_fortnite_neko", null);
    MIKU_PLUSH_V4 = registerPlush(consumer, "miku_plush_v4", null);
    MIKU_PLUSH_MESMERIZER = registerPlush(consumer, "miku_plush_mesmerizer", null);
    TETO_PLUSH_MESMERIZER = registerPlush(consumer, "teto_plush_mesmerizer", null);
    MIKU_PLUSH_SONIC = registerPlush(consumer, "miku_plush_sonic", null);
    TETO_PLUSH_SHADOW = registerPlush(consumer, "teto_plush_shadow", null);
    AKITA_NERU_PLUSH_TAILS = registerPlush(consumer, "akita_neru_plush_tails", null);
    TETO_PLUSH_BIRDBRAIN = registerPlush(consumer, "teto_plush_birdbrain", null);
    MIKU_PLUSH_DIGITAL_STARS_2025 = registerPlush(consumer, "miku_plush_digital_stars_2025", null);
    MIKU_PLUSH_ROTTEN_GIRL = registerPlush(consumer, "miku_plush_rotten_girl", null);
    TETO_PLUSH_REGRET_ROCK = registerPlush(consumer, "teto_plush_regret_rock", null);
    MIKU_PLUSH_PSYCHO_MODE = registerPlush(consumer, "miku_plush_psycho_mode", null);
    MIKU_PLUSH_DONT_BELIEVE_IN_T = registerPlush(consumer, "miku_plush_dont_believe_in_t", null);
    TETO_PLUSH_DONT_BELIEVE_IN_T = registerPlush(consumer, "teto_plush_dont_believe_in_t", null);
    TETO_PLUSH_LIAR_DANCER = registerPlush(consumer, "teto_plush_liar_dancer", null);
    MIKU_PLUSH_STATIC = registerPlush(consumer, "miku_plush_static", null);
    MIKU_PLUSH_MOCHIMOCHI = registerPlush(consumer, "miku_plush_mochimochi", null);
    TETO_PLUSH_WHATCHACALLITSNAME = registerPlush(consumer, "teto_plush_whatchacallitsname", null);
    MIKU_PLUSH_MONITORING = registerPlush(consumer, "miku_plush_monitoring", null);
    KONOHA_PLUSH = registerPlush(consumer, "konoha_plush", null);
    LUKA_PLUSH = registerPlush(consumer, "luka_plush", null);
    TETO_PLUSH_SOME_MORE_OF_THAT_SONG = registerPlush(consumer, "teto_plush_some_more_of_that_song", null);
    TETO_PLUSH_LOBSTER = registerPlush(consumer, "teto_plush_lobster", null);
    MIKU_PLUSH_HOLLOW_KNIGHT = registerPlush(consumer, "miku_plush_hollow_knight", null);
    MIKU_PLUSH_HORNET = registerPlush(consumer, "miku_plush_hornet", null);
    TETO_PLUSH_SYNTHV = registerPlush(consumer, "teto_plush_synthv", null);
    MIKU_PLUSH_WORLD_IS_MINE = registerPlush(consumer, "miku_plush_world_is_mine", null);
    MIKU_PLUSH_ROLLING_GIRL = registerPlush(consumer, "miku_plush_rolling_girl", null);
    TETO_PLUSH_SPOKEN_FOR = registerPlush(consumer, "teto_plush_spoken_for", null);
    MEIKO_PLUSH = registerPlush(consumer, "meiko_plush", null);
    MEIKO_PLUSH_V3 = registerPlush(consumer, "meiko_plush_v3", null);
    MEIKO_PLUSH_V4 = registerPlush(consumer, "meiko_plush_v4", null);
    GUMI_PLUSH = registerPlush(consumer, "gumi_plush", null);
    GUMI_PLUSH_V3 = registerPlush(consumer, "gumi_plush_v3", null);
    GUMI_PLUSH_V4 = registerPlush(consumer, "gumi_plush_v4", null);
    GUMI_PLUSH_V6 = registerPlush(consumer, "gumi_plush_v6", null);
    MIKU_PLUSH_DEEP_SEA_GIRL = registerPlush(consumer, "miku_plush_deep_sea_girl", null);
    MIKU_PLUSH_LUCARIO_Z = registerPlush(consumer, "miku_plush_lucario_z", null);
    TETO_PLUSH_PPPP = registerPlush(consumer, "teto_plush_pppp", null);
    MIKU_PLUSH_PPPP = registerPlush(consumer, "miku_plush_pppp", null);
    TETO_PLUSH_SHRIMP = registerPlush(consumer, "teto_plush_shrimp", null);
    MIKU_PLUSH_LINK = registerPlush(consumer, "miku_plush_link", null);
    MIKU_PLUSH_RENAISSANCE = registerPlush(consumer, "miku_plush_renaissance", null);
    KAITO_PLUSH = registerPlush(consumer, "kaito_plush", null);
    KAITO_PLUSH_V3 = registerPlush(consumer, "kaito_plush_v3", null);
    KAITO_PLUSH_V4 = registerPlush(consumer, "kaito_plush_v4", null);

    LEEK_CROP = register(new LeekCropBlock(BlockBehaviour.Properties.of().noOcclusion().noCollision().randomTicks().instabreak().sound(SoundType.CROP)), "leek_crop", false, consumer);
    WILD_LEEK_CROP = register(new WildLeekCropBlock(BlockBehaviour.Properties.of().noOcclusion().noCollision().randomTicks().instabreak().sound(SoundType.CROP)), "wild_leek_crop", false, consumer);
  }

  //REGISTER PLUSHIES
  public static Block registerPlush(BiConsumer<Block, Identifier> consumer, String name, @Nullable SoundType blockSound) {
    //ADD BLOCK NAMES TO CONSTANTS LIST
    Constants.PLUSH_BLOCK_NAMES.add(name);
    //IF THE BLOCK SOUND IS NULL SET TO WOOL
    SoundType blockSoundGroup = null;
    blockSoundGroup = Objects.requireNonNullElse(blockSound, SoundType.WOOL);
    //REGISTER BLOCK NORMALLY
    return register(new MikuPlushieBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT).sound(blockSoundGroup).noOcclusion()), name, false, consumer);
  }

  //REGISTER REGULAR BLOCKS
  public static Block register(Block block, String name, boolean shouldRegisterItem, BiConsumer<Block, Identifier> consumer) {

    //IF BLOCK IS A PLUSH ADD IT TO THE LIST
    if (block instanceof MikuPlushieBlock) {
      ModBlocks.PLUSH_BLOCKS.add(block);
    } else {
      Constants.OTHER_BLOCK_NAMES.add(name);
    }

    //CREATE IDENTIFIER
    Identifier id = MikuPlushie.id(name);

    //REGISTER ITEM IF REQUESTED
    if (shouldRegisterItem) {
      NEEDS_BLOCK_ITEM.add(new Pair<>(block, id));
    }

    consumer.accept(block, id);

    return block;
  }
}
