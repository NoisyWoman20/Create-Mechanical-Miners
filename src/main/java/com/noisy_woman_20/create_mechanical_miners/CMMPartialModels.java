package com.noisy_woman_20.create_mechanical_miners;

import dev.engine_room.flywheel.lib.model.baked.PartialModel;
import net.minecraft.resources.ResourceLocation;

public class CMMPartialModels {
	public static final PartialModel ANDESITE_STRESS_MINER_HEAD_LOWER = block("andesite_stress_miner/head_lower");
	public static final PartialModel ANDESITE_STRESS_MINER_HEAD_UPPER = block("andesite_stress_miner/head_upper");

	private static PartialModel block(String path) {
		ResourceLocation resource = ResourceLocation.fromNamespaceAndPath(CreateMechanicalMiners.MOD_ID, ("block/" + path));
		return PartialModel.of(resource);
	}

	public static void  register() {
		CreateMechanicalMiners.LOGGER.info("Registering partial models...");
	}
}