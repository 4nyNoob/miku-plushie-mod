package com.any.mikuplushie.entity.variant;

import com.any.mikuplushie.registry.ModBlocks;
import com.any.mikuplushie.registry.ModEntities;
import com.any.mikuplushie.util.ModUtil;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityType;

import java.util.ArrayList;
import java.util.List;

public class PlushVariants {

    public static List<List<String>> ALL_PLUSH_VARIANTS = new ArrayList<>();

    public static void initialize(){

        //FOR EACH PLUSH ENTITY
        for (EntityType<?> entityType: ModEntities.PLUSH_ENTITIES){

            //GET ENTITY REGISTRY NAME
            String plushName = entityType.getUntranslatedName();

            //GET BLOCKS LIST
            List<Block> plushList = ModBlocks.PLUSH_BLOCKS;

            //CREATE SPECIFIC PLUSH VARIANTS LIST
            List<String> plushVariants = new ArrayList<>();

            //FOR EACH BLOCK IN THE LIST
            for (Block value : plushList) {
                //ADD IT TO SPECIFIC PLUSH VARIANTS LIST FI IT CONTAINS THE ENTITY NAME
                if (ModUtil.getBlockIdFromBlock(value).contains(plushName))
                    plushVariants.add(ModUtil.getBlockIdFromBlock(value));
            }
            //ADD SPECIFIC PLUSH VARIANTS LIST TO MAIN LIST
            ALL_PLUSH_VARIANTS.add(plushVariants);
        }

    }
}
