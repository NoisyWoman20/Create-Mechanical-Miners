package com.noisy_woman_20.create_mechanical_miners.ponders;

import com.noisy_woman_20.create_mechanical_miners.CreateMechanicalMiners;
import com.noisy_woman_20.create_mechanical_miners.blocks.CMMBlocks;
import com.simibubi.create.infrastructure.ponder.AllCreatePonderTags;
import com.tterrag.registrate.util.entry.ItemProviderEntry;
import com.tterrag.registrate.util.entry.RegistryEntry;
import net.createmod.ponder.api.registration.PonderPlugin;
import net.createmod.ponder.api.registration.PonderSceneRegistrationHelper;
import net.createmod.ponder.api.registration.PonderTagRegistrationHelper;
import net.createmod.ponder.foundation.PonderIndex;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public class CMMPonders implements PonderPlugin {
	@Override
	public @NotNull String getModId() {
		return CreateMechanicalMiners.MOD_ID;
	}

	@Override
	public void registerScenes(@NotNull PonderSceneRegistrationHelper<ResourceLocation> helper) {
		PonderSceneRegistrationHelper<ItemProviderEntry<?, ?>> HELPER = helper.withKeyFunction(RegistryEntry::getId);

		HELPER.forComponents(CMMBlocks.ANDESITE_STRESS_MINER_BLOCK)
			.addStoryBoard(
				ResourceLocation.fromNamespaceAndPath(CreateMechanicalMiners.MOD_ID, "andesite_stress_miner"),
				AndesiteStressMinerScene::scene,
				AllCreatePonderTags.KINETIC_APPLIANCES
			);
	}

	@Override
	public void registerTags(@NotNull PonderTagRegistrationHelper<ResourceLocation> helper) {
		PonderTagRegistrationHelper<RegistryEntry<?, ?>> HELPER = helper.withKeyFunction(RegistryEntry::getId);

		HELPER.addToTag(AllCreatePonderTags.KINETIC_APPLIANCES).add(CMMBlocks.ANDESITE_STRESS_MINER_BLOCK);
	}

	public static void register() {
		CreateMechanicalMiners.LOGGER.info("Registering ponders...");
		PonderIndex.addPlugin(new CMMPonders());
	}
}