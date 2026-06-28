package com.noisy_woman_20.create_mechanical_miners.blocks;

import com.noisy_woman_20.create_mechanical_miners.CreateMechanicalMiners;
import com.tterrag.registrate.util.entry.BlockEntry;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;

public class CMMBlocks {
	public static final BlockEntry<AndesiteStressMinerBlock> ANDESITE_STRESS_MINER_BLOCK = CreateMechanicalMiners.REGISTRATE
		.block("andesite_stress_miner", AndesiteStressMinerBlock::new)
		.properties(p -> p.strength(1.5f))
		.properties(p -> p.explosionResistance(6f))
		.properties(p -> p.mapColor(MapColor.PODZOL))
		.properties(BlockBehaviour.Properties::requiresCorrectToolForDrops)
		.register();

	public static final BlockEntry<BrassStressMinerBlock> BRASS_STRESS_MINER_BLOCK = CreateMechanicalMiners.REGISTRATE
		.block("brass_stress_miner", BrassStressMinerBlock::new)
		.properties(p -> p.strength(1.5f))
		.properties(p -> p.explosionResistance(6f))
		.properties(p -> p.mapColor(MapColor.PODZOL))
		.properties(BlockBehaviour.Properties::requiresCorrectToolForDrops)
		.register();

	public static final BlockEntry<DiamondVeinBlock> DIAMOND_VEIN_BLOCK = CreateMechanicalMiners.REGISTRATE
		.block("diamond_vein", DiamondVeinBlock::new)
		.properties(p -> p.strength(3f))
		.properties(p -> p.explosionResistance(3f))
		.properties(p -> p.mapColor(MapColor.STONE))
		.properties(p -> p.sound(SoundType.STONE))
		.properties(BlockBehaviour.Properties::requiresCorrectToolForDrops)
		.register();

	public static final BlockEntry<DeepslateDiamondVeinBlock> DEEPSLATE_DIAMOND_VEIN_BLOCK = CreateMechanicalMiners.REGISTRATE
		.block("deepslate_diamond_vein", DeepslateDiamondVeinBlock::new)
		.properties(p -> p.strength(4.5f))
		.properties(p -> p.explosionResistance(3f))
		.properties(p -> p.mapColor(MapColor.DEEPSLATE))
		.properties(p -> p.sound(SoundType.DEEPSLATE))
		.properties(BlockBehaviour.Properties::requiresCorrectToolForDrops)
		.register();

	public static final BlockEntry<IronVeinBlock> IRON_VEIN_BLOCK = CreateMechanicalMiners.REGISTRATE
		.block("iron_vein", IronVeinBlock::new)
		.properties(p -> p.strength(3f))
		.properties(p -> p.explosionResistance(3f))
		.properties(p -> p.mapColor(MapColor.STONE))
		.properties(p -> p.sound(SoundType.STONE))
		.properties(BlockBehaviour.Properties::requiresCorrectToolForDrops)
		.register();

	public static final BlockEntry<DeepslateIronVeinBlock> DEEPSLATE_IRON_VEIN_BLOCK = CreateMechanicalMiners.REGISTRATE
		.block("deepslate_iron_vein", DeepslateIronVeinBlock::new)
		.properties(p -> p.strength(4.5f))
		.properties(p -> p.explosionResistance(3f))
		.properties(p -> p.mapColor(MapColor.DEEPSLATE))
		.properties(p -> p.sound(SoundType.DEEPSLATE))
		.properties(BlockBehaviour.Properties::requiresCorrectToolForDrops)
		.register();

	public static final BlockEntry<GoldVeinBlock> GOLD_VEIN_BLOCK = CreateMechanicalMiners.REGISTRATE
		.block("gold_vein", GoldVeinBlock::new)
		.properties(p -> p.strength(3f))
		.properties(p -> p.explosionResistance(3f))
		.properties(p -> p.mapColor(MapColor.STONE))
		.properties(p -> p.sound(SoundType.STONE))
		.properties(BlockBehaviour.Properties::requiresCorrectToolForDrops)
		.register();

