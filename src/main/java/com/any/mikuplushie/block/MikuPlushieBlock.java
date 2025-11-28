package com.any.mikuplushie.block;

import com.any.mikuplushie.ModEntities;
import com.any.mikuplushie.ModItems;
import com.any.mikuplushie.ModSoundEvents;
import com.any.mikuplushie.datagen.ModTagProvider;
import com.any.mikuplushie.entity.MikuEntity;
import com.any.mikuplushie.entity.variant.MikuVariant;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleTypes;
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

public class MikuPlushieBlock extends Block {
	public static final DirectionProperty FACING = HorizontalFacingBlock.FACING;
	public MikuPlushieBlock(Settings settings) {
		super(settings);
		this.setDefaultState(this.stateManager.getDefaultState().with(FACING, Direction.NORTH));
	}

	@Override
	public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {

		if (!world.isClient){
			if (player.getStackInHand(hand).isOf(ModItems.CANUDINHO) && this.asItem().getDefaultStack().isIn(ModTagProvider.MIKU_PLUSH)){
                world.breakBlock(pos, false);
                MikuEntity miku = ModEntities.MIKU.create(world);
//				world.playSound(null, pos, ModSoundEvents.MIKU_CANUDINHO, SoundCategory.BLOCKS, 1F, 1F);
                if (miku != null) {
                    miku.setPosition(new Vec3d(pos.getX() + 0.5D, pos.getY(), pos.getZ() + 0.5D));
                    String mikuVariant = this.getLootTableId().getPath().split("/")[1].toUpperCase();
                    miku.setVariant(MikuVariant.valueOf(mikuVariant));
//                    miku.setOwner(player);
//                    miku.setInSittingPose(true);
//                    miku.setSitting(true);
                    miku.lookAt(miku.getCommandSource().getEntityAnchor(), player.getPos().add(0,1D,0));
                    miku.setCustomName(Text.of("Plush"));

                }
                world.spawnEntity(miku);
                world.playSound(null, pos, ModSoundEvents.MIKU_CANUDINHO, SoundCategory.BLOCKS);
				return ActionResult.SUCCESS;
			}
		} else if (player.getStackInHand(hand).isOf(ModItems.CANUDINHO) && this.asItem().getDefaultStack().isIn(ModTagProvider.MIKU_PLUSH)) {
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
		return super.onUse(state, world, pos, player, hand, hit);
	}

	@Override
	public void onPlaced(World world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack itemStack) {
		if(this.asItem().getDefaultStack().isIn(ModTagProvider.AIKO_PLUSH)){
			world.playSound(null, pos, ModSoundEvents.AIKO_OIE, SoundCategory.BLOCKS, 0.5F, 1);
		} else if(this.asItem().getDefaultStack().isIn(ModTagProvider.TETO_PLUSH)){
			world.playSound(null, pos, ModSoundEvents.TETO_OIE, SoundCategory.BLOCKS, 0.5F, 1);
		} else if(this.asItem().getDefaultStack().isIn(ModTagProvider.NERU_PLUSH)){
			world.playSound(null, pos, ModSoundEvents.NERU_OIE, SoundCategory.BLOCKS, 0.5F, 1);
		} else if(this.asItem().getDefaultStack().isIn(ModTagProvider.RIN_PLUSH)){
			world.playSound(null, pos, ModSoundEvents.RIN_OIE, SoundCategory.BLOCKS, 0.5F, 1);
		} else if(this.asItem().getDefaultStack().isIn(ModTagProvider.LEN_PLUSH)){
			world.playSound(null, pos, ModSoundEvents.LEN_OIE, SoundCategory.BLOCKS, 0.5F, 1);
		} else if(this.asItem().getDefaultStack().isIn(ModTagProvider.LUKA_PLUSH)){
			world.playSound(null, pos, ModSoundEvents.LUKA_OIE, SoundCategory.BLOCKS, 0.5F, 1);
		} else if(this.asItem().getDefaultStack().isIn(ModTagProvider.MIKU_PLUSH)){
			world.playSound(null, pos, ModSoundEvents.MIKU_OIE, SoundCategory.BLOCKS, 0.5F, 1);
		}
		super.onPlaced(world, pos, state, placer, itemStack);
	}

	@Override
	public void onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {
		if(this.asItem().getDefaultStack().isIn(ModTagProvider.AIKO_PLUSH)){
			world.playSound(null, pos, ModSoundEvents.AIKO_BYE, SoundCategory.BLOCKS, 0.5F, 1);
		} else if(this.asItem().getDefaultStack().isIn(ModTagProvider.TETO_PLUSH)){
			world.playSound(null, pos, ModSoundEvents.TETO_BYE, SoundCategory.BLOCKS, 0.5F, 1);
		} else if(this.asItem().getDefaultStack().isIn(ModTagProvider.NERU_PLUSH)){
			world.playSound(null, pos, ModSoundEvents.NERU_BYE, SoundCategory.BLOCKS, 0.5F, 1);
		} else if(this.asItem().getDefaultStack().isIn(ModTagProvider.RIN_PLUSH)){
			world.playSound(null, pos, ModSoundEvents.RIN_BYE, SoundCategory.BLOCKS, 0.5F, 1);
		} else if(this.asItem().getDefaultStack().isIn(ModTagProvider.LEN_PLUSH)){
			world.playSound(null, pos, ModSoundEvents.LEN_BYE, SoundCategory.BLOCKS, 0.5F, 1);
		} else if(this.asItem().getDefaultStack().isIn(ModTagProvider.LUKA_PLUSH)){
			world.playSound(null, pos, ModSoundEvents.LUKA_BYE, SoundCategory.BLOCKS, 0.5F, 1);
		} else if(this.asItem().getDefaultStack().isIn(ModTagProvider.MIKU_PLUSH)){
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
