package com.noisy_woman_20.create_mechanical_miners.items;

import com.noisy_woman_20.create_mechanical_miners.blocks.CMMBlocks;
import net.minecraft.world.item.BlockItem;

public class DiamondVeinItem extends BlockItem {
	public DiamondVeinItem(Properties properties) {
		super(CMMBlocks.DIAMOND_VEIN_BLOCK.get(), properties);
	}
}