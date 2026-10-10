package com.any.mikuplushie.util;

import com.any.mikuplushie.registry.ModBlocks;
import com.any.mikuplushie.registry.ModSoundEvents;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.Item;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ModUtil {

    public static String getBlockIdFromBlockPos(World world, BlockPos pos){
        return world.getBlockState(pos).getBlock().getTranslationKey().split("[.]")[2];
    }

    public static String getBlockIdFromBlockState(BlockState state){
        return state.getBlock().getTranslationKey().split("[.]")[2];
    }

    public static String getBlockIdFromItem(Item itemConvertible){
        return itemConvertible.getTranslationKey().split("[.]")[2];
    }

    public static String getBlockIdFromBlock(Block block){
        return block.getTranslationKey().split("[.]")[2];
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
            String soundEventId = soundEvent.getId().toString().split(":")[1];
            if (soundEventId.contains(firstName) && soundEventId.contains("_" + action)){
                return soundEvent;
            }
        }

        return ModSoundEvents.MIKU_PLUSHIES_SOUND_EVENTS.getFirst();
    }

    public static void playPlushSound(World world, BlockPos position, String plushName, String action){
        if (!plushName.equals(ModUtil.getBlockIdFromBlock(ModBlocks.KONOHA_PLUSH))){
            SoundEvent soundEvent = getPlushSoundEvent(plushName, action);
            world.playSound(position.getX(), position.getY(), position.getZ(),
                soundEvent, SoundCategory.BLOCKS, 0.5F, 1, true);
        }
    }
}
