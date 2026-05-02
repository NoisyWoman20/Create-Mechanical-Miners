package com.noisy_woman_20.create_mechanical_miners;

import com.noisy_woman_20.create_mechanical_miners.screens.CMMScreens;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import org.jetbrains.annotations.NotNull;

@EventBusSubscriber(value = Dist.CLIENT, modid = CreateMechanicalMiners.MOD_ID)
public class CreateMechanicalMinersClient {
	@SubscribeEvent
	public static void onClientSetup(FMLClientSetupEvent event) {
		CMMPartialModels.init();
	}

	@SubscribeEvent
	public static void onRegisterMenuScreensEvent(@NotNull RegisterMenuScreensEvent event) {
		CMMScreens.register(event);
	}
}