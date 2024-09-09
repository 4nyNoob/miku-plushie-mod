package com.any.mikuplushie;

import com.any.mikuplushie.block.MikuPlushieBlock;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {

	public static final Block MIKU_PLUSH_BR_BLOCK = register(
			new MikuPlushieBlock(AbstractBlock.Settings.copy(Blocks.FLOWER_POT)
			.sounds(BlockSoundGroup.WOOL)
			.nonOpaque()
			),
			"miku_plush_br",
			false
	);
	public static final Block MIKU_PLUSH_BR_BA_BLOCK = register(
			new MikuPlushieBlock(AbstractBlock.Settings.copy(Blocks.FLOWER_POT)
			.sounds(BlockSoundGroup.WOOL)
			.nonOpaque()
			),
			"miku_plush_br_ba",
			false
	);
	public static final Block MIKU_PLUSH_BIK_BLOCK = register(
			new MikuPlushieBlock(AbstractBlock.Settings.copy(Blocks.FLOWER_POT)
			.sounds(BlockSoundGroup.WOOL)
			.nonOpaque()
			),
			"miku_plush_bik",
			false
	);
	public static final Block MIKU_PLUSH_BR_BEACH_BLOCK = register(
			new MikuPlushieBlock(AbstractBlock.Settings.copy(Blocks.FLOWER_POT)
			.sounds(BlockSoundGroup.WOOL)
			.nonOpaque()
			),
			"miku_plush_br_beach",
			false
	);
	public static final Block MIKU_PLUSH_BR_BRAID_BLOCK = register(
			new MikuPlushieBlock(AbstractBlock.Settings.copy(Blocks.FLOWER_POT)
			.sounds(BlockSoundGroup.WOOL)
			.nonOpaque()
			),
			"miku_plush_br_braid",
			false
	);
	public static final Block MIKU_PLUSH_BR_BA_DRUM_BLOCK = register(
			new MikuPlushieBlock(AbstractBlock.Settings.copy(Blocks.FLOWER_POT)
			.sounds(BlockSoundGroup.WOOL)
			.nonOpaque()
			),
			"miku_plush_br_ba_drum",
			false
	);
	public static final Block MIKU_PLUSH_BR_PR_BLOCK = register(
			new MikuPlushieBlock(AbstractBlock.Settings.copy(Blocks.FLOWER_POT)
			.sounds(BlockSoundGroup.WOOL)
			.nonOpaque()
			),
			"miku_plush_br_pr",
			false
	);
	public static final Block MIKU_PLUSH_BR_SP_BLOCK = register(
			new MikuPlushieBlock(AbstractBlock.Settings.copy(Blocks.FLOWER_POT)
			.sounds(BlockSoundGroup.WOOL)
			.nonOpaque()
			),
			"miku_plush_br_sp",
			false
	);




	public static Block register(Block block, String name, boolean shouldRegisterItem) {
		Identifier id = Identifier.of(MikuPlushie.MOD_ID, name);
		if (shouldRegisterItem) {
			BlockItem blockItem = new BlockItem(block, new Item.Settings());
			Registry.register(Registries.ITEM, id, blockItem);
		}
		return Registry.register(Registries.BLOCK, id, block);
	}

	public static void initialize() {}
}
