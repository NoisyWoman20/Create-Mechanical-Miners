package com.noisy_woman_20.create_mechanical_miners.block_entities;

import com.noisy_woman_20.create_mechanical_miners.blocks.AbstractStressMinerBlock;
import com.noisy_woman_20.create_mechanical_miners.blocks.BrassStressMinerBlock;
import com.noisy_woman_20.create_mechanical_miners.menus.BrassStressMinerMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class BrassStressMinerBlockEntity extends AbstractStressMinerBlockEntity {
	public BrassStressMinerBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
		super(type, pos, state);
	}

	@Override
	public Class<? extends AbstractStressMinerBlock> getBlockClass() {
		return BrassStressMinerBlock.class;
	}

	@Override
	public float calculateStressApplied() {
		this.lastStressApplied = 256f;
		return this.lastStressApplied;
	}

	@Override
	public @NotNull Component getDisplayName() {
		return Component.translatable("block.create_mechanical_miners.brass_stress_miner");
	}

	@Override
	public @Nullable AbstractContainerMenu createMenu(int containerId, @NotNull Inventory playerInventory, @NotNull Player player) {
		return new BrassStressMinerMenu(containerId, playerInventory, this);
	}
}