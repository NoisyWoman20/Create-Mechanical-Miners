package com.noisy_woman_20.create_mechanical_miners.screens;

import com.noisy_woman_20.create_mechanical_miners.CreateMechanicalMiners;
import com.noisy_woman_20.create_mechanical_miners.menus.CMMMenus;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import org.jetbrains.annotations.NotNull;

public class CMMScreens {
	public static void register(@NotNull RegisterMenuScreensEvent event) {
		CreateMechanicalMiners.LOGGER.info("Registering screens...");
		event.register(CMMMenus.ANDESITE_STRESS_MINER_MENU.get(), AndesiteStressMinerScreen::new);
	}
}