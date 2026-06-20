package com.noisy_woman_20.create_mechanical_miners.items;

import com.noisy_woman_20.create_mechanical_miners.CreateMechanicalMiners;
import com.tterrag.registrate.util.entry.ItemEntry;

public class CMMItems {
	public static final ItemEntry<AndesiteStressMinerItem> ANDESITE_STRESS_MINER_ITEM = CreateMechanicalMiners.REGISTRATE
		.item("andesite_stress_miner", AndesiteStressMinerItem::new)
		.register();

	public static final ItemEntry<BrassStressMinerItem> BRASS_STRESS_MINER_ITEM = CreateMechanicalMiners.REGISTRATE
		.item("brass_stress_miner", BrassStressMinerItem::new)
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

	public static final ItemEntry<CopperVeinItem> COPPER_VEIN_ITEM = CreateMechanicalMiners.REGISTRATE
		.item("copper_vein", CopperVeinItem::new)
		.register();

	public static final ItemEntry<DeepslateCopperVeinItem> DEEPSLATE_COPPER_VEIN_ITEM = CreateMechanicalMiners.REGISTRATE
		.item("deepslate_copper_vein", DeepslateCopperVeinItem::new)
		.register();

	public static final ItemEntry<EmeraldVeinItem> EMERALD_VEIN_ITEM = CreateMechanicalMiners.REGISTRATE
		.item("emerald_vein", EmeraldVeinItem::new)
		.register();

	public static final ItemEntry<DeepslateEmeraldVeinItem> DEEPSLATE_EMERALD_VEIN_ITEM = CreateMechanicalMiners.REGISTRATE
		.item("deepslate_emerald_vein", DeepslateEmeraldVeinItem::new)
		.register();

	public static final ItemEntry<RedstoneVeinItem> REDSTONE_VEIN_ITEM = CreateMechanicalMiners.REGISTRATE
		.item("redstone_vein", RedstoneVeinItem::new)
		.register();

	public static final ItemEntry<DeepslateRedstoneVeinItem> DEEPSLATE_REDSTONE_VEIN_ITEM = CreateMechanicalMiners.REGISTRATE
		.item("deepslate_redstone_vein", DeepslateRedstoneVeinItem::new)
		.register();

	public static final ItemEntry<LapisVeinItem> LAPIS_VEIN_ITEM = CreateMechanicalMiners.REGISTRATE
		.item("lapis_vein", LapisVeinItem::new)
		.register();

	public static final ItemEntry<DeepslateLapisVeinItem> DEEPSLATE_LAPIS_VEIN_ITEM = CreateMechanicalMiners.REGISTRATE
		.item("deepslate_lapis_vein", DeepslateLapisVeinItem::new)
		.register();

	public static void register() {
		CreateMechanicalMiners.LOGGER.info("Registering items...");
	}
}