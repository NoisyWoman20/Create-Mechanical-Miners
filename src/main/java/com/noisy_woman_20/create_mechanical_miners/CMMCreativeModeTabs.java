package com.noisy_woman_20.create_mechanical_miners;

import com.noisy_woman_20.create_mechanical_miners.items.CMMItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class CMMCreativeModeTabs {
	private static final DeferredRegister<CreativeModeTab> REGISTRATE = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CreateMechanicalMiners.MOD_ID);

	public static final DeferredHolder<CreativeModeTab, CreativeModeTab> CREATE_MECHANICAL_MINERS_CREATIVE_TAB = REGISTRATE.register(
		"create_mechanical_miners_tab",
		() -> CreativeModeTab
			.builder()
			.title(Component.translatable("item_group.create_mechanical_miners.create_mechanical_miners_tab"))
			.withTabsBefore(ResourceLocation.fromNamespaceAndPath("create", "palettes"))
			.icon(CMMItems.ANDESITE_STRESS_MINER_ITEM::asStack)
			.displayItems((itemDisplayParameters, output) -> {
				output.accept(CMMItems.ANDESITE_STRESS_MINER_ITEM.get());
				output.accept(CMMItems.DIAMOND_VEIN_ITEM.get());
				output.accept(CMMItems.DEEPSLATE_DIAMOND_VEIN_ITEM.get());
				output.accept(CMMItems.IRON_VEIN_ITEM.get());
				output.accept(CMMItems.DEEPSLATE_IRON_VEIN_ITEM.get());
			})
			.build()
	);

	public static void register(IEventBus modEventBus) {
		CreateMechanicalMiners.LOGGER.info("Registering creative mode tabs...");
		REGISTRATE.register(modEventBus);
	}
}