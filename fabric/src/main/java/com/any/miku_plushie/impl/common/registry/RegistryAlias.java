package com.any.miku_plushie.impl.common.registry;

import com.any.miku_plushie.Constants;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;

public class RegistryAlias {
    public static void registerAlias(){
        // ADD ALIASES TO PLUSH BLOCK, ITEM AND RECIPE
        for (String block : Constants.PLUSH_BLOCK_NAMES){
            BuiltInRegistries.BLOCK.addAlias(
                ResourceLocation.fromNamespaceAndPath(Constants.OLD_MOD_ID, block),
                ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, block)
            );
            BuiltInRegistries.ITEM.addAlias(
                ResourceLocation.fromNamespaceAndPath(Constants.OLD_MOD_ID, block),
                ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, block)
            );
        }
        // ADD ALIASES TO PICKAXES
        for (String pickaxe : Constants.TETO_PICKAXE_NAMES){
            BuiltInRegistries.ITEM.addAlias(
                ResourceLocation.fromNamespaceAndPath(Constants.OLD_MOD_ID, pickaxe),
                ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, pickaxe)
            );
        }
        // ADD ALIAS TO ENTITY TYPES
        for (String entity : Constants.PLUSH_NAMES){
            BuiltInRegistries.ENTITY_TYPE.addAlias(
                ResourceLocation.fromNamespaceAndPath(Constants.OLD_MOD_ID, entity + "_plush"),
                ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, entity + "_plush")
            );
        }
        // ADD ALIAS TO OTHER BLOCKS
        for (String entity : Constants.OTHER_BLOCK_NAMES){
            BuiltInRegistries.BLOCK.addAlias(
                ResourceLocation.fromNamespaceAndPath(Constants.OLD_MOD_ID, entity),
                ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, entity)
            );
        }
        // ADD ALIAS TO OTHER ITEMS
        for (String entity : Constants.OTHER_ITEM_NAMES){
            BuiltInRegistries.ITEM.addAlias(
                ResourceLocation.fromNamespaceAndPath(Constants.OLD_MOD_ID, entity),
                ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, entity)
            );
        }
    }
}
