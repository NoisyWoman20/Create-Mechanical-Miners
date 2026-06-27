package com.noisy_woman_20.create_mechanical_miners.blocks;

import com.simibubi.create.AllItems;
import net.minecraft.world.item.Item;
import org.jetbrains.annotations.NotNull;

public class ZincVeinBlock extends AbstractVeinBlock {
	public ZincVeinBlock(Properties properties) {
		super(properties);
	}

	@Override
	public @NotNull Item getOutput() {
		return AllItems.RAW_ZINC.get();
	}
}