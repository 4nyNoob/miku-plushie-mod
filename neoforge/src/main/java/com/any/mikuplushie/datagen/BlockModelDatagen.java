package com.any.mikuplushie.datagen;

import com.any.mikuplushie.Constants;
import com.any.mikuplushie.block.MikuPlushieBlock;
import com.any.mikuplushie.registration.RegistryObject;
import com.any.mikuplushie.registry.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class BlockModelDatagen extends BlockStateProvider {

    public BlockModelDatagen(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, Constants.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        for (RegistryObject<Block, MikuPlushieBlock> plushBlock : ModBlocks.PLUSH_BLOCKS) {
            ModelFile plushModel = models().getExistingFile(this.modLoc(plushBlock.getId().getPath()));
            horizontalBlock(plushBlock.get(), plushModel);
        }
    }
}
