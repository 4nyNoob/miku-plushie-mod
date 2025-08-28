package com.any.mikuplushie;

import com.any.mikuplushie.block.*;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModBlocks {

	public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(MikuPlushie.MOD_ID);

	public static final DeferredBlock<MikuPlushieBlock> MIKU_PLUSH_BR = BLOCKS.register("miku_plush_br",
			()->new MikuPlushieBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT).noOcclusion().sound(SoundType.WOOL)));
	public static final DeferredBlock<MikuPlushieBlock> MIKU_PLUSH_BR_BA = BLOCKS.register("miku_plush_br_ba",
			()->new MikuPlushieBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT).noOcclusion().sound(SoundType.WOOL)));
	public static final DeferredBlock<MikuPlushieBlock> MIKU_PLUSH_BIK = BLOCKS.register("miku_plush_bik",
			()->new MikuPlushieBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT).noOcclusion().sound(SoundType.WOOL)));
	public static final DeferredBlock<MikuPlushieBlock> MIKU_PLUSH_BR_BEACH = BLOCKS.register("miku_plush_br_beach",
			()->new MikuPlushieBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT).noOcclusion().sound(SoundType.WOOL)));
	public static final DeferredBlock<MikuPlushieBlock> MIKU_PLUSH_BR_BRAID = BLOCKS.register("miku_plush_br_braid",
			()->new MikuPlushieBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT).noOcclusion().sound(SoundType.WOOL)));
	public static final DeferredBlock<MikuPlushieBlock> MIKU_PLUSH_BR_BA_DRUM = BLOCKS.register("miku_plush_br_ba_drum",
			()->new MikuPlushieBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT).noOcclusion().sound(SoundType.WOOL)));
	public static final DeferredBlock<MikuPlushieBlock> MIKU_PLUSH_BR_PA = BLOCKS.register("miku_plush_br_pa",
			()->new MikuPlushieBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT).noOcclusion().sound(SoundType.WOOL)));
	public static final DeferredBlock<MikuPlushieBlock> MIKU_PLUSH_BR_SP = BLOCKS.register("miku_plush_br_sp",
			()->new MikuPlushieBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT).noOcclusion().sound(SoundType.WOOL)));
	public static final DeferredBlock<MikuPlushieBlock> MIKU_PLUSH_BR_MG = BLOCKS.register("miku_plush_br_mg",
			()->new MikuPlushieBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT).noOcclusion().sound(SoundType.WOOL)));
	public static final DeferredBlock<MikuPlushieBlock> MIKU_PLUSH_BR_BROWN_BRO = BLOCKS.register("miku_plush_br_brown_bro",
			()->new MikuPlushieBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT).noOcclusion().sound(SoundType.WOOL)));
	public static final DeferredBlock<MikuPlushieBlock> MIKU_PLUSH_BR_ELECTRICIAN = BLOCKS.register("miku_plush_br_electrician",
			()->new MikuPlushieBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT).noOcclusion().sound(SoundType.WOOL)));
	public static final DeferredBlock<MikuPlushieBlock> MIKU_PLUSH_BR_BIK_ORANGE = BLOCKS.register("miku_plush_br_bik_orange",
			()->new MikuPlushieBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT).noOcclusion().sound(SoundType.WOOL)));
	public static final DeferredBlock<MikuPlushieBlock> MIKU_PLUSH_BR_AM = BLOCKS.register("miku_plush_br_am",
			()->new MikuPlushieBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT).noOcclusion().sound(SoundType.WOOL)));
	public static final DeferredBlock<MikuPlushieBlock> MIKU_PLUSH_BR_FUT_FLA = BLOCKS.register("miku_plush_br_fut_fla",
			()->new MikuPlushieBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT).noOcclusion().sound(SoundType.WOOL)));
	public static final DeferredBlock<MikuPlushieBlock> MIKU_PLUSH_BR_FUT_CAM = BLOCKS.register("miku_plush_br_fut_cam",
			()->new MikuPlushieBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT).noOcclusion().sound(SoundType.WOOL)));
	public static final DeferredBlock<MikuPlushieBlock> MIKU_PLUSH_BR_GO = BLOCKS.register("miku_plush_br_go",
			()->new MikuPlushieBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT).noOcclusion().sound(SoundType.WOOL)));
	public static final DeferredBlock<MikuPlushieBlock> MIKU_PLUSH_BR_SCHOOL_PE = BLOCKS.register("miku_plush_br_school_pe",
			()->new MikuPlushieBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT).noOcclusion().sound(SoundType.WOOL)));
	public static final DeferredBlock<MikuPlushieBlock> MIKU_PLUSH_BR_FUT_CRVG = BLOCKS.register("miku_plush_br_fut_crvg",
			()->new MikuPlushieBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT).noOcclusion().sound(SoundType.WOOL)));
	public static final DeferredBlock<MikuPlushieBlock> MIKU_PLUSH_BR_RS = BLOCKS.register("miku_plush_br_rs",
			()->new MikuPlushieBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT).noOcclusion().sound(SoundType.WOOL)));
	public static final DeferredBlock<MikuPlushieBlock> MIKU_PLUSH_FROG = BLOCKS.register("miku_plush_frog",
			()->new MikuPlushieBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT).noOcclusion().sound(SoundType.WOOL)));
	public static final DeferredBlock<MikuPlushieBlock> MIKU_PLUSH_MUSHROOM = BLOCKS.register("miku_plush_mushroom",
			()->new MikuPlushieBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT).noOcclusion().sound(SoundType.WOOL)));
	public static final DeferredBlock<MikuPlushieBlock> MIKU_PLUSH_SENBONZAKURA = BLOCKS.register("miku_plush_senbonzakura",
			()->new MikuPlushieBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT).noOcclusion().sound(SoundType.WOOL)));
	public static final DeferredBlock<MikuPlushieBlock> MIKU_PLUSH_URAOTOMELOVERS = BLOCKS.register("miku_plush_uraotomelovers",
			()->new MikuPlushieBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT).noOcclusion().sound(SoundType.WOOL)));
	public static final DeferredBlock<MikuPlushieBlock> MIKU_PLUSH_PERSONADANCING = BLOCKS.register("miku_plush_personadancing",
			()->new MikuPlushieBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT).noOcclusion().sound(SoundType.WOOL)));
	public static final DeferredBlock<MikuPlushieBlock> MIKU_PLUSH_HELLOPLANET = BLOCKS.register("miku_plush_helloplanet",
			()->new MikuPlushieBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT).noOcclusion().sound(SoundType.WOOL)));
	public static final DeferredBlock<MikuPlushieBlock> MIKU_PLUSH_HACHUNE = BLOCKS.register("miku_plush_hachune",
			()->new MikuPlushieBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT).noOcclusion().sound(SoundType.WOOL)));
	public static final DeferredBlock<MikuPlushieBlock> MIKU_PLUSH_ZATSUNE = BLOCKS.register("miku_plush_zatsune",
			()->new MikuPlushieBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT).noOcclusion().sound(SoundType.WOOL)));
	public static final DeferredBlock<MikuPlushieBlock> MIKU_PLUSH_INFINITY = BLOCKS.register("miku_plush_infinity",
			()->new MikuPlushieBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT).noOcclusion().sound(SoundType.WOOL)));
	public static final DeferredBlock<MikuPlushieBlock> MIKU_PLUSH_VAMPIRE = BLOCKS.register("miku_plush_vampire",
			()->new MikuPlushieBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT).noOcclusion().sound(SoundType.WOOL)));
	public static final DeferredBlock<MikuPlushieBlock> MIKU_PLUSH_WEREWOMAN = BLOCKS.register("miku_plush_werewoman",
			()->new MikuPlushieBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT).noOcclusion().sound(SoundType.WOOL)));
	public static final DeferredBlock<MikuPlushieBlock> MIKU_PLUSH_JASON = BLOCKS.register("miku_plush_jason",
			()->new MikuPlushieBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT).noOcclusion().sound(SoundType.WOOL)));
	public static final DeferredBlock<MikuPlushieBlock> MIKU_PLUSH_MICHAEL_MYERS = BLOCKS.register("miku_plush_michael_myers",
			()->new MikuPlushieBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT).noOcclusion().sound(SoundType.WOOL)));
	public static final DeferredBlock<MikuPlushieBlock> MIKU_PLUSH_PUMPKIN = BLOCKS.register("miku_plush_pumpkin",
			()->new MikuPlushieBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT).noOcclusion().sound(SoundType.WOOL)));
	public static final DeferredBlock<MikuPlushieBlock> MIKU_PLUSH_GHOSTFACE = BLOCKS.register("miku_plush_ghostface",
			()->new MikuPlushieBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT).noOcclusion().sound(SoundType.WOOL)));
	public static final DeferredBlock<MikuPlushieBlock> MIKU_PLUSH_FRANKENSTEIN = BLOCKS.register("miku_plush_frankenstein",
			()->new MikuPlushieBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT).noOcclusion().sound(SoundType.WOOL)));
	public static final DeferredBlock<MikuPlushieBlock> MIKU_PLUSH_MUMMY = BLOCKS.register("miku_plush_mummy",
			()->new MikuPlushieBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT).noOcclusion().sound(SoundType.WOOL)));
	public static final DeferredBlock<MikuPlushieBlock> MIKU_PLUSH_GHOST = BLOCKS.register("miku_plush_ghost",
			()->new MikuPlushieBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT).noOcclusion().sound(SoundType.WOOL)));
	public static final DeferredBlock<MikuPlushieBlock> MIKU_PLUSH_PATATI = BLOCKS.register("miku_plush_patati",
			()->new MikuPlushieBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT).noOcclusion().sound(SoundType.WOOL)));
	public static final DeferredBlock<MikuPlushieBlock> MIKU_PLUSH_PATATA = BLOCKS.register("miku_plush_patata",
			()->new MikuPlushieBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT).noOcclusion().sound(SoundType.WOOL)));
	public static final DeferredBlock<MikuPlushieBlock> MIKU_PLUSH_DEVIL = BLOCKS.register("miku_plush_devil",
			()->new MikuPlushieBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT).noOcclusion().sound(SoundType.WOOL)));
	public static final DeferredBlock<MikuPlushieBlock> MIKU_PLUSH_WITCH = BLOCKS.register("miku_plush_witch",
			()->new MikuPlushieBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT).noOcclusion().sound(SoundType.WOOL)));
	public static final DeferredBlock<MikuPlushieBlock> MIKU_PLUSH_SANTA = BLOCKS.register("miku_plush_santa",
			()->new MikuPlushieBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT).noOcclusion().sound(SoundType.WOOL)));
	public static final DeferredBlock<MikuPlushieBlock> MIKU_PLUSH_REINDEER = BLOCKS.register("miku_plush_reindeer",
			()->new MikuPlushieBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT).noOcclusion().sound(SoundType.WOOL)));
	public static final DeferredBlock<MikuPlushieBlock> MIKU_PLUSH_SANTA_ELF = BLOCKS.register("miku_plush_santa_elf",
			()->new MikuPlushieBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT).noOcclusion().sound(SoundType.WOOL)));
	public static final DeferredBlock<MikuPlushieBlock> MIKU_PLUSH_XMAS_TREE = BLOCKS.register("miku_plush_xmas_tree",
			()->new MikuPlushieBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT).noOcclusion().sound(SoundType.WOOL)));
	public static final DeferredBlock<AikoPlushieBlock> AIKO_PLUSH = BLOCKS.register("aiko_plush",
			()->new AikoPlushieBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT).noOcclusion().sound(SoundType.WOOL)));
	public static final DeferredBlock<TetoPlushieBlock> TETO_PLUSH = BLOCKS.register("teto_plush",
			()->new TetoPlushieBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT).noOcclusion().sound(SoundType.WOOL)));
	public static final DeferredBlock<NeruPlushieBlock> AKITA_NERU_PLUSH = BLOCKS.register("akita_neru_plush",
			()->new NeruPlushieBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT).noOcclusion().sound(SoundType.WOOL)));
	public static final DeferredBlock<MikuPlushieBlock> MIKU_PLUSH = BLOCKS.register("miku_plush",
			()->new MikuPlushieBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT).noOcclusion().sound(SoundType.WOOL)));
	public static final DeferredBlock<RinPlushieBlock> RIN_PLUSH = BLOCKS.register("rin_plush",
			()->new RinPlushieBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT).noOcclusion().sound(SoundType.WOOL)));
	public static final DeferredBlock<LenPlushieBlock> LEN_PLUSH = BLOCKS.register("len_plush",
			()->new LenPlushieBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT).noOcclusion().sound(SoundType.WOOL)));
	public static final DeferredBlock<MikuPlushieBlock> MIKU_PLUSH_SONIC_CROSSWORLDS = BLOCKS.register("miku_plush_sonic_crossworlds",
			()->new MikuPlushieBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT).noOcclusion().sound(SoundType.WOOL)));
	public static final DeferredBlock<MikuPlushieBlock> MIKU_PLUSH_FORTNITE_NEKO = BLOCKS.register("miku_plush_fortnite_neko",
			()->new MikuPlushieBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT).noOcclusion().sound(SoundType.WOOL)));
	public static final DeferredBlock<MikuPlushieBlock> MIKU_PLUSH_V4 = BLOCKS.register("miku_plush_v4",
			()->new MikuPlushieBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT).noOcclusion().sound(SoundType.WOOL)));
	public static final DeferredBlock<MikuPlushieBlock> MIKU_PLUSH_MESMERIZER = BLOCKS.register("miku_plush_mesmerizer",
			()->new MikuPlushieBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT).noOcclusion().sound(SoundType.WOOL)));
	public static final DeferredBlock<TetoPlushieBlock> TETO_PLUSH_MESMERIZER = BLOCKS.register("teto_plush_mesmerizer",
			()->new TetoPlushieBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT).noOcclusion().sound(SoundType.WOOL)));
	public static final DeferredBlock<MikuPlushieBlock> MIKU_PLUSH_SONIC = BLOCKS.register("miku_plush_sonic",
			()->new MikuPlushieBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT).noOcclusion().sound(SoundType.WOOL)));
	public static final DeferredBlock<TetoPlushieBlock> TETO_PLUSH_SHADOW = BLOCKS.register("teto_plush_shadow",
			()->new TetoPlushieBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT).noOcclusion().sound(SoundType.WOOL)));
	public static final DeferredBlock<MikuPlushieBlock> AKITA_NERU_PLUSH_TAILS = BLOCKS.register("akita_neru_plush_tails",
			()->new MikuPlushieBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT).noOcclusion().sound(SoundType.WOOL)));
	public static final DeferredBlock<TetoPlushieBlock> TETO_PLUSH_BIRDBRAIN = BLOCKS.register("teto_plush_birdbrain",
			()->new TetoPlushieBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT).noOcclusion().sound(SoundType.WOOL)));
	public static final DeferredBlock<MikuPlushieBlock> MIKU_PLUSH_DIGITAL_STARS_2025 = BLOCKS.register("miku_plush_digital_stars_2025",
			()->new MikuPlushieBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT).noOcclusion().sound(SoundType.WOOL)));
	public static final DeferredBlock<MikuPlushieBlock> MIKU_PLUSH_ROTTEN_GIRL = BLOCKS.register("miku_plush_rotten_girl",
			()->new MikuPlushieBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT).noOcclusion().sound(SoundType.WOOL)));
	public static final DeferredBlock<TetoPlushieBlock> TETO_PLUSH_REGRET_ROCK = BLOCKS.register("teto_plush_regret_rock",
			()->new TetoPlushieBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT).noOcclusion().sound(SoundType.WOOL)));
	public static final DeferredBlock<MikuPlushieBlock> MIKU_PLUSH_PSYCHO_MODE = BLOCKS.register("miku_plush_psycho_mode",
			()->new MikuPlushieBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT).noOcclusion().sound(SoundType.WOOL)));
	public static final DeferredBlock<MikuPlushieBlock> MIKU_PLUSH_DONT_BELIEVE_IN_T = BLOCKS.register("miku_plush_dont_believe_in_t",
			()->new MikuPlushieBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT).noOcclusion().sound(SoundType.WOOL)));
	public static final DeferredBlock<TetoPlushieBlock> TETO_PLUSH_DONT_BELIEVE_IN_T = BLOCKS.register("teto_plush_dont_believe_in_t",
			()->new TetoPlushieBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT).noOcclusion().sound(SoundType.WOOL)));
	public static final DeferredBlock<TetoPlushieBlock> TETO_PLUSH_LIAR_DANCER = BLOCKS.register("teto_plush_liar_dancer",
			()->new TetoPlushieBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT).noOcclusion().sound(SoundType.WOOL)));
	public static final DeferredBlock<MikuPlushieBlock> MIKU_PLUSH_STATIC = BLOCKS.register("miku_plush_static",
			()->new MikuPlushieBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT).noOcclusion().sound(SoundType.WOOL)));
	public static final DeferredBlock<MikuPlushieBlock> MIKU_PLUSH_MOCHIMOCHI = BLOCKS.register("miku_plush_mochimochi",
			()->new MikuPlushieBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT).noOcclusion().sound(SoundType.WOOL)));
	public static final DeferredBlock<TetoPlushieBlock> TETO_PLUSH_WHATCHACALLITSNAME = BLOCKS.register("teto_plush_whatchacallitsname",
			()->new TetoPlushieBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT).noOcclusion().sound(SoundType.WOOL)));
	public static final DeferredBlock<MikuPlushieBlock> MIKU_PLUSH_MONITORING = BLOCKS.register("miku_plush_monitoring",
			()->new MikuPlushieBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT).noOcclusion().sound(SoundType.WOOL)));
    public static final DeferredBlock<MikuPlushieBlock> KONOHA_PLUSH = BLOCKS.register("konoha_plush",
            ()->new MikuPlushieBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT).noOcclusion().sound(SoundType.WOOL)));
    public static final DeferredBlock<LukaPlushieBlock> LUKA_PLUSH = BLOCKS.register("luka_plush",
            ()->new LukaPlushieBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT).noOcclusion().sound(SoundType.WOOL)));


}
