package com.any.mikuplushie.block;

import com.any.mikuplushie.entity.AbstractPlushEntity;
import com.any.mikuplushie.registry.ModItems;
import com.any.mikuplushie.registry.ModParticles;
import com.any.mikuplushie.util.ModUtil;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;
import net.minecraft.commands.arguments.EntityAnchorArgument;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class MikuPlushieBlock extends Block {
	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
	public MikuPlushieBlock(Properties settings) {
		super(settings);
		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
	}

    @Override
	public ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {

        if (
            player.getItemInHand(hand).is(ModItems.VOCALOID_HEART)
        ){
            if (!world.isClientSide) {

                //GET BLOCK NAME
                String blockName = ModUtil.getBlockIdFromBlockPos(world, pos);
                String entityName = ModUtil.getEntityNameFromBlockId(blockName);

                Vec3 entitySpawnLocation = pos.getCenter().subtract(0,0.5,0);
                //ENTITY TYPE REGISTRY
                Registry<EntityType<?>> entityTypeRegistry = world.registryAccess().registryOrThrow(Registries.ENTITY_TYPE);

                //ITERATE THROUGH ALL REGISTERED ENTITIES AND FILTER BY NAME
                for (int entity = 0; entity < entityTypeRegistry.size(); entity++) {
                    if (Objects.requireNonNull(entityTypeRegistry.byId(entity)).getDescriptionId().contains(entityName)) {

                        //SPAWN ENTITY ACCORDING TO BLOCK NAME
                        AbstractPlushEntity spawned = (AbstractPlushEntity) Objects.requireNonNull(entityTypeRegistry.byId(entity)).create(world);

                        //SETUP AND SPAWN ENTITY
                        Objects.requireNonNull(spawned).setVariantByBlock(blockName);
                        spawned.lookAt(EntityAnchorArgument.Anchor.EYES, player.position().subtract(pos.getCenter()));
                        spawned.tame(player);
                        spawned.setPos(entitySpawnLocation);
                        world.addFreshEntity(spawned);
                    }
                }

                world.playSound(null, pos, SoundEvents.TOTEM_USE, SoundSource.BLOCKS, 0.5f, 1);
                world.destroyBlock(pos, false, player);
                return ItemInteractionResult.SUCCESS;
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
        return super.useItemOn(stack, state, world, pos, player, hand, hit);
	}

	@Override
	public void setPlacedBy(Level world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack itemStack) {
		super.setPlacedBy(world, pos, state, placer, itemStack);

        String currentPlush = ModUtil.getBlockIdFromBlockState(state);
        ModUtil.playPlushSound(world, pos, currentPlush, "oie");
	}

    @Override
    public ItemStack getCloneItemStack(LevelReader world, BlockPos pos, BlockState state) {
        for (int plush = 0; plush < ModItems.PLUSH_ITEMS.size(); plush++) {
            String plushNames = ModUtil.getBlockIdFromItem(ModItems.PLUSH_ITEMS.get(plush));
            String currentPlush = ModUtil.getBlockIdFromBlockState(state);
            if (plushNames.equals(currentPlush)){
                return ModItems.PLUSH_ITEMS.get(plush).getDefaultInstance();
            }
        }
        return ItemStack.EMPTY;
    }

    @Override
	public BlockState playerWillDestroy(Level world, BlockPos pos, BlockState state, Player player) {
        String currentPlush = ModUtil.getBlockIdFromBlockState(state);
        ModUtil.playPlushSound(world, pos, currentPlush, "bye");

        return super.playerWillDestroy(world, pos, state, player);
    }

	@Override
	public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
		final VoxelShape SHAPE = Block.box(4.5, 0.0, 4.5, 11.5, 13.5, 11.5);
		return SHAPE;
	}

	@Nullable
	public BlockState getStateForPlacement(BlockPlaceContext ctx) {
		return this.defaultBlockState().setValue(FACING, ctx.getHorizontalDirection().getOpposite());
	}

	public BlockState rotate(BlockState state, Rotation rotation) {
		return state.setValue(FACING, rotation.rotate(state.getValue(FACING)));
	}

	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(FACING);
	}
}
