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

	public static final ItemEntry<IronVeinItem> IRON_VEIN_ITEM = CreateMechanicalMiners.REGISTRATE
		.item("iron_vein", IronVeinItem::new)
		.register();

	public static final ItemEntry<DeepslateIronVeinItem> DEEPSLATE_IRON_VEIN_ITEM = CreateMechanicalMiners.REGISTRATE
		.item("deepslate_iron_vein", DeepslateIronVeinItem::new)
		.register();

	public static final ItemEntry<GoldVeinItem> GOLD_VEIN_ITEM = CreateMechanicalMiners.REGISTRATE
		.item("gold_vein", GoldVeinItem::new)
		.register();

	public static final ItemEntry<DeepslateGoldVeinItem> DEEPSLATE_GOLD_VEIN_ITEM = CreateMechanicalMiners.REGISTRATE
		.item("deepslate_gold_vein", DeepslateGoldVeinItem::new)
		.register();

	public static void register() {
		CreateMechanicalMiners.LOGGER.info("Registering items...");
	}
}