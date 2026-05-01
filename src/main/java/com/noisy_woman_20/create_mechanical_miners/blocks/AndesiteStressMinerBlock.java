package com.noisy_woman_20.create_mechanical_miners.blocks;

import com.noisy_woman_20.create_mechanical_miners.CreateMechanicalMiners;
import com.noisy_woman_20.create_mechanical_miners.block_entities.CMMBlockEntities;
import com.noisy_woman_20.create_mechanical_miners.block_entities.AndesiteStressMinerBlockEntity;
import com.simibubi.create.content.equipment.wrench.IWrenchable;
import com.simibubi.create.content.kinetics.base.KineticBlock;
import com.simibubi.create.foundation.block.IBE;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.level.BlockEvent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

public class AndesiteStressMinerBlock extends KineticBlock implements IBE<AndesiteStressMinerBlockEntity> {
	public static final EnumProperty<DoubleBlockHalf> HALF = BlockStateProperties.DOUBLE_BLOCK_HALF;
	protected static final VoxelShape SHAPE = Block.box(0, 0, 0, 16, 16, 16);

	public AndesiteStressMinerBlock(Properties properties) {
		super(properties);
		this.registerDefaultState(this.getStateDefinition().any().setValue(HALF, DoubleBlockHalf.LOWER));
	}

	@Override
	public @Nullable BlockState getStateForPlacement(@NotNull BlockPlaceContext context) {
		BlockPos clickedPos = context.getClickedPos();
		Level level = context.getLevel();
		if (clickedPos.getY() < level.getMaxBuildHeight() - 1 && level.getBlockState(clickedPos.above()).isAir()) {
			return this.defaultBlockState().setValue(HALF, DoubleBlockHalf.LOWER);
		}
		return null;
	}

	@Override
	public void setPlacedBy(@NotNull Level level, BlockPos pos, BlockState state, LivingEntity placer, ItemStack stack) {
		if (level.isClientSide()) {
			return;
		}

		BlockPos abovePos = pos.above();
		if (level.getBlockState(abovePos).isAir()) {
			level.setBlock(abovePos, this.defaultBlockState().setValue(HALF, DoubleBlockHalf.UPPER), 3);
		}
	}

	@Override
	public @NotNull BlockState playerWillDestroy(@NotNull Level level, @NotNull BlockPos pos, @NotNull BlockState state, @NotNull Player player) {
		if (level.getBlockEntity(pos) instanceof AndesiteStressMinerBlockEntity be) {
			be.dropItem();
		}

		DoubleBlockHalf half = state.getValue(HALF);
		BlockPos otherPos = half == DoubleBlockHalf.LOWER ? pos.above() : pos.below();
		BlockState otherState = level.getBlockState(otherPos);

		if (otherState.is(this) && otherState.getValue(HALF) != half) {
			level.destroyBlock(otherPos, false);
		}

		return super.playerWillDestroy(level, pos, state, player);
	}

	@Override
	public InteractionResult onSneakWrenched(BlockState state, @NotNull UseOnContext context) {
		Level level = context.getLevel();
		BlockPos pos = context.getClickedPos();
		Player player = context.getPlayer();

		if (!(level instanceof ServerLevel serverLevel)) {
			return InteractionResult.SUCCESS;
		}

		DoubleBlockHalf half = state.getValue(HALF);
		BlockPos otherPos = half == DoubleBlockHalf.LOWER ? pos.above() : pos.below();
		BlockState otherState = level.getBlockState(otherPos);
		boolean hasOther = otherState.is(this) && otherState.getValue(HALF) != half;

		BlockEvent.BreakEvent event = new BlockEvent.BreakEvent(level, pos, level.getBlockState(pos), Objects.requireNonNull(player));
		NeoForge.EVENT_BUS.post(event);
		if (event.isCanceled()) {
			return InteractionResult.SUCCESS;
		}

		if (!player.isCreative()) {
			Block.getDrops(
				state,
				serverLevel,
				pos,
				level.getBlockEntity(pos),
				player,
				context.getItemInHand()).forEach(itemStack -> player.getInventory().placeItemBackInInventory(itemStack)
			);
		}

		if (level.getBlockEntity(pos) instanceof AndesiteStressMinerBlockEntity be) {
			be.dropItem();
		}

		state.spawnAfterBreak(serverLevel, pos, ItemStack.EMPTY, true);
		level.destroyBlock(pos, false);
		IWrenchable.playRemoveSound(level, pos);

		if (hasOther) {
			otherState.spawnAfterBreak(serverLevel, otherPos, ItemStack.EMPTY, true);
			level.destroyBlock(otherPos, false);
			IWrenchable.playRemoveSound(level, otherPos);
		}

		return InteractionResult.SUCCESS;
	}

	@Override
	protected void createBlockStateDefinition(@NotNull  StateDefinition.Builder<Block, BlockState> builder) {
		super.createBlockStateDefinition(builder);
		builder.add(HALF);
	}

	@Override
	public @NotNull VoxelShape getShape(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull CollisionContext context) {
		return SHAPE;
	}

	@Override
	public Direction.Axis getRotationAxis(BlockState state) {
		return Direction.Axis.Y;
	}

	@Override
	public boolean hasShaftTowards(LevelReader world, BlockPos pos, @NotNull BlockState state, Direction face) {
		return (state.getValue(HALF) == DoubleBlockHalf.UPPER && face == Direction.UP);
	}

	@Override
	public Class<AndesiteStressMinerBlockEntity> getBlockEntityClass() {
		return AndesiteStressMinerBlockEntity.class;
	}

	@Override
	public BlockEntityType<? extends AndesiteStressMinerBlockEntity> getBlockEntityType() {
		return CMMBlockEntities.ANDESITE_STRESS_MINER_BLOCK_ENTITY.get();
	}

	@Override
	protected boolean isCollisionShapeFullBlock(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos) {
		return false;
	}

	@Override
	protected boolean isOcclusionShapeFullBlock(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos) {
		return false;
	}

	@Override
	protected @NotNull VoxelShape getOcclusionShape(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos) {
		return Shapes.empty();
	}

	@Override
	protected boolean skipRendering(@NotNull BlockState state, @NotNull BlockState adjacentState, @NotNull Direction direction) {
		if (state.getValue(HALF) == DoubleBlockHalf.LOWER && direction == Direction.DOWN) {
			return false;
		}
		return super.skipRendering(state, adjacentState, direction);
	}

	@Override
	protected boolean propagatesSkylightDown(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos) {
		return true;
	}

	@Override
	public BlockEntity newBlockEntity(BlockPos pos, @NotNull BlockState state) {
		return new AndesiteStressMinerBlockEntity(CMMBlockEntities.ANDESITE_STRESS_MINER_BLOCK_ENTITY.get(), pos, state);
	}
//
//	@Override
//	public SpeedLevel getMinimumRequiredSpeedLevel() {
//		return SpeedLevel.FAST;
//	}
}