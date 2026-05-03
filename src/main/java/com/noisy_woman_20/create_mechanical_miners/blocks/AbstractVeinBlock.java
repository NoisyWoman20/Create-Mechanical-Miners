package com.noisy_woman_20.create_mechanical_miners.blocks;

import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class AbstractVeinBlock extends Block {
	public AbstractVeinBlock(Properties properties) {
		super(properties);
	}

	public abstract @NotNull Item getPrimaryOutput();

	public abstract @Nullable Item getSecondaryOutput();
}