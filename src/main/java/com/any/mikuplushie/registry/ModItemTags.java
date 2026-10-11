package com.any.mikuplushie.registry;
import com.any.mikuplushie.MikuPlushie;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
public final class ModItemTags {
    public static final TagKey<Item> PLUSHIES = TagKey.of(RegistryKeys.ITEM, Identifier.of(MikuPlushie.MOD_ID, "plushies"));
    public static final TagKey<Item> TETO_PICKAXE = TagKey.of(RegistryKeys.ITEM, Identifier.of(MikuPlushie.MOD_ID, "teto_pickaxe"));
    public static final TagKey<Item> PLUSH_TOOL_REPAIR = TagKey.of(RegistryKeys.ITEM, Identifier.of(MikuPlushie.MOD_ID, "plush_tool_repair"));
}
