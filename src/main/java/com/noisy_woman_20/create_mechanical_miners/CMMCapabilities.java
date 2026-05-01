package com.noisy_woman_20.create_mechanical_miners;

import com.noisy_woman_20.create_mechanical_miners.block_entities.CMMBlockEntities;
import com.noisy_woman_20.create_mechanical_miners.blocks.AndesiteStressMinerBlock;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import org.jetbrains.annotations.NotNull;

public class CMMCapabilities {
	public static void registerCapabilities(@NotNull RegisterCapabilitiesEvent event) {
		CreateMechanicalMiners.LOGGER.info("Registering capabilities...");

		event.registerBlockEntity(
			Capabilities.ItemHandler.BLOCK,
			CMMBlockEntities.ANDESITE_STRESS_MINER_BLOCK_ENTITY.get(),
			(be, context) -> {
				if (be.getBlockState().getValue(AndesiteStressMinerBlock.HALF) == DoubleBlockHalf.UPPER) {
					return be.itemHandler;
				} else {
					return null;
				}
			}
		);
	}
}