	public static final BlockEntry<DeepslateGoldVeinBlock> DEEPSLATE_GOLD_VEIN_BLOCK = CreateMechanicalMiners.REGISTRATE
		.block("deepslate_gold_vein", DeepslateGoldVeinBlock::new)
		.properties(p -> p.strength(4.5f))
		.properties(p -> p.explosionResistance(3f))
		.properties(p -> p.mapColor(MapColor.DEEPSLATE))
		.properties(p -> p.sound(SoundType.DEEPSLATE))
		.properties(BlockBehaviour.Properties::requiresCorrectToolForDrops)
		.register();

	public static final BlockEntry<CopperVeinBlock> COPPER_VEIN_BLOCK = CreateMechanicalMiners.REGISTRATE
		.block("copper_vein", CopperVeinBlock::new)
		.properties(p -> p.strength(3f))
		.properties(p -> p.explosionResistance(3f))
		.properties(p -> p.mapColor(MapColor.STONE))
		.properties(p -> p.sound(SoundType.STONE))
		.properties(BlockBehaviour.Properties::requiresCorrectToolForDrops)
		.register();

	public static final BlockEntry<DeepslateCopperVeinBlock> DEEPSLATE_COPPER_VEIN_BLOCK = CreateMechanicalMiners.REGISTRATE
		.block("deepslate_copper_vein", DeepslateCopperVeinBlock::new)
		.properties(p -> p.strength(4.5f))
		.properties(p -> p.explosionResistance(3f))
		.properties(p -> p.mapColor(MapColor.DEEPSLATE))
		.properties(p -> p.sound(SoundType.DEEPSLATE))
		.properties(BlockBehaviour.Properties::requiresCorrectToolForDrops)
		.register();

	public static final BlockEntry<EmeraldVeinBlock> EMERALD_VEIN_BLOCK = CreateMechanicalMiners.REGISTRATE
		.block("emerald_vein", EmeraldVeinBlock::new)
		.properties(p -> p.strength(3f))
		.properties(p -> p.explosionResistance(3f))
		.properties(p -> p.mapColor(MapColor.STONE))
		.properties(p -> p.sound(SoundType.STONE))
		.properties(BlockBehaviour.Properties::requiresCorrectToolForDrops)
		.register();

	public static final BlockEntry<DeepslateEmeraldVeinBlock> DEEPSLATE_EMERALD_VEIN_BLOCK = CreateMechanicalMiners.REGISTRATE
		.block("deepslate_emerald_vein", DeepslateEmeraldVeinBlock::new)
		.properties(p -> p.strength(4.5f))
		.properties(p -> p.explosionResistance(3f))
		.properties(p -> p.mapColor(MapColor.DEEPSLATE))
		.properties(p -> p.sound(SoundType.DEEPSLATE))
		.properties(BlockBehaviour.Properties::requiresCorrectToolForDrops)
		.register();

	public static final BlockEntry<RedstoneVeinBlock> REDSTONE_VEIN_BLOCK = CreateMechanicalMiners.REGISTRATE
		.block("redstone_vein", RedstoneVeinBlock::new)
		.properties(p -> p.strength(3f))
		.properties(p -> p.explosionResistance(3f))
		.properties(p -> p.mapColor(MapColor.STONE))
		.properties(p -> p.sound(SoundType.STONE))
		.properties(BlockBehaviour.Properties::requiresCorrectToolForDrops)
		.register();

	public static final BlockEntry<DeepslateRedstoneVeinBlock> DEEPSLATE_REDSTONE_VEIN_BLOCK = CreateMechanicalMiners.REGISTRATE
		.block("deepslate_redstone_vein", DeepslateRedstoneVeinBlock::new)
		.properties(p -> p.strength(4.5f))
		.properties(p -> p.explosionResistance(3f))
		.properties(p -> p.mapColor(MapColor.DEEPSLATE))
		.properties(p -> p.sound(SoundType.DEEPSLATE))
		.properties(BlockBehaviour.Properties::requiresCorrectToolForDrops)
		.register();

	public static final BlockEntry<LapisVeinBlock> LAPIS_VEIN_BLOCK = CreateMechanicalMiners.REGISTRATE
		.block("lapis_vein", LapisVeinBlock::new)
		.properties(p -> p.strength(3f))
		.properties(p -> p.explosionResistance(3f))
		.properties(p -> p.mapColor(MapColor.STONE))
		.properties(p -> p.sound(SoundType.STONE))
		.properties(BlockBehaviour.Properties::requiresCorrectToolForDrops)
		.register();

