package com.any.mikuplushie.registry;

import com.any.mikuplushie.MikuPlushie;
import com.any.mikuplushie.block.LeekCropBlock;
import com.any.mikuplushie.block.MikuPlushieBlock;
import com.any.mikuplushie.block.WildLeekCropBlock;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ModBlocks {

    public static List<Block> PLUSH_BLOCKS = new ArrayList<>();

	public static final Block MIKU_PLUSH_BR = registerPlush("miku_plush_br", null);
	public static final Block MIKU_PLUSH_BR_BA = registerPlush("miku_plush_br_ba", null);
	public static final Block MIKU_PLUSH_BIK = registerPlush("miku_plush_bik", null);
	public static final Block MIKU_PLUSH_BR_BEACH = registerPlush("miku_plush_br_beach", null);
	public static final Block MIKU_PLUSH_BR_BRAID = registerPlush("miku_plush_br_braid", null);
	public static final Block MIKU_PLUSH_BR_BA_DRUM = registerPlush("miku_plush_br_ba_drum", null);
	public static final Block MIKU_PLUSH_BR_PA = registerPlush("miku_plush_br_pa", null);
	public static final Block MIKU_PLUSH_BR_SP = registerPlush("miku_plush_br_sp", null);
	public static final Block MIKU_PLUSH_BR_MG = registerPlush("miku_plush_br_mg", null);
	public static final Block MIKU_PLUSH_BR_BROWN_BRO = registerPlush("miku_plush_br_brown_bro", null);
	public static final Block MIKU_PLUSH_BR_ELECTRICIAN = registerPlush("miku_plush_br_electrician", null);
	public static final Block MIKU_PLUSH_BR_BIK_ORANGE = registerPlush("miku_plush_br_bik_orange", null);
	public static final Block MIKU_PLUSH_BR_AM = registerPlush("miku_plush_br_am", null);
	public static final Block MIKU_PLUSH_BR_FUT_FLA = registerPlush("miku_plush_br_fut_fla", null);
	public static final Block MIKU_PLUSH_BR_FUT_CAM = registerPlush("miku_plush_br_fut_cam", null);
    public static final Block MIKU_PLUSH_BR_GO = registerPlush("miku_plush_br_go", null);
    public static final Block MIKU_PLUSH_BR_SCHOOL_PE = registerPlush("miku_plush_br_school_pe", null);
	public static final Block MIKU_PLUSH_BR_FUT_CRVG = registerPlush("miku_plush_br_fut_crvg", null);
	public static final Block MIKU_PLUSH_BR_RS = registerPlush("miku_plush_br_rs", null);
	public static final Block MIKU_PLUSH_FROG = registerPlush("miku_plush_frog", null);
	public static final Block MIKU_PLUSH_MUSHROOM = registerPlush("miku_plush_mushroom", null);
	public static final Block MIKU_PLUSH_SENBONZAKURA = registerPlush("miku_plush_senbonzakura", null);
	public static final Block MIKU_PLUSH_URAOTOMELOVERS = registerPlush("miku_plush_uraotomelovers", null);
	public static final Block MIKU_PLUSH_PERSONADANCING = registerPlush("miku_plush_personadancing", null);
	public static final Block MIKU_PLUSH_HELLOPLANET = registerPlush("miku_plush_helloplanet", null);
	public static final Block MIKU_PLUSH_HACHUNE = registerPlush("miku_plush_hachune", null);
	public static final Block MIKU_PLUSH_ZATSUNE = registerPlush("miku_plush_zatsune", null);
	public static final Block MIKU_PLUSH_INFINITY = registerPlush("miku_plush_infinity", null);
	public static final Block MIKU_PLUSH_VAMPIRE = registerPlush("miku_plush_vampire", null);
	public static final Block MIKU_PLUSH_WEREWOMAN = registerPlush("miku_plush_werewoman", null);
	public static final Block MIKU_PLUSH_JASON = registerPlush("miku_plush_jason", null);
	public static final Block MIKU_PLUSH_MICHAEL_MYERS = registerPlush("miku_plush_michael_myers", null);
	public static final Block MIKU_PLUSH_PUMPKIN = registerPlush("miku_plush_pumpkin", null);
	public static final Block MIKU_PLUSH_GHOSTFACE = registerPlush("miku_plush_ghostface", null);
	public static final Block MIKU_PLUSH_FRANKENSTEIN = registerPlush("miku_plush_frankenstein", null);
	public static final Block MIKU_PLUSH_MUMMY = registerPlush("miku_plush_mummy", null);
	public static final Block MIKU_PLUSH_GHOST = registerPlush("miku_plush_ghost", BlockSoundGroup.GLASS);
	public static final Block MIKU_PLUSH_PATATI = registerPlush("miku_plush_patati", null);
	public static final Block MIKU_PLUSH_PATATA = registerPlush("miku_plush_patata", null);
	public static final Block MIKU_PLUSH_DEVIL = registerPlush("miku_plush_devil", null);
	public static final Block MIKU_PLUSH_WITCH = registerPlush("miku_plush_witch", null);
	public static final Block MIKU_PLUSH_SANTA = registerPlush("miku_plush_santa", null);
	public static final Block MIKU_PLUSH_REINDEER = registerPlush("miku_plush_reindeer", null);
	public static final Block MIKU_PLUSH_SANTA_ELF = registerPlush("miku_plush_santa_elf", null);
	public static final Block MIKU_PLUSH_XMAS_TREE = registerPlush("miku_plush_xmas_tree", null);
	public static final Block AIKO_PLUSH = registerPlush("aiko_plush", null);
	public static final Block TETO_PLUSH = registerPlush("teto_plush", null);
	public static final Block AKITA_NERU_PLUSH = registerPlush("akita_neru_plush", null);
	public static final Block MIKU_PLUSH = registerPlush("miku_plush", null);
	public static final Block RIN_PLUSH = registerPlush("rin_plush", null);
	public static final Block LEN_PLUSH = registerPlush("len_plush", null);
	public static final Block MIKU_PLUSH_SONIC_CROSSWORLDS = registerPlush("miku_plush_sonic_crossworlds", null);
	public static final Block MIKU_PLUSH_FORTNITE_NEKO = registerPlush("miku_plush_fortnite_neko", null);
	public static final Block MIKU_PLUSH_V4 = registerPlush("miku_plush_v4", null);
	public static final Block MIKU_PLUSH_MESMERIZER = registerPlush("miku_plush_mesmerizer", null);
	public static final Block TETO_PLUSH_MESMERIZER = registerPlush("teto_plush_mesmerizer", null);
	public static final Block MIKU_PLUSH_SONIC = registerPlush("miku_plush_sonic", null);
	public static final Block TETO_PLUSH_SHADOW = registerPlush("teto_plush_shadow", null);
	public static final Block AKITA_NERU_PLUSH_TAILS = registerPlush("akita_neru_plush_tails", null);
	public static final Block TETO_PLUSH_BIRDBRAIN = registerPlush("teto_plush_birdbrain", null);
	public static final Block MIKU_PLUSH_DIGITAL_STARS_2025 = registerPlush("miku_plush_digital_stars_2025", null);
	public static final Block MIKU_PLUSH_ROTTEN_GIRL = registerPlush("miku_plush_rotten_girl", null);
	public static final Block TETO_PLUSH_REGRET_ROCK = registerPlush("teto_plush_regret_rock", null);
	public static final Block MIKU_PLUSH_PSYCHO_MODE = registerPlush("miku_plush_psycho_mode", null);
	public static final Block MIKU_PLUSH_DONT_BELIEVE_IN_T = registerPlush("miku_plush_dont_believe_in_t", null);
	public static final Block TETO_PLUSH_DONT_BELIEVE_IN_T = registerPlush("teto_plush_dont_believe_in_t", null);
	public static final Block TETO_PLUSH_LIAR_DANCER = registerPlush("teto_plush_liar_dancer", null);
	public static final Block MIKU_PLUSH_STATIC = registerPlush("miku_plush_static", null);
	public static final Block MIKU_PLUSH_MOCHIMOCHI = registerPlush("miku_plush_mochimochi", null);
	public static final Block TETO_PLUSH_WHATCHACALLITSNAME = registerPlush("teto_plush_whatchacallitsname", null);
	public static final Block MIKU_PLUSH_MONITORING = registerPlush("miku_plush_monitoring", null);
	public static final Block KONOHA_PLUSH = registerPlush("konoha_plush", null);
	public static final Block LUKA_PLUSH = registerPlush("luka_plush", null);
    public static final Block TETO_PLUSH_SOME_MORE_OF_THAT_SONG = registerPlush("teto_plush_some_more_of_that_song", null);
    public static final Block TETO_PLUSH_LOBSTER = registerPlush("teto_plush_lobster", null);
    public static final Block MIKU_PLUSH_HOLLOW_KNIGHT = registerPlush("miku_plush_hollow_knight", null);
    public static final Block MIKU_PLUSH_HORNET = registerPlush("miku_plush_hornet", null);
    public static final Block TETO_PLUSH_SYNTHV = registerPlush("teto_plush_synthv", null);
    public static final Block MIKU_PLUSH_WORLD_IS_MINE = registerPlush("miku_plush_world_is_mine", null);
    public static final Block MIKU_PLUSH_ROLLING_GIRL = registerPlush("miku_plush_rolling_girl", null);
    public static final Block TETO_PLUSH_SPOKEN_FOR = registerPlush("teto_plush_spoken_for", null);
    public static final Block MEIKO_PLUSH = registerPlush("meiko_plush", null);
    public static final Block MEIKO_PLUSH_V3 = registerPlush("meiko_plush_v3", null);
    public static final Block MEIKO_PLUSH_V4 = registerPlush("meiko_plush_v4", null);
    public static final Block GUMI_PLUSH = registerPlush("gumi_plush", null);
    public static final Block GUMI_PLUSH_V3 = registerPlush("gumi_plush_v3", null);
    public static final Block GUMI_PLUSH_V4 = registerPlush("gumi_plush_v4", null);
    public static final Block GUMI_PLUSH_V6 = registerPlush("gumi_plush_v6", null);
    public static final Block MIKU_PLUSH_DEEP_SEA_GIRL = registerPlush("miku_plush_deep_sea_girl", null);
    public static final Block MIKU_PLUSH_LUCARIO_Z = registerPlush("miku_plush_lucario_z", null);

    //NON PLUSH STUFF
    public static final LeekCropBlock LEEK_CROP = (LeekCropBlock) register(
        new LeekCropBlock(AbstractBlock.Settings.create()
            .nonOpaque().noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.CROP)),
        "leek_crop",
        false
    );
    public static final WildLeekCropBlock WILD_LEEK_CROP = (WildLeekCropBlock) register(
        new WildLeekCropBlock(AbstractBlock.Settings.create()
            .nonOpaque().noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.CROP)),
        "wild_leek_crop",
        false
    );

    //REGISTER PLUSHIES
    public static Block registerPlush(String name, @Nullable BlockSoundGroup blockSound) {
        //IF THE BLOCK SOUND IS NULL SET TO WOOL
        BlockSoundGroup blockSoundGroup = null;
        blockSoundGroup = Objects.requireNonNullElse(blockSound, BlockSoundGroup.WOOL);
        //REGISTER BLOCK NORMALLY
        return register(
            new MikuPlushieBlock(AbstractBlock.Settings.copy(Blocks.FLOWER_POT)
                .sounds(blockSoundGroup).nonOpaque()), name, false);
    }

    //REGISTER REGULAR BLOCKS
	public static Block register(Block block, String name, boolean shouldRegisterItem) {
        //CREATE IDENTIFIER
        Identifier id = Identifier.of(MikuPlushie.MOD_ID, name);

        //REGISTER ITEM IF REQUESTED
        if (shouldRegisterItem) {
            BlockItem blockItem = new BlockItem(block, new Item.Settings());
            Registry.register(Registries.ITEM, id, blockItem);
        }

        Block blockRegister = Registry.register(Registries.BLOCK, id, block);

        //IF BLOCK IS A PLUSH ADD IT TO THE LIST
        if (block instanceof MikuPlushieBlock){
            PLUSH_BLOCKS.add(block);
        }

        return blockRegister;
	}

	public static void initialize() {
        MikuPlushie.LOGGER.info("Registering " + MikuPlushie.MOD_ID + " Blocks");
    }
}
