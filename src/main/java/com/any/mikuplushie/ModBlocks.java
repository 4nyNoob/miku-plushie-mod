package com.any.mikuplushie;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;

import com.any.mikuplushie.block.MikuPlushieBlock;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModBlocks {

	public static final DeferredRegister.Blocks BLOCKS=DeferredRegister.createBlocks(MikuPlushie.MOD_ID);

	public static final DeferredBlock<MikuPlushieBlock> MIKU_PLUSH_BR=BLOCKS.register("miku_plush_br",
			()->new MikuPlushieBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT).noOcclusion().sound(SoundType.WOOL)));
	public static final DeferredBlock<MikuPlushieBlock> MIKU_PLUSH_BR_BA=BLOCKS.register("miku_plush_br_ba",
			()->new MikuPlushieBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT).noOcclusion().sound(SoundType.WOOL)));
	public static final DeferredBlock<MikuPlushieBlock> MIKU_PLUSH_BIK=BLOCKS.register("miku_plush_bik",
			()->new MikuPlushieBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT).noOcclusion().sound(SoundType.WOOL)));
	public static final DeferredBlock<MikuPlushieBlock> MIKU_PLUSH_BR_BEACH=BLOCKS.register("miku_plush_br_beach",
			()->new MikuPlushieBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT).noOcclusion().sound(SoundType.WOOL)));
	public static final DeferredBlock<MikuPlushieBlock> MIKU_PLUSH_BR_BRAID=BLOCKS.register("miku_plush_br_braid",
			()->new MikuPlushieBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT).noOcclusion().sound(SoundType.WOOL)));
	public static final DeferredBlock<MikuPlushieBlock> MIKU_PLUSH_BR_BA_DRUM=BLOCKS.register("miku_plush_br_ba_drum",
			()->new MikuPlushieBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT).noOcclusion().sound(SoundType.WOOL)));
	public static final DeferredBlock<MikuPlushieBlock> MIKU_PLUSH_BR_PA=BLOCKS.register("miku_plush_br_pa",
			()->new MikuPlushieBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT).noOcclusion().sound(SoundType.WOOL)));
	public static final DeferredBlock<MikuPlushieBlock> MIKU_PLUSH_BR_SP=BLOCKS.register("miku_plush_br_sp",
			()->new MikuPlushieBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT).noOcclusion().sound(SoundType.WOOL)));
	public static final DeferredBlock<MikuPlushieBlock> MIKU_PLUSH_BR_MG=BLOCKS.register("miku_plush_br_mg",
			()->new MikuPlushieBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT).noOcclusion().sound(SoundType.WOOL)));
	public static final DeferredBlock<MikuPlushieBlock> MIKU_PLUSH_BR_BROWN_BRO=BLOCKS.register("miku_plush_br_brown_bro",
			()->new MikuPlushieBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT).noOcclusion().sound(SoundType.WOOL)));
	public static final DeferredBlock<MikuPlushieBlock> MIKU_PLUSH_BR_ELECTRICIAN=BLOCKS.register("miku_plush_br_electrician",
			()->new MikuPlushieBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT).noOcclusion().sound(SoundType.WOOL)));
	public static final DeferredBlock<MikuPlushieBlock> MIKU_PLUSH_BR_BIK_ORANGE=BLOCKS.register("miku_plush_br_bik_orange",
			()->new MikuPlushieBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT).noOcclusion().sound(SoundType.WOOL)));
	public static final DeferredBlock<MikuPlushieBlock> MIKU_PLUSH_BR_AM=BLOCKS.register("miku_plush_br_am",
			()->new MikuPlushieBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT).noOcclusion().sound(SoundType.WOOL)));
	public static final DeferredBlock<MikuPlushieBlock> MIKU_PLUSH_BR_FUT_FLA=BLOCKS.register("miku_plush_br_fut_fla",
			()->new MikuPlushieBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT).noOcclusion().sound(SoundType.WOOL)));
	public static final DeferredBlock<MikuPlushieBlock> MIKU_PLUSH_BR_FUT_CAM=BLOCKS.register("miku_plush_br_fut_cam",
			()->new MikuPlushieBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT).noOcclusion().sound(SoundType.WOOL)));
	public static final DeferredBlock<MikuPlushieBlock> MIKU_PLUSH_BR_GO=BLOCKS.register("miku_plush_br_go",
			()->new MikuPlushieBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT).noOcclusion().sound(SoundType.WOOL)));
	public static final DeferredBlock<MikuPlushieBlock> MIKU_PLUSH_BR_SCHOOL_PE=BLOCKS.register("miku_plush_br_school_pe",
			()->new MikuPlushieBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT).noOcclusion().sound(SoundType.WOOL)));
	public static final DeferredBlock<MikuPlushieBlock> MIKU_PLUSH_BR_FUT_CRVG=BLOCKS.register("miku_plush_br_fut_crvg",
			()->new MikuPlushieBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT).noOcclusion().sound(SoundType.WOOL)));
	public static final DeferredBlock<MikuPlushieBlock> MIKU_PLUSH_BR_RS=BLOCKS.register("miku_plush_br_rs",
			()->new MikuPlushieBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT).noOcclusion().sound(SoundType.WOOL)));
	public static final DeferredBlock<MikuPlushieBlock> MIKU_PLUSH_FROG=BLOCKS.register("miku_plush_frog",
			()->new MikuPlushieBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT).noOcclusion().sound(SoundType.WOOL)));
	public static final DeferredBlock<MikuPlushieBlock> MIKU_PLUSH_MUSHROOM=BLOCKS.register("miku_plush_mushroom",
			()->new MikuPlushieBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT).noOcclusion().sound(SoundType.WOOL)));
	public static final DeferredBlock<MikuPlushieBlock> MIKU_PLUSH_SENBONZAKURA=BLOCKS.register("miku_plush_senbonzakura",
			()->new MikuPlushieBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT).noOcclusion().sound(SoundType.WOOL)));
	public static final DeferredBlock<MikuPlushieBlock> MIKU_PLUSH_URAOTOMELOVERS=BLOCKS.register("miku_plush_uraotomelovers",
			()->new MikuPlushieBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT).noOcclusion().sound(SoundType.WOOL)));
	public static final DeferredBlock<MikuPlushieBlock> MIKU_PLUSH_PERSONADANCING=BLOCKS.register("miku_plush_personadancing",
			()->new MikuPlushieBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT).noOcclusion().sound(SoundType.WOOL)));
	public static final DeferredBlock<MikuPlushieBlock> MIKU_PLUSH_HELLOPLANET=BLOCKS.register("miku_plush_helloplanet",
			()->new MikuPlushieBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT).noOcclusion().sound(SoundType.WOOL)));
	public static final DeferredBlock<MikuPlushieBlock> MIKU_PLUSH_HACHUNE=BLOCKS.register("miku_plush_hachune",
			()->new MikuPlushieBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT).noOcclusion().sound(SoundType.WOOL)));
	public static final DeferredBlock<MikuPlushieBlock> MIKU_PLUSH_ZATSUNE=BLOCKS.register("miku_plush_zatsune",
			()->new MikuPlushieBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT).noOcclusion().sound(SoundType.WOOL)));
	public static final DeferredBlock<MikuPlushieBlock> MIKU_PLUSH_INFINITY=BLOCKS.register("miku_plush_infinity",
			()->new MikuPlushieBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT).noOcclusion().sound(SoundType.WOOL)));
	public static final DeferredBlock<MikuPlushieBlock> MIKU_PLUSH_VAMPIRE=BLOCKS.register("miku_plush_vampire",
			()->new MikuPlushieBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT).noOcclusion().sound(SoundType.WOOL)));
	public static final DeferredBlock<MikuPlushieBlock> MIKU_PLUSH_WEREWOMAN=BLOCKS.register("miku_plush_werewoman",
			()->new MikuPlushieBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT).noOcclusion().sound(SoundType.WOOL)));
	public static final DeferredBlock<MikuPlushieBlock> MIKU_PLUSH_JASON=BLOCKS.register("miku_plush_jason",
			()->new MikuPlushieBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT).noOcclusion().sound(SoundType.WOOL)));
	public static final DeferredBlock<MikuPlushieBlock> MIKU_PLUSH_MICHAEL_MYERS=BLOCKS.register("miku_plush_michael_myers",
			()->new MikuPlushieBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT).noOcclusion().sound(SoundType.WOOL)));
	public static final DeferredBlock<MikuPlushieBlock> MIKU_PLUSH_PUMPKIN=BLOCKS.register("miku_plush_pumpkin",
			()->new MikuPlushieBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT).noOcclusion().sound(SoundType.WOOL)));
	public static final DeferredBlock<MikuPlushieBlock> MIKU_PLUSH_GHOSTFACE=BLOCKS.register("miku_plush_ghostface",
			()->new MikuPlushieBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT).noOcclusion().sound(SoundType.WOOL)));
	public static final DeferredBlock<MikuPlushieBlock> MIKU_PLUSH_FRANKENSTEIN=BLOCKS.register("miku_plush_frankenstein",
			()->new MikuPlushieBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT).noOcclusion().sound(SoundType.WOOL)));
	public static final DeferredBlock<MikuPlushieBlock> MIKU_PLUSH_MUMMY=BLOCKS.register("miku_plush_mummy",
			()->new MikuPlushieBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT).noOcclusion().sound(SoundType.WOOL)));
	public static final DeferredBlock<MikuPlushieBlock> MIKU_PLUSH_GHOST=BLOCKS.register("miku_plush_ghost",
			()->new MikuPlushieBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT).noOcclusion().sound(SoundType.WOOL)));
	public static final DeferredBlock<MikuPlushieBlock> MIKU_PLUSH_PATATI=BLOCKS.register("miku_plush_patati",
			()->new MikuPlushieBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT).noOcclusion().sound(SoundType.WOOL)));
	public static final DeferredBlock<MikuPlushieBlock> MIKU_PLUSH_PATATA=BLOCKS.register("miku_plush_patata",
			()->new MikuPlushieBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT).noOcclusion().sound(SoundType.WOOL)));
	public static final DeferredBlock<MikuPlushieBlock> MIKU_PLUSH_DEVIL=BLOCKS.register("miku_plush_devil",
			()->new MikuPlushieBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT).noOcclusion().sound(SoundType.WOOL)));
	public static final DeferredBlock<MikuPlushieBlock> MIKU_PLUSH_WITCH=BLOCKS.register("miku_plush_witch",
			()->new MikuPlushieBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT).noOcclusion().sound(SoundType.WOOL)));
	public static final DeferredBlock<MikuPlushieBlock> MIKU_PLUSH_SANTA=BLOCKS.register("miku_plush_santa",
			()->new MikuPlushieBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT).noOcclusion().sound(SoundType.WOOL)));
	public static final DeferredBlock<MikuPlushieBlock> MIKU_PLUSH_REINDEER=BLOCKS.register("miku_plush_reindeer",
			()->new MikuPlushieBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT).noOcclusion().sound(SoundType.WOOL)));
	public static final DeferredBlock<MikuPlushieBlock> MIKU_PLUSH_SANTA_ELF=BLOCKS.register("miku_plush_santa_elf",
			()->new MikuPlushieBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT).noOcclusion().sound(SoundType.WOOL)));
	public static final DeferredBlock<MikuPlushieBlock> MIKU_PLUSH_XMAS_TREE=BLOCKS.register("miku_plush_xmas_tree",
			()->new MikuPlushieBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT).noOcclusion().sound(SoundType.WOOL)));

}
