package com.noisy_woman_20.create_mechanical_miners.block_entities;

import com.noisy_woman_20.create_mechanical_miners.blocks.AbstractStressMinerBlock;
import com.noisy_woman_20.create_mechanical_miners.blocks.BrassStressMinerBlock;
import com.noisy_woman_20.create_mechanical_miners.blocks.CMMBlocks;
import com.noisy_woman_20.create_mechanical_miners.menus.BrassStressMinerMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashSet;
import java.util.Set;

public class BrassStressMinerBlockEntity extends AbstractStressMinerBlockEntity {
	public BrassStressMinerBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
		super(type, pos, state);
	}

	private static final Set<Block> MINEABLE_ORES = new HashSet<>();

	static {
		MINEABLE_ORES.add(CMMBlocks.IRON_VEIN_BLOCK.get());
		MINEABLE_ORES.add(CMMBlocks.DEEPSLATE_IRON_VEIN_BLOCK.get());
		MINEABLE_ORES.add(CMMBlocks.COPPER_VEIN_BLOCK.get());
		MINEABLE_ORES.add(CMMBlocks.DEEPSLATE_COPPER_VEIN_BLOCK.get());
		MINEABLE_ORES.add(CMMBlocks.GOLD_VEIN_BLOCK.get());
		MINEABLE_ORES.add(CMMBlocks.DEEPSLATE_GOLD_VEIN_BLOCK.get());
		MINEABLE_ORES.add(CMMBlocks.DIAMOND_VEIN_BLOCK.get());
		MINEABLE_ORES.add(CMMBlocks.DEEPSLATE_DIAMOND_VEIN_BLOCK.get());
		MINEABLE_ORES.add(CMMBlocks.EMERALD_VEIN_BLOCK.get());
		MINEABLE_ORES.add(CMMBlocks.DEEPSLATE_EMERALD_VEIN_BLOCK.get());
		MINEABLE_ORES.add(CMMBlocks.REDSTONE_VEIN_BLOCK.get());
		MINEABLE_ORES.add(CMMBlocks.DEEPSLATE_REDSTONE_VEIN_BLOCK.get());
		MINEABLE_ORES.add(CMMBlocks.LAPIS_VEIN_BLOCK.get());
		MINEABLE_ORES.add(CMMBlocks.DEEPSLATE_LAPIS_VEIN_BLOCK.get());
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

	@Override
	public boolean isMineable(Block oreBlock) {
		return MINEABLE_ORES.contains(oreBlock);
	}
}