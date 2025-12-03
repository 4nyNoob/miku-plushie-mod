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
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKeys;
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


        if (player.getStackInHand(hand).isOf(ModItems.CANUDINHO) && this.asItem().getDefaultStack().isIn(ModItemTagProvider.MIKU_PLUSH)){
            if (!world.isClient) {
                world.breakBlock(pos, false, player);

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
                            spawned.setAiDisabled(true);
                            spawned.setCustomName(Text.of("Plush"));
                    }
                }

                world.playSound(null, pos, ModSoundEvents.MIKU_CANUDINHO, SoundCategory.BLOCKS);
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
		if(this.asItem().getDefaultStack().isIn(ModItemTagProvider.AIKO_PLUSH)){
			world.playSound(null, pos, ModSoundEvents.AIKO_OIE, SoundCategory.BLOCKS, 0.5F, 1);
		} else if(this.asItem().getDefaultStack().isIn(ModItemTagProvider.TETO_PLUSH)){
			world.playSound(null, pos, ModSoundEvents.TETO_OIE, SoundCategory.BLOCKS, 0.5F, 1);
		} else if(this.asItem().getDefaultStack().isIn(ModItemTagProvider.NERU_PLUSH)){
			world.playSound(null, pos, ModSoundEvents.NERU_OIE, SoundCategory.BLOCKS, 0.5F, 1);
		} else if(this.asItem().getDefaultStack().isIn(ModItemTagProvider.RIN_PLUSH)){
			world.playSound(null, pos, ModSoundEvents.RIN_OIE, SoundCategory.BLOCKS, 0.5F, 1);
		} else if(this.asItem().getDefaultStack().isIn(ModItemTagProvider.LEN_PLUSH)){
			world.playSound(null, pos, ModSoundEvents.LEN_OIE, SoundCategory.BLOCKS, 0.5F, 1);
		} else if(this.asItem().getDefaultStack().isIn(ModItemTagProvider.LUKA_PLUSH)){
			world.playSound(null, pos, ModSoundEvents.LUKA_OIE, SoundCategory.BLOCKS, 0.5F, 1);
		} else if(this.asItem().getDefaultStack().isIn(ModItemTagProvider.MEIKO_PLUSH)){
			world.playSound(null, pos, ModSoundEvents.MEIKO_OIE, SoundCategory.BLOCKS, 0.5F, 1);
		} else if(this.asItem().getDefaultStack().isIn(ModItemTagProvider.GUMI_PLUSH)){
			world.playSound(null, pos, ModSoundEvents.GUMI_OIE, SoundCategory.BLOCKS, 0.5F, 1);
		} else if(this.asItem().getDefaultStack().isIn(ModItemTagProvider.MIKU_PLUSH)){
			world.playSound(null, pos, ModSoundEvents.MIKU_OIE, SoundCategory.BLOCKS, 0.5F, 1);
		}
		super.onPlaced(world, pos, state, placer, itemStack);
	}

	@Override
	public void onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {
		if(this.asItem().getDefaultStack().isIn(ModItemTagProvider.AIKO_PLUSH)){
			world.playSound(null, pos, ModSoundEvents.AIKO_BYE, SoundCategory.BLOCKS, 0.5F, 1);
		} else if(this.asItem().getDefaultStack().isIn(ModItemTagProvider.TETO_PLUSH)){
			world.playSound(null, pos, ModSoundEvents.TETO_BYE, SoundCategory.BLOCKS, 0.5F, 1);
		} else if(this.asItem().getDefaultStack().isIn(ModItemTagProvider.NERU_PLUSH)){
			world.playSound(null, pos, ModSoundEvents.NERU_BYE, SoundCategory.BLOCKS, 0.5F, 1);
		} else if(this.asItem().getDefaultStack().isIn(ModItemTagProvider.RIN_PLUSH)){
			world.playSound(null, pos, ModSoundEvents.RIN_BYE, SoundCategory.BLOCKS, 0.5F, 1);
		} else if(this.asItem().getDefaultStack().isIn(ModItemTagProvider.LEN_PLUSH)){
			world.playSound(null, pos, ModSoundEvents.LEN_BYE, SoundCategory.BLOCKS, 0.5F, 1);
		} else if(this.asItem().getDefaultStack().isIn(ModItemTagProvider.LUKA_PLUSH)){
			world.playSound(null, pos, ModSoundEvents.LUKA_BYE, SoundCategory.BLOCKS, 0.5F, 1);
        } else if(this.asItem().getDefaultStack().isIn(ModItemTagProvider.MEIKO_PLUSH)){
			world.playSound(null, pos, ModSoundEvents.MEIKO_BYE, SoundCategory.BLOCKS, 0.5F, 1);
		} else if(this.asItem().getDefaultStack().isIn(ModItemTagProvider.GUMI_PLUSH)){
			world.playSound(null, pos, ModSoundEvents.GUMI_BYE, SoundCategory.BLOCKS, 0.5F, 1);
		} else if(this.asItem().getDefaultStack().isIn(ModItemTagProvider.MIKU_PLUSH)){
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
