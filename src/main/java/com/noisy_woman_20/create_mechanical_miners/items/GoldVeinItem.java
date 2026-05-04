package com.noisy_woman_20.create_mechanical_miners.items;

import com.noisy_woman_20.create_mechanical_miners.blocks.CMMBlocks;
import net.minecraft.world.item.BlockItem;

public class GoldVeinItem extends BlockItem {
	public GoldVeinItem(Properties properties) {
		super(CMMBlocks.GOLD_VEIN_BLOCK.get(), properties);
	}
}