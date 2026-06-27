package com.noisy_woman_20.create_mechanical_miners.blocks;

import net.minecraft.world.item.Item;
import com.simibubi.create.AllItems;
import org.jetbrains.annotations.NotNull;

public class DeepslateZincVeinBlock extends AbstractVeinBlock {
	public DeepslateZincVeinBlock(Properties properties) {
		super(properties);
	}

	@Override
	public @NotNull Item getOutput() {
		return AllItems.RAW_ZINC.get();
	}
}