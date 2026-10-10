package com.any.miku_plushie.registry;

import com.any.miku_plushie.Constants;
import com.any.miku_plushie.MikuPlushieFabric;
import com.any.miku_plushie.block.LeekCropBlock;
import com.any.miku_plushie.block.MikuPlushieBlock;
import com.any.miku_plushie.block.WildLeekCropBlock;
import java.util.ArrayList;
import java.util.List;
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

public class ModBlocks {

  public static List<Block> PLUSH_BLOCKS = new ArrayList<>();

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

  public static LeekCropBlock LEEK_CROP;
  public static WildLeekCropBlock WILD_LEEK_CROP;

  public static void initialize() {

    MikuPlushieFabric.LOGGER.info("Registering " + Constants.MOD_ID + " Blocks");

    MIKU_PLUSH_BR = registerPlush("miku_plush_br", null);
    MIKU_PLUSH_BR_BA = registerPlush("miku_plush_br_ba", null);
    MIKU_PLUSH_BIK = registerPlush("miku_plush_bik", null);
    MIKU_PLUSH_BR_BEACH = registerPlush("miku_plush_br_beach", null);
    MIKU_PLUSH_BR_BRAID = registerPlush("miku_plush_br_braid", null);
    MIKU_PLUSH_BR_BA_DRUM = registerPlush("miku_plush_br_ba_drum", null);
    MIKU_PLUSH_BR_PA = registerPlush("miku_plush_br_pa", null);
    MIKU_PLUSH_BR_SP = registerPlush("miku_plush_br_sp", null);
    MIKU_PLUSH_BR_MG = registerPlush("miku_plush_br_mg", null);
    MIKU_PLUSH_BR_BROWN_BRO = registerPlush("miku_plush_br_brown_bro", null);
    MIKU_PLUSH_BR_ELECTRICIAN = registerPlush("miku_plush_br_electrician", null);
    MIKU_PLUSH_BR_BIK_ORANGE = registerPlush("miku_plush_br_bik_orange", null);
    MIKU_PLUSH_BR_AM = registerPlush("miku_plush_br_am", null);
    MIKU_PLUSH_BR_FUT_FLA = registerPlush("miku_plush_br_fut_fla", null);
    MIKU_PLUSH_BR_FUT_CAM = registerPlush("miku_plush_br_fut_cam", null);
    MIKU_PLUSH_BR_GO = registerPlush("miku_plush_br_go", null);
    MIKU_PLUSH_BR_SCHOOL_PE = registerPlush("miku_plush_br_school_pe", null);
    MIKU_PLUSH_BR_FUT_CRVG = registerPlush("miku_plush_br_fut_crvg", null);
    MIKU_PLUSH_BR_RS = registerPlush("miku_plush_br_rs", null);
    MIKU_PLUSH_FROG = registerPlush("miku_plush_frog", null);
    MIKU_PLUSH_MUSHROOM = registerPlush("miku_plush_mushroom", null);
    MIKU_PLUSH_SENBONZAKURA = registerPlush("miku_plush_senbonzakura", null);
    MIKU_PLUSH_URAOTOMELOVERS = registerPlush("miku_plush_uraotomelovers", null);
    MIKU_PLUSH_PERSONADANCING = registerPlush("miku_plush_personadancing", null);
    MIKU_PLUSH_HELLOPLANET = registerPlush("miku_plush_helloplanet", null);
    MIKU_PLUSH_HACHUNE = registerPlush("miku_plush_hachune", null);
    MIKU_PLUSH_ZATSUNE = registerPlush("miku_plush_zatsune", null);
    MIKU_PLUSH_INFINITY = registerPlush("miku_plush_infinity", null);
    MIKU_PLUSH_VAMPIRE = registerPlush("miku_plush_vampire", null);
    MIKU_PLUSH_WEREWOMAN = registerPlush("miku_plush_werewoman", null);
    MIKU_PLUSH_JASON = registerPlush("miku_plush_jason", null);
    MIKU_PLUSH_MICHAEL_MYERS = registerPlush("miku_plush_michael_myers", null);
    MIKU_PLUSH_PUMPKIN = registerPlush("miku_plush_pumpkin", null);
    MIKU_PLUSH_GHOSTFACE = registerPlush("miku_plush_ghostface", null);
    MIKU_PLUSH_FRANKENSTEIN = registerPlush("miku_plush_frankenstein", null);
    MIKU_PLUSH_MUMMY = registerPlush("miku_plush_mummy", null);
    MIKU_PLUSH_GHOST = registerPlush("miku_plush_ghost", SoundType.GLASS);
    MIKU_PLUSH_PATATI = registerPlush("miku_plush_patati", null);
    MIKU_PLUSH_PATATA = registerPlush("miku_plush_patata", null);
    MIKU_PLUSH_DEVIL = registerPlush("miku_plush_devil", null);
    MIKU_PLUSH_WITCH = registerPlush("miku_plush_witch", null);
    MIKU_PLUSH_SANTA = registerPlush("miku_plush_santa", null);
    MIKU_PLUSH_REINDEER = registerPlush("miku_plush_reindeer", null);
    MIKU_PLUSH_SANTA_ELF = registerPlush("miku_plush_santa_elf", null);
    MIKU_PLUSH_XMAS_TREE = registerPlush("miku_plush_xmas_tree", null);
    AIKO_PLUSH = registerPlush("aiko_plush", null);
    TETO_PLUSH = registerPlush("teto_plush", null);
    AKITA_NERU_PLUSH = registerPlush("akita_neru_plush", null);
    MIKU_PLUSH = registerPlush("miku_plush", null);
    RIN_PLUSH = registerPlush("rin_plush", null);
    LEN_PLUSH = registerPlush("len_plush", null);
    MIKU_PLUSH_SONIC_CROSSWORLDS = registerPlush("miku_plush_sonic_crossworlds", null);
    MIKU_PLUSH_FORTNITE_NEKO = registerPlush("miku_plush_fortnite_neko", null);
    MIKU_PLUSH_V4 = registerPlush("miku_plush_v4", null);
    MIKU_PLUSH_MESMERIZER = registerPlush("miku_plush_mesmerizer", null);
    TETO_PLUSH_MESMERIZER = registerPlush("teto_plush_mesmerizer", null);
    MIKU_PLUSH_SONIC = registerPlush("miku_plush_sonic", null);
    TETO_PLUSH_SHADOW = registerPlush("teto_plush_shadow", null);
    AKITA_NERU_PLUSH_TAILS = registerPlush("akita_neru_plush_tails", null);
    TETO_PLUSH_BIRDBRAIN = registerPlush("teto_plush_birdbrain", null);
    MIKU_PLUSH_DIGITAL_STARS_2025 = registerPlush("miku_plush_digital_stars_2025", null);
    MIKU_PLUSH_ROTTEN_GIRL = registerPlush("miku_plush_rotten_girl", null);
    TETO_PLUSH_REGRET_ROCK = registerPlush("teto_plush_regret_rock", null);
    MIKU_PLUSH_PSYCHO_MODE = registerPlush("miku_plush_psycho_mode", null);
    MIKU_PLUSH_DONT_BELIEVE_IN_T = registerPlush("miku_plush_dont_believe_in_t", null);
    TETO_PLUSH_DONT_BELIEVE_IN_T = registerPlush("teto_plush_dont_believe_in_t", null);
    TETO_PLUSH_LIAR_DANCER = registerPlush("teto_plush_liar_dancer", null);
    MIKU_PLUSH_STATIC = registerPlush("miku_plush_static", null);
    MIKU_PLUSH_MOCHIMOCHI = registerPlush("miku_plush_mochimochi", null);
    TETO_PLUSH_WHATCHACALLITSNAME = registerPlush("teto_plush_whatchacallitsname", null);
    MIKU_PLUSH_MONITORING = registerPlush("miku_plush_monitoring", null);
    KONOHA_PLUSH = registerPlush("konoha_plush", null);
    LUKA_PLUSH = registerPlush("luka_plush", null);
    TETO_PLUSH_SOME_MORE_OF_THAT_SONG = registerPlush("teto_plush_some_more_of_that_song", null);
    TETO_PLUSH_LOBSTER = registerPlush("teto_plush_lobster", null);
    MIKU_PLUSH_HOLLOW_KNIGHT = registerPlush("miku_plush_hollow_knight", null);
    MIKU_PLUSH_HORNET = registerPlush("miku_plush_hornet", null);
    TETO_PLUSH_SYNTHV = registerPlush("teto_plush_synthv", null);
    MIKU_PLUSH_WORLD_IS_MINE = registerPlush("miku_plush_world_is_mine", null);
    MIKU_PLUSH_ROLLING_GIRL = registerPlush("miku_plush_rolling_girl", null);
    TETO_PLUSH_SPOKEN_FOR = registerPlush("teto_plush_spoken_for", null);
    MEIKO_PLUSH = registerPlush("meiko_plush", null);
    MEIKO_PLUSH_V3 = registerPlush("meiko_plush_v3", null);
    MEIKO_PLUSH_V4 = registerPlush("meiko_plush_v4", null);
    GUMI_PLUSH = registerPlush("gumi_plush", null);
    GUMI_PLUSH_V3 = registerPlush("gumi_plush_v3", null);
    GUMI_PLUSH_V4 = registerPlush("gumi_plush_v4", null);
    GUMI_PLUSH_V6 = registerPlush("gumi_plush_v6", null);
    MIKU_PLUSH_DEEP_SEA_GIRL = registerPlush("miku_plush_deep_sea_girl", null);
    MIKU_PLUSH_LUCARIO_Z = registerPlush("miku_plush_lucario_z", null);
    TETO_PLUSH_PPPP = registerPlush("teto_plush_pppp", null);
    MIKU_PLUSH_PPPP = registerPlush("miku_plush_pppp", null);
    TETO_PLUSH_SHRIMP = registerPlush("teto_plush_shrimp", null);
    MIKU_PLUSH_LINK = registerPlush("miku_plush_link", null);
    MIKU_PLUSH_RENAISSANCE = registerPlush("miku_plush_renaissance", null);
    KAITO_PLUSH = registerPlush("kaito_plush", null);
    KAITO_PLUSH_V3 = registerPlush("kaito_plush_v3", null);
    KAITO_PLUSH_V4 = registerPlush("kaito_plush_v4", null);

    LEEK_CROP = (LeekCropBlock) register(
        new LeekCropBlock(BlockBehaviour.Properties.of()
            .noOcclusion().noCollission().randomTicks().instabreak().sound(SoundType.CROP)),
        "leek_crop",
        false
    );
    WILD_LEEK_CROP = (WildLeekCropBlock) register(
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
      PLUSH_BLOCKS.add(block);
    }

    return blockRegister;
  }
}
