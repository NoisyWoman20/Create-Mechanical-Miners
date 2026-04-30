package com.noisy_woman_20.create_mechanical_miners.block_entities;

import com.noisy_woman_20.create_mechanical_miners.blocks.CMMBlocks;
import com.noisy_woman_20.create_mechanical_miners.blocks.AndesiteStressMinerBlock;
import com.simibubi.create.content.kinetics.base.KineticBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;

import java.util.List;

public class AndesiteStressMinerBlockEntity extends KineticBlockEntity {
	private int retryDelay = 0;

	public AndesiteStressMinerBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
		super(type, pos, state);
		this.lastStressApplied = 256f;
	}

	@Override
	public float calculateStressApplied() {
		return this.lastStressApplied;
	}

	@Override
	public float getSpeed() {
		if (getBlockState().getValue(AndesiteStressMinerBlock.HALF) == DoubleBlockHalf.LOWER && level != null) {
			BlockEntity above = level.getBlockEntity(getBlockPos().above());
			if (above instanceof AndesiteStressMinerBlockEntity upper) {
				return upper.getSpeed();
			}
			return 0f;
		}
		return super.getSpeed();
	}

	@Override
	public float getTheoreticalSpeed() {
		if (getBlockState().getValue(AndesiteStressMinerBlock.HALF) == DoubleBlockHalf.LOWER && level != null) {
			BlockEntity above = level.getBlockEntity(getBlockPos().above());
			if (above instanceof AndesiteStressMinerBlockEntity upper) {
				return upper.getTheoreticalSpeed();
			}
			return 0f;
		}
		return super.getTheoreticalSpeed();
	}

	@Override
	public boolean isOverStressed() {
		if (getBlockState().getValue(AndesiteStressMinerBlock.HALF) == DoubleBlockHalf.LOWER && level != null) {
			BlockEntity above = level.getBlockEntity(getBlockPos().above());
			if (above instanceof AndesiteStressMinerBlockEntity upper) {
				return upper.isOverStressed();
			}
			return false;
		}
		return super.isOverStressed();
	}

	@Override
	public void setSpeed(float speed) {
		if (getBlockState().getValue(AndesiteStressMinerBlock.HALF) == DoubleBlockHalf.UPPER && level != null) {
			BlockEntity below = level.getBlockEntity(getBlockPos().below());
			if (below instanceof AndesiteStressMinerBlockEntity lower) {
				lower.setSpeed(speed);
			}
		}
		super.setSpeed(speed);
	}

	@Override
	public boolean addToGoggleTooltip(List<Component> tooltip, boolean isPlayerSneaking) {
		return super.addToGoggleTooltip(tooltip, isPlayerSneaking);
	}

	@Override
	public void tick() {
		super.tick();
		if (
			level != null &&
			level.getBlockState(getBlockPos().above()).is(CMMBlocks.ANDESITE_STRESS_MINER_BLOCK) &&
			getBlockState().getValue(AndesiteStressMinerBlock.HALF) == DoubleBlockHalf.LOWER &&
			++retryDelay >= 5
		) {
			super.setSpeed(getTheoreticalSpeed());
			overStressed = isOverStressed();
			retryDelay = 0;
		}
	}
}