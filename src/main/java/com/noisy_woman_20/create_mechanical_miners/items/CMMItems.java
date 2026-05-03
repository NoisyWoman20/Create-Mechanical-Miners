package com.noisy_woman_20.create_mechanical_miners.items;

import com.noisy_woman_20.create_mechanical_miners.CreateMechanicalMiners;
import com.tterrag.registrate.util.entry.ItemEntry;

public class CMMItems {
	public static final ItemEntry<AndesiteStressMinerItem> ANDESITE_STRESS_MINER_ITEM = CreateMechanicalMiners.REGISTRATE
		.item("andesite_stress_miner", AndesiteStressMinerItem::new)
		.register();

	public static final ItemEntry<DiamondVeinItem> DIAMOND_VEIN_ITEM = CreateMechanicalMiners.REGISTRATE
		.item("diamond_vein", DiamondVeinItem::new)
		.register();

	public static final ItemEntry<DeepslateDiamondVeinItem> DEEPSLATE_DIAMOND_VEIN_ITEM = CreateMechanicalMiners.REGISTRATE
		.item("deepslate_diamond_vein", DeepslateDiamondVeinItem::new)
		.register();

	public static void register() {
		CreateMechanicalMiners.LOGGER.info("Registering items...");
	}
}