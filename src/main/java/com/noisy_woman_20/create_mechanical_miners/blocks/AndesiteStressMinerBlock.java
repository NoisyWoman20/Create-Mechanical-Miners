package com.noisy_woman_20.create_mechanical_miners.blocks;

import com.noisy_woman_20.create_mechanical_miners.block_entities.CMMBlockEntities;
import com.noisy_woman_20.create_mechanical_miners.block_entities.AndesiteStressMinerBlockEntity;
import com.simibubi.create.foundation.block.IBE;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;


public class AndesiteStressMinerBlock extends AbstractStressMinerBlock implements IBE<AndesiteStressMinerBlockEntity> {
	public AndesiteStressMinerBlock(Properties properties) {
		super(properties);
	}

	@Override
	public float getStressImpact() {
		return 256f;
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
	public BlockEntity newBlockEntity(BlockPos pos, @NotNull BlockState state) {
		return new AndesiteStressMinerBlockEntity(CMMBlockEntities.ANDESITE_STRESS_MINER_BLOCK_ENTITY.get(), pos, state);
	}
}