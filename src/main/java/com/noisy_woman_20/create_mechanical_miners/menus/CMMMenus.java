package com.noisy_woman_20.create_mechanical_miners.menus;

import com.noisy_woman_20.create_mechanical_miners.CreateMechanicalMiners;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.inventory.MenuType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class CMMMenus {
	public static final DeferredRegister<MenuType<?>> REGISTER = DeferredRegister.create(Registries.MENU, CreateMechanicalMiners.MOD_ID);

	public static final Supplier<MenuType<AndesiteStressMinerMenu>> ANDESITE_STRESS_MINER_MENU = REGISTER.register(
		"andesite_stress_miner",
		() -> new MenuType<>(AndesiteStressMinerMenu::new, FeatureFlags.DEFAULT_FLAGS)
	);

	public static void register(IEventBus bus) {
		CreateMechanicalMiners.LOGGER.info("Registering menus...");
		REGISTER.register(bus);
	}
}