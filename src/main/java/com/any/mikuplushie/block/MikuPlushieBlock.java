package com.any.mikuplushie.block;

import com.any.mikuplushie.ModEntities;
import com.any.mikuplushie.ModItems;
import com.any.mikuplushie.ModSoundEvents;
import com.any.mikuplushie.datagen.ModItemTagProvider;
import com.any.mikuplushie.entity.MikuEntity;
import com.any.mikuplushie.entity.PlushEntity;
import com.any.mikuplushie.entity.variant.MikuVariant;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.sound.SoundCategory;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

public class MikuPlushieBlock extends Block {
	public static final DirectionProperty FACING = HorizontalFacingBlock.FACING;
	public MikuPlushieBlock(Settings settings) {
		super(settings);
		this.setDefaultState(this.stateManager.getDefaultState().with(FACING, Direction.NORTH));
	}

	@Override
	public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {

        String currentPlush = state.getBlock().getTranslationKey().split("[.]")[2];

        if (
            player.getStackInHand(hand).isOf(ModItems.CANUDINHO) &&
            currentPlush.contains("miku_plush")
        ){
            if (!world.isClient) {

                //GET BLOCK NAME
                String blockName = world.getBlockState(pos).getBlock().getTranslationKey().split("[.]")[2];
                String entityName = blockName.split("_")[0] + "_" + blockName.split("_")[1];

                Vec3d entitySpawnLocation = pos.toCenterPos();
                //ENTITY TYPE REGISTRY
                Registry<EntityType<?>> entityTypeRegistry = world.getRegistryManager().get(RegistryKeys.ENTITY_TYPE);

                //ITERATE THROUGH ALL REGISTERED ENTITIES AND FILTER BY NAME
                for (int entity = 0; entity < entityTypeRegistry.size(); entity++) {
                    if (Objects.requireNonNull(entityTypeRegistry.get(entity)).getTranslationKey().contains(entityName)) {
                        //SPAWN ENTITY ACCORDING TO BLOCK NAME
                        PlushEntity spawned = (PlushEntity) Objects.requireNonNull(entityTypeRegistry.get(entity)).create(world);
                        //SETUP AND SPAWN ENTITY
                        world.spawnEntity(spawned);
                        Objects.requireNonNull(spawned).setVariantByBlock(blockName);
                        spawned.setPosition(entitySpawnLocation);
                            //DEBUG STUFF
//                            spawned.setAiDisabled(true);
//                            spawned.setCustomName(Text.of("Plush"));
                    }
                }

                world.playSound(null, pos, ModSoundEvents.MIKU_CANUDINHO, SoundCategory.BLOCKS);
                world.breakBlock(pos, false, player);
                return ActionResult.SUCCESS;
            } else {
                Random random = world.getRandom();
                for (int particles = 0; particles < 250; particles++) {
                    world.addParticle(
                        ParticleTypes.FIREWORK,
                        pos.getX() + 0.5D,
                        pos.getY() + 0.5D,
                        pos.getZ() + 0.5D,
                        random.nextGaussian() * 0.05,
                        random.nextGaussian() * 0.075,
                        random.nextGaussian() * 0.05
                    );
                }
            }
        }
		return super.onUse(state, world, pos, player, hand, hit);
	}

