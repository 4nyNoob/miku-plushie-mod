package com.any.mikuplushie.util;

import com.any.mikuplushie.registry.ModBlocks;
import com.any.mikuplushie.registry.ModSoundEvents;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class ModUtil {

    public static String getBlockIdFromBlockPos(Level world, BlockPos pos){
        return world.getBlockState(pos).getBlock().getDescriptionId().split("[.]")[2];
    }

    public static String getBlockIdFromBlockState(BlockState state){
        return state.getBlock().getDescriptionId().split("[.]")[2];
    }

    public static String getBlockIdFromItem(Item itemConvertible){
        return itemConvertible.getDescriptionId().split("[.]")[2];
    }

    public static String getBlockIdFromBlock(Block block){
        return block.getDescriptionId().split("[.]")[2];
    }

    public static String getEntityNameFromBlockId(String blockId){
        String[] blockIdWords = blockId.split("_");
        return blockIdWords[0] + "_" + blockIdWords[1];
    }

    public static String getFirstNameFromBlockId(String blockId){
        String[] blockIdWords = blockId.split("_");
        return blockIdWords[0];
    }

    public static SoundEvent getPlushSoundEvent(String plushName, String action){
        String firstName = getFirstNameFromBlockId(plushName);

        for (SoundEvent soundEvent : ModSoundEvents.MIKU_PLUSHIES_SOUND_EVENTS){
            //GET SOUND EVENT
            String soundEventId = soundEvent.location().toString().split(":")[1];
            if (soundEventId.contains(firstName) && soundEventId.contains("_" + action)){
                return soundEvent;
            }
        }

        return ModSoundEvents.MIKU_PLUSHIES_SOUND_EVENTS.getFirst();
    }

    public static void playPlushSound(Level world, BlockPos position, String plushName, String action){
        if (!plushName.equals(ModUtil.getBlockIdFromBlock(ModBlocks.KONOHA_PLUSH))){
            SoundEvent soundEvent = getPlushSoundEvent(plushName, action);
            world.playLocalSound(position.getX(), position.getY(), position.getZ(),
                soundEvent, SoundSource.BLOCKS, 0.5F, 1, true);
        }
    }
}
