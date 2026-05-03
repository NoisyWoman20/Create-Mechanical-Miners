package com.noisy_woman_20.create_mechanical_miners.blocks;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class IronVeinBlock extends AbstractVeinBlock {
	public IronVeinBlock(Properties properties) {
		super(properties);
	}

	@Override
	public @NotNull Item getPrimaryOutput() {
		return Items.RAW_IRON;
	}

	@Override
	public @Nullable Item getSecondaryOutput() {
		return null;
	}
}