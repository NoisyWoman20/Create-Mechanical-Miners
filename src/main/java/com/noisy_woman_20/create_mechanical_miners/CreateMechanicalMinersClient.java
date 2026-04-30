package com.noisy_woman_20.create_mechanical_miners;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;

@EventBusSubscriber(value = Dist.CLIENT, modid = CreateMechanicalMiners.MOD_ID)
public class CreateMechanicalMinersClient {
	@SubscribeEvent
	public static void onClientSetup(FMLClientSetupEvent event) {
		CMMPartialModels.init();
	}
}