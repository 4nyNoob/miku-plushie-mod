package com.any.mikuplushie.registry;

import com.any.mikuplushie.MikuPlushie;
import com.any.mikuplushie.item.MikuPlushieBlockItem;
import com.any.mikuplushie.item.ModFoodComponents;
import com.any.mikuplushie.util.ModUtil;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

public class ModItems{

    public static List<Item> REGULAR_ITEMS = new ArrayList<>();
    public static List<Item> PLUSH_ITEMS = new ArrayList<>();
    public static List<Item> PICKAXE_ITEMS = new ArrayList<>();

    //CREATE ITEM GROUP
	public static final ResourceKey<CreativeModeTab> MIKU_GROUP_KEY =
        ResourceKey.create(BuiltInRegistries.CREATIVE_MODE_TAB.key(), Identifier.fromNamespaceAndPath(MikuPlushie.MOD_ID, "item_group")
	);
	public static final CreativeModeTab MIKU_GROUP = FabricItemGroup.builder()
		.icon(() -> new ItemStack(ModBlocks.MIKU_PLUSH))
		.title(Component.translatable("item.group.miku_plushies"))
		.build();


    //REGISTER REGULAR ITEMS
	public static final Item CANUDINHO =
        register("canudinho", Item::new, new Item.Properties().rarity(Rarity.RARE));
	public static final Item BAGUETTE =
        register("baguette", Item::new, new Item.Properties().food(ModFoodComponents.BAGUETTE));

//    public static final Item LEEK_SEEDS =
//        registerItem("leek_seeds", createBlockItemWithCustomItemName(ModBlocks.LEEK_CROP));
    public static final Item LEEK =
        register("leek", Item::new, new Item.Properties().food(ModFoodComponents.LEEK));

    public static final Item AKITA_NERU_PHONE =
        register("akita_neru_phone", Item::new, new Item.Properties());

    public static final Item VOCALOID_HEART =
        register("vocaloid_heart", Item::new, new Item.Properties());

    public static final ToolMaterial PLUSH_TOOL_MATERIAL = new ToolMaterial(
        BlockTags.INCORRECT_FOR_WOODEN_TOOL,
        500,
        15,
        0,
        25,
        ItemTags.NETHERITE_TOOL_MATERIALS
    );

    //REGISTER TETO PICKAXE ITEMS
    public static final Item TETO_PICKAXE = registerPickaxe("teto_pickaxe");
    public static final Item TETO_PICKAXE_MESMERIZER = registerPickaxe("teto_pickaxe_mesmerizer");
    public static final Item TETO_PICKAXE_BIRDBRAIN = registerPickaxe("teto_pickaxe_birdbrain");
    public static final Item TETO_PICKAXE_REGRET_ROCK = registerPickaxe("teto_pickaxe_regret_rock");
    public static final Item TETO_PICKAXE_DONT_BELIEVE_IN_T = registerPickaxe("teto_pickaxe_dont_believe_in_t");
    public static final Item TETO_PICKAXE_LIAR_DANCER = registerPickaxe("teto_pickaxe_liar_dancer");
    public static final Item TETO_PICKAXE_WHATCHACALLITSNAME = registerPickaxe("teto_pickaxe_whatchacallitsname");
    public static final Item TETO_PICKAXE_SOME_MORE_OF_THAT_SONG = registerPickaxe("teto_pickaxe_some_more_of_that_song");
    public static final Item TETO_PICKAXE_SYNTHV = registerPickaxe("teto_pickaxe_synthv");
    public static final Item TETO_PICKAXE_SPOKEN_FOR = registerPickaxe("teto_pickaxe_spoken_for");
    public static final Item TETO_PICKAXE_PPPP = registerPickaxe("teto_pickaxe_pppp");

