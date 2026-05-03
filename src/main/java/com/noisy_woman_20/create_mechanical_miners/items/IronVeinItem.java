package com.noisy_woman_20.create_mechanical_miners.items;

import com.noisy_woman_20.create_mechanical_miners.blocks.CMMBlocks;
import net.minecraft.world.item.BlockItem;

public class IronVeinItem extends BlockItem {
	public IronVeinItem(Properties properties) {
		super(CMMBlocks.IRON_VEIN_BLOCK.get(), properties);
	}
}