package com.noisy_woman_20.create_mechanical_miners.blocks;

import com.noisy_woman_20.create_mechanical_miners.block_entities.BrassStressMinerBlockEntity;
import com.noisy_woman_20.create_mechanical_miners.block_entities.CMMBlockEntities;
import com.simibubi.create.foundation.block.IBE;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;


public class BrassStressMinerBlock extends AbstractStressMinerBlock implements IBE<BrassStressMinerBlockEntity> {
	public BrassStressMinerBlock(Properties properties) {
		super(properties);
	}

	@Override
	public float getStressImpact() {
		return 256f;
	}

	@Override
	public Class<BrassStressMinerBlockEntity> getBlockEntityClass() {
		return BrassStressMinerBlockEntity.class;
	}

	@Override
	public BlockEntityType<? extends BrassStressMinerBlockEntity> getBlockEntityType() {
		return CMMBlockEntities.BRASS_STRESS_MINER_BLOCK_ENTITY.get();
	}

	@Override
	public BlockEntity newBlockEntity(BlockPos pos, @NotNull BlockState state) {
		return new BrassStressMinerBlockEntity(CMMBlockEntities.BRASS_STRESS_MINER_BLOCK_ENTITY.get(), pos, state);
	}
}