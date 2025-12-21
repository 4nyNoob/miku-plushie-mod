package com.any.mikuplushie.block;

import com.any.mikuplushie.registry.ModItems;
import com.any.mikuplushie.registry.ModParticles;
import com.any.mikuplushie.entity.PlushEntity;
import com.any.mikuplushie.util.ModUtil;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.command.argument.EntityAnchorArgumentType;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
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

        if (
            player.getStackInHand(hand).isOf(ModItems.VOCALOID_HEART)
        ){
            if (!world.isClient) {

                //GET BLOCK NAME
                String blockName = ModUtil.getBlockIdFromBlockPos(world, pos);
                String entityName = ModUtil.getEntityNameFromBlockId(blockName);

                Vec3d entitySpawnLocation = pos.toCenterPos().subtract(0,0.5,0);
                //ENTITY TYPE REGISTRY
                Registry<EntityType<?>> entityTypeRegistry = world.getRegistryManager().get(RegistryKeys.ENTITY_TYPE);

                //ITERATE THROUGH ALL REGISTERED ENTITIES AND FILTER BY NAME
                for (int entity = 0; entity < entityTypeRegistry.size(); entity++) {
                    if (Objects.requireNonNull(entityTypeRegistry.get(entity)).getTranslationKey().contains(entityName)) {

                        //SPAWN ENTITY ACCORDING TO BLOCK NAME
                        PlushEntity spawned = (PlushEntity) Objects.requireNonNull(entityTypeRegistry.get(entity)).create(world);

                        //SETUP AND SPAWN ENTITY
                        Objects.requireNonNull(spawned).setVariantByBlock(blockName);
                        spawned.lookAt(EntityAnchorArgumentType.EntityAnchor.EYES, player.getPos().subtract(pos.toCenterPos()));
                        spawned.setOwner(player);
                        spawned.setPosition(entitySpawnLocation);
                        world.spawnEntity(spawned);
                    }
                }

                world.playSound(null, pos, SoundEvents.ITEM_TOTEM_USE, SoundCategory.BLOCKS, 0.5f, 1);
                world.breakBlock(pos, false, player);
                return ActionResult.SUCCESS;
            } else {
                for (int particles = 0; particles < 100; particles++) {
                    world.addParticle(
                        ModParticles.MIKU_SPAWN,
                        pos.getX() + 0.5D, pos.getY(), pos.getZ() + 0.5D,
                        0,0,0
                    );
                }
            }
        }
		return super.onUse(state, world, pos, player, hand, hit);
	}

	@Override
	public void onPlaced(World world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack itemStack) {
		super.onPlaced(world, pos, state, placer, itemStack);

        String currentPlush = ModUtil.getBlockIdFromBlockState(state);
        SoundEvent soundEvent = ModUtil.getPlushSoundEvent(currentPlush, "oie");
        world.playSound(null, pos, soundEvent, SoundCategory.BLOCKS, 0.5F , 1);
	}

    @Override
    public ItemStack getPickStack(BlockView world, BlockPos pos, BlockState state) {
        for (int plush = 0; plush < ModItems.PLUSH_ITEMS.size(); plush++) {
            String plushNames = ModUtil.getBlockIdFromItem(ModItems.PLUSH_ITEMS.get(plush));
            String currentPlush = ModUtil.getBlockIdFromBlockState(state);
            if (plushNames.equals(currentPlush)){
                return ModItems.PLUSH_ITEMS.get(plush).getDefaultStack();
            }
        }
        return ItemStack.EMPTY;
    }

    @Override
	public void onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        super.onBreak(world, pos, state, player);

        String currentPlush = ModUtil.getBlockIdFromBlockState(state);
        SoundEvent soundEvent = ModUtil.getPlushSoundEvent(currentPlush, "bye");
        world.playSound(null, pos, soundEvent, SoundCategory.BLOCKS, 0.5F , 1);
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
