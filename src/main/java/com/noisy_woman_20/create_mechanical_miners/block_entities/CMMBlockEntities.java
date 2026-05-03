package com.noisy_woman_20.create_mechanical_miners.block_entities;

import com.noisy_woman_20.create_mechanical_miners.CreateMechanicalMiners;
import com.noisy_woman_20.create_mechanical_miners.renderers.AndesiteStressMinerRenderer;
import com.noisy_woman_20.create_mechanical_miners.visuals.AndesiteStressMinerVisual;
import com.noisy_woman_20.create_mechanical_miners.blocks.CMMBlocks;
import com.tterrag.registrate.util.entry.BlockEntityEntry;

public class CMMBlockEntities {
	public static final BlockEntityEntry<AndesiteStressMinerBlockEntity> ANDESITE_STRESS_MINER_BLOCK_ENTITY = CreateMechanicalMiners.REGISTRATE
		.blockEntity("andesite_stress_miner", AndesiteStressMinerBlockEntity::new)
		.visual(() -> AndesiteStressMinerVisual::new, false)
		.validBlocks(CMMBlocks.ANDESITE_STRESS_MINER_BLOCK)
		.renderer(() -> AndesiteStressMinerRenderer::new)
		.register();

	public static void register() {
		CreateMechanicalMiners.LOGGER.info("Registering block entities...");
	}
}