	public static final BlockEntry<DeepslateLapisVeinBlock> DEEPSLATE_LAPIS_VEIN_BLOCK = CreateMechanicalMiners.REGISTRATE
		.block("deepslate_lapis_vein", DeepslateLapisVeinBlock::new)
		.properties(p -> p.strength(4.5f))
		.properties(p -> p.explosionResistance(3f))
		.properties(p -> p.mapColor(MapColor.DEEPSLATE))
		.properties(p -> p.sound(SoundType.DEEPSLATE))
		.properties(BlockBehaviour.Properties::requiresCorrectToolForDrops)
		.register();

	public static final BlockEntry<CoalVeinBlock> COAL_VEIN_BLOCK = CreateMechanicalMiners.REGISTRATE
		.block("coal_vein", CoalVeinBlock::new)
		.properties(p -> p.strength(3f))
		.properties(p -> p.explosionResistance(3f))
		.properties(p -> p.mapColor(MapColor.STONE))
		.properties(p -> p.sound(SoundType.STONE))
		.properties(BlockBehaviour.Properties::requiresCorrectToolForDrops)
		.register();

	public static final BlockEntry<DeepslateCoalVeinBlock> DEEPSLATE_COAL_VEIN_BLOCK = CreateMechanicalMiners.REGISTRATE
		.block("deepslate_coal_vein", DeepslateCoalVeinBlock::new)
		.properties(p -> p.strength(4.5f))
		.properties(p -> p.explosionResistance(3f))
		.properties(p -> p.mapColor(MapColor.DEEPSLATE))
		.properties(p -> p.sound(SoundType.DEEPSLATE))
		.properties(BlockBehaviour.Properties::requiresCorrectToolForDrops)
		.register();

	public static final BlockEntry<AmethystVeinBlock> AMETHYST_VEIN_BLOCK = CreateMechanicalMiners.REGISTRATE
		.block("amethyst_vein", AmethystVeinBlock::new)
		.properties(p -> p.strength(1.5f))
		.properties(p -> p.explosionResistance(1.5f))
		.properties(p -> p.mapColor(MapColor.COLOR_PURPLE))
		.properties(p -> p.sound(SoundType.AMETHYST))
		.properties(BlockBehaviour.Properties::requiresCorrectToolForDrops)
		.register();

	public static final BlockEntry<NetherQuartzVeinBlock> NETHER_QUARTZ_VEIN_BLOCK = CreateMechanicalMiners.REGISTRATE
		.block("nether_quartz_vein", NetherQuartzVeinBlock::new)
		.properties(p -> p.strength(3f))
		.properties(p -> p.explosionResistance(3f))
		.properties(p -> p.mapColor(MapColor.NETHER))
		.properties(p -> p.sound(SoundType.NETHER_ORE))
		.properties(BlockBehaviour.Properties::requiresCorrectToolForDrops)
		.register();

	public static final BlockEntry<ZincVeinBlock> ZINC_VEIN_BLOCK = CreateMechanicalMiners.REGISTRATE
		.block("zinc_vein", ZincVeinBlock::new)
		.properties(p -> p.strength(3f))
		.properties(p -> p.explosionResistance(3f))
		.properties(p -> p.mapColor(MapColor.STONE))
		.properties(p -> p.sound(SoundType.STONE))
		.properties(BlockBehaviour.Properties::requiresCorrectToolForDrops)
		.register();

	public static final BlockEntry<DeepslateZincVeinBlock> DEEPSLATE_ZINC_VEIN_BLOCK = CreateMechanicalMiners.REGISTRATE
		.block("deepslate_zinc_vein", DeepslateZincVeinBlock::new)
		.properties(p -> p.strength(4.5f))
		.properties(p -> p.explosionResistance(3f))
		.properties(p -> p.mapColor(MapColor.DEEPSLATE))
		.properties(p -> p.sound(SoundType.DEEPSLATE))
		.properties(BlockBehaviour.Properties::requiresCorrectToolForDrops)
		.register();

	public static void register() {
		CreateMechanicalMiners.LOGGER.info("Registering blocks...");
	}
}