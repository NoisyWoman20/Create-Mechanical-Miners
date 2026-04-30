package com.noisy_woman_20.create_mechanical_miners.blocks;

import com.noisy_woman_20.create_mechanical_miners.CreateMechanicalMiners;
import com.tterrag.registrate.util.entry.BlockEntry;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;

public class CMMBlocks {
	public static final BlockEntry<AndesiteStressMinerBlock> ANDESITE_STRESS_MINER_BLOCK = CreateMechanicalMiners.REGISTRATE
		.block("andesite_stress_miner", AndesiteStressMinerBlock::new)
		.properties(p -> p.strength(1.5f))
		.properties(BlockBehaviour.Properties::requiresCorrectToolForDrops)
		.properties(p -> p.mapColor(MapColor.PODZOL))
		.properties(p -> p.explosionResistance(6f))
		.register();

	public static void register() {
		CreateMechanicalMiners.LOGGER.info("Registering blocks...");
	}
}