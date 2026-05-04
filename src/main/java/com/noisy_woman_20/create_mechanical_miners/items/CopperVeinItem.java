package com.noisy_woman_20.create_mechanical_miners.items;

import com.noisy_woman_20.create_mechanical_miners.blocks.CMMBlocks;
import net.minecraft.world.item.BlockItem;

public class CopperVeinItem extends BlockItem {
	public CopperVeinItem(Properties properties) {
		super(CMMBlocks.COPPER_VEIN_BLOCK.get(), properties);
	}
}