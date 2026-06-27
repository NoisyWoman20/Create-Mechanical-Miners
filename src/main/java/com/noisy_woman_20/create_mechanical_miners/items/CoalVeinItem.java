package com.noisy_woman_20.create_mechanical_miners.items;

import com.noisy_woman_20.create_mechanical_miners.blocks.CMMBlocks;
import net.minecraft.world.item.BlockItem;

public class CoalVeinItem extends BlockItem {
	public CoalVeinItem(Properties properties) {
		super(CMMBlocks.COAL_VEIN_BLOCK.get(), properties);
	}
}