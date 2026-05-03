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

	public static final BlockEntry<DiamondVeinBlock> DIAMOND_VEIN_BLOCK = CreateMechanicalMiners.REGISTRATE
		.block("diamond_vein", DiamondVeinBlock::new)
		.properties(p -> p.strength(1.5f))
		.properties(p -> p.explosionResistance(6f))
		.properties(p -> p.mapColor(MapColor.STONE))
		.properties(p -> p.sound(SoundType.STONE))
		.properties(BlockBehaviour.Properties::requiresCorrectToolForDrops)
		.register();

	public static final BlockEntry<DeepslateDiamondVeinBlock> DEEPSLATE_DIAMOND_VEIN_BLOCK = CreateMechanicalMiners.REGISTRATE
		.block("deepslate_diamond_vein", DeepslateDiamondVeinBlock::new)
		.properties(p -> p.strength(3f))
		.properties(p -> p.explosionResistance(6f))
		.properties(p -> p.mapColor(MapColor.DEEPSLATE))
		.properties(p -> p.sound(SoundType.DEEPSLATE))
		.properties(BlockBehaviour.Properties::requiresCorrectToolForDrops)
		.register();

	public static final BlockEntry<IronVeinBlock> IRON_VEIN_BLOCK = CreateMechanicalMiners.REGISTRATE
		.block("iron_vein", IronVeinBlock::new)
		.properties(p -> p.strength(1.5f))
		.properties(p -> p.explosionResistance(6f))
		.properties(p -> p.mapColor(MapColor.STONE))
		.properties(p -> p.sound(SoundType.STONE))
		.properties(BlockBehaviour.Properties::requiresCorrectToolForDrops)
		.register();

	public static final BlockEntry<DeepslateIronVeinBlock> DEEPSLATE_IRON_VEIN_BLOCK = CreateMechanicalMiners.REGISTRATE
		.block("deepslate_iron_vein", DeepslateIronVeinBlock::new)
		.properties(p -> p.strength(1.5f))
		.properties(p -> p.explosionResistance(6f))
		.properties(p -> p.mapColor(MapColor.STONE))
		.properties(p -> p.sound(SoundType.STONE))
		.properties(BlockBehaviour.Properties::requiresCorrectToolForDrops)
		.register();

	public static void register() {
		CreateMechanicalMiners.LOGGER.info("Registering blocks...");
	}
}