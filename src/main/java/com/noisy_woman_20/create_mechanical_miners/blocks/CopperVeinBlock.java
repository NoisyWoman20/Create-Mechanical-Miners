package com.noisy_woman_20.create_mechanical_miners.blocks;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import org.jetbrains.annotations.NotNull;

public class CopperVeinBlock extends AbstractVeinBlock {
	public CopperVeinBlock(Properties properties) {
		super(properties);
	}

	@Override
	public @NotNull Item getOutput() {
		return Items.RAW_COPPER;
	}
}