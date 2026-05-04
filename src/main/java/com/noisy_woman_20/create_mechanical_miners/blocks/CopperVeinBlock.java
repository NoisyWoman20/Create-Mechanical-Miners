package com.noisy_woman_20.create_mechanical_miners.blocks;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class CopperVeinBlock extends AbstractVeinBlock {
	public CopperVeinBlock(Properties properties) {
		super(properties);
	}

	@Override
	public @NotNull Item getPrimaryOutput() {
		return Items.RAW_COPPER;
	}

	@Override
	public @Nullable Item getSecondaryOutput() {
		return null;
	}
}