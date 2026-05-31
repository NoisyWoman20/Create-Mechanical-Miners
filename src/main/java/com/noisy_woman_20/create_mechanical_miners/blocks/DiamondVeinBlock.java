package com.noisy_woman_20.create_mechanical_miners.blocks;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import org.jetbrains.annotations.NotNull;

public class DiamondVeinBlock extends AbstractVeinBlock {
	public DiamondVeinBlock(Properties properties) {
		super(properties);
	}

	@Override
	public @NotNull Item getOutput() {
		return Items.DIAMOND;
	}
}