    //REGISTER PLUSH ITEMS
    public static Item registerPlush(String name) {
        Block plushBlock = null;
        for (int block = 0; block < ModBlocks.PLUSH_BLOCKS.size(); block++) {
            //MATCH ITEM TO THE RIGHT BLOCK
            Block registeredPlushBlock = ModBlocks.PLUSH_BLOCKS.get(block);
            if (ModUtil.getBlockIdFromBlock(registeredPlushBlock).matches(name)){
                plushBlock = registeredPlushBlock;
            }
        }
//        return registerItem(name, createBlockItemWithCustomItemName(plushBlock));
        return registerBlock(plushBlock, MikuPlushieBlockItem::new);
    }

    //REGISTER PICKAXES HELPER
    public static Item registerPickaxe(String name) {
        return register(name,
            Item::new,
            new Item.Properties().pickaxe(PLUSH_TOOL_MATERIAL, 1F, -2.8F)
        );
    }

    //REGISTER REGULAR ITEM
    public static <GenericItem extends Item> GenericItem register(String name, Function<Item.Properties, GenericItem> itemFactory, Item.Properties settings) {
        // Create the item key.
        ResourceKey<Item> itemKey = ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(MikuPlushie.MOD_ID, name));

        // Create the item instance.
        GenericItem item = itemFactory.apply(settings.setId(itemKey));

        // Register the item.
        Registry.register(BuiltInRegistries.ITEM, itemKey, item);

        if (item.getName().toString().contains("plush")){
            PLUSH_ITEMS.add(item);
        } else if (item.getName().toString().contains("pickaxe")) {
            PICKAXE_ITEMS.add(item);
        } else {
            REGULAR_ITEMS.add(item);
        }

        return item;
    }

    //REGISTER HELPERS
    public static Item registerBlock(Block block) {
        return registerBlock(block, BlockItem::new);
    }

    public static Item registerBlock(Block block, BiFunction<Block, Item.Properties, Item> biFunction) {
        return registerBlock(block, biFunction, new Item.Properties());
    }

    public static Item registerBlock(Block block, BiFunction<Block, Item.Properties, Item> biFunction, Item.Properties properties) {
        return registerItem(
            blockIdToItemId(block.builtInRegistryHolder().key()), propertiesx -> biFunction.apply(block, propertiesx), properties.useBlockDescriptionPrefix()
        );
    }


    private static ResourceKey<Item> blockIdToItemId(ResourceKey<Block> resourceKey) {
        return ResourceKey.create(Registries.ITEM, resourceKey.identifier());
    }

    private static Function<Item.Properties, Item> createBlockItemWithCustomItemName(Block block) {
        return properties -> new BlockItem(block, properties.useItemDescriptionPrefix());
    }

    public static Item registerItem(String string, Function<Item.Properties, Item> function) {
        return registerItem(mikuItemId(string), function, new Item.Properties());
    }

    public static Item registerItem(ResourceKey<Item> resourceKey, Function<Item.Properties, Item> function, Item.Properties properties) {
        Item item = function.apply(properties.setId(resourceKey));
        if (item instanceof BlockItem blockItem) {
            blockItem.registerBlocks(Item.BY_BLOCK, item);
        }

        return Registry.register(BuiltInRegistries.ITEM, resourceKey, item);
    }

    private static ResourceKey<Item> mikuItemId(String string) {
        return ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(MikuPlushie.MOD_ID, string));
    }

    //INITIALIZATION
	public static void initialize() {
        MikuPlushie.LOGGER.info("Registering " + MikuPlushie.MOD_ID + " Items");

        //REGISTER ITEM GROUP
		Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, MIKU_GROUP_KEY, MIKU_GROUP);

        //CREATE A ITEM FOR EVERY PLUSH BLOCK
        for (Block plushblock : ModBlocks.PLUSH_BLOCKS) {
            Item plushItem = registerPlush(ModUtil.getBlockIdFromBlock(plushblock));
            PLUSH_ITEMS.add(plushItem);
        }

        //POPULATE ITEM GROUP
		ItemGroupEvents.modifyEntriesEvent(MIKU_GROUP_KEY).register(itemGroup -> {

            REGULAR_ITEMS.forEach(itemGroup::accept);
            PLUSH_ITEMS.forEach(itemGroup::accept);
            PICKAXE_ITEMS.forEach(itemGroup::accept);

		});
	}
}
