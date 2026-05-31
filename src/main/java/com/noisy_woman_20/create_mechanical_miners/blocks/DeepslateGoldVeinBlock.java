package com.noisy_woman_20.create_mechanical_miners.blocks;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import org.jetbrains.annotations.NotNull;

public class DeepslateGoldVeinBlock extends AbstractVeinBlock {
	public DeepslateGoldVeinBlock(Properties properties) {
		super(properties);
	}

	@Override
	public @NotNull Item getOutput() {
		return Items.RAW_GOLD;
	}
}