	@Override
	public void onPlaced(World world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack itemStack) {

        String currentPlush = state.getBlock().getTranslationKey().split("[.]")[2];

		if(currentPlush.contains("aiko_plush")){
			world.playSound(null, pos, ModSoundEvents.AIKO_OIE, SoundCategory.BLOCKS, 0.5F, 1);
		} else if(currentPlush.contains("teto_plush")){
			world.playSound(null, pos, ModSoundEvents.TETO_OIE, SoundCategory.BLOCKS, 0.5F, 1);
		} else if(currentPlush.contains("neru_plush")){
			world.playSound(null, pos, ModSoundEvents.NERU_OIE, SoundCategory.BLOCKS, 0.5F, 1);
		} else if(currentPlush.contains("rin_plush")){
			world.playSound(null, pos, ModSoundEvents.RIN_OIE, SoundCategory.BLOCKS, 0.5F, 1);
		} else if(currentPlush.contains("len_plush")){
			world.playSound(null, pos, ModSoundEvents.LEN_OIE, SoundCategory.BLOCKS, 0.5F, 1);
		} else if(currentPlush.contains("luka_plush")){
			world.playSound(null, pos, ModSoundEvents.LUKA_OIE, SoundCategory.BLOCKS, 0.5F, 1);
		} else if(currentPlush.contains("meiko_plush")){
			world.playSound(null, pos, ModSoundEvents.MEIKO_OIE, SoundCategory.BLOCKS, 0.5F, 1);
		} else if(currentPlush.contains("gumi_plush")){
			world.playSound(null, pos, ModSoundEvents.GUMI_OIE, SoundCategory.BLOCKS, 0.5F, 1);
		} else if(currentPlush.contains("miku_plush")){
			world.playSound(null, pos, ModSoundEvents.MIKU_OIE, SoundCategory.BLOCKS, 0.5F, 1);
		}
		super.onPlaced(world, pos, state, placer, itemStack);
	}

    @Override
    public ItemStack getPickStack(BlockView world, BlockPos pos, BlockState state) {
        for (int plush = 0; plush < ModItems.PLUSH_ITEMS.size(); plush++) {
            String plushNames = ModItems.PLUSH_ITEMS.get(plush).getTranslationKey().split("[.]")[2];
            String currentPlush = state.getBlock().getTranslationKey().split("[.]")[2];
            if (plushNames.equals(currentPlush)){
                return ModItems.PLUSH_ITEMS.get(plush).getDefaultStack();
            }
        }
        return ItemStack.EMPTY;
    }

    @Override
	public void onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        String currentPlush = state.getBlock().getTranslationKey().split("[.]")[2];

        if(currentPlush.contains("aiko_plush")){
            world.playSound(null, pos, ModSoundEvents.AIKO_BYE, SoundCategory.BLOCKS, 0.5F, 1);
        } else if(currentPlush.contains("teto_plush")){
            world.playSound(null, pos, ModSoundEvents.TETO_BYE, SoundCategory.BLOCKS, 0.5F, 1);
        } else if(currentPlush.contains("neru_plush")){
            world.playSound(null, pos, ModSoundEvents.NERU_BYE, SoundCategory.BLOCKS, 0.5F, 1);
        } else if(currentPlush.contains("rin_plush")){
            world.playSound(null, pos, ModSoundEvents.RIN_BYE, SoundCategory.BLOCKS, 0.5F, 1);
        } else if(currentPlush.contains("len_plush")){
            world.playSound(null, pos, ModSoundEvents.LEN_BYE, SoundCategory.BLOCKS, 0.5F, 1);
        } else if(currentPlush.contains("luka_plush")){
            world.playSound(null, pos, ModSoundEvents.LUKA_BYE, SoundCategory.BLOCKS, 0.5F, 1);
        } else if(currentPlush.contains("meiko_plush")){
            world.playSound(null, pos, ModSoundEvents.MEIKO_BYE, SoundCategory.BLOCKS, 0.5F, 1);
        } else if(currentPlush.contains("gumi_plush")){
            world.playSound(null, pos, ModSoundEvents.GUMI_BYE, SoundCategory.BLOCKS, 0.5F, 1);
        } else if(currentPlush.contains("miku_plush")){
            world.playSound(null, pos, ModSoundEvents.MIKU_BYE, SoundCategory.BLOCKS, 0.5F, 1);
        }
        super.onBreak(world, pos, state, player);
    }

	@Override
	public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
		final VoxelShape SHAPE = Block.createCuboidShape(4.5, 0.0, 4.5, 11.5, 13.5, 11.5);
		return SHAPE;
	}

	@Nullable
	public BlockState getPlacementState(ItemPlacementContext ctx) {
		return this.getDefaultState().with(FACING, ctx.getHorizontalPlayerFacing().getOpposite());
	}

	public BlockState rotate(BlockState state, BlockRotation rotation) {
		return state.with(FACING, rotation.rotate(state.get(FACING)));
	}

	protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
		builder.add(FACING);
	}
}
