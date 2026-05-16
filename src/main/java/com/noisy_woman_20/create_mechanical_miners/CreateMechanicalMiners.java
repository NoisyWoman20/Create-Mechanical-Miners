package com.noisy_woman_20.create_mechanical_miners;

import com.noisy_woman_20.create_mechanical_miners.block_entities.CMMBlockEntities;
import com.noisy_woman_20.create_mechanical_miners.blocks.AbstractKineticBlock;
import com.noisy_woman_20.create_mechanical_miners.blocks.CMMBlocks;
import com.noisy_woman_20.create_mechanical_miners.items.CMMItems;
import com.noisy_woman_20.create_mechanical_miners.menus.CMMMenus;
import com.simibubi.create.content.equipment.goggles.GogglesItem;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.simibubi.create.foundation.item.TooltipModifier;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.ModContainer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Mod(CreateMechanicalMiners.MOD_ID)
public class CreateMechanicalMiners {
    public static final String MOD_ID = "create_mechanical_miners";
	public static final String MOD_NAME = "Create: Mechanical Miners";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_NAME);

	public static final CreateRegistrate REGISTRATE = CreateRegistrate.create(MOD_ID);

	public CreateMechanicalMiners(IEventBus modEventBus, ModContainer modContainer) {
		REGISTRATE.defaultCreativeTab((ResourceKey<CreativeModeTab>)null);
		REGISTRATE.setTooltipModifierFactory(item -> {
			if (item instanceof BlockItem blockItem && blockItem.getBlock() instanceof AbstractKineticBlock abstractKineticBlock) {
				return (event) -> {
					Player player = event.getEntity();

					event.getToolTip().add(Component.empty());
					event.getToolTip().add(Component.translatable("create_mechanical_miners.tooltip.stress_impact").withStyle(ChatFormatting.GRAY));
					float stressImpact = abstractKineticBlock.getStressImpact();
					if (stressImpact <= 2) {
						if (GogglesItem.isWearingGoggles(player)) {
							event.getToolTip().add(
								Component.translatable("create_mechanical_miners.tooltip.stress_impact.low.full",
								Math.round(stressImpact)
							).withStyle(ChatFormatting.YELLOW));
						} else {
							event.getToolTip().add(Component.translatable("create_mechanical_miners.tooltip.stress_impact.low").withStyle(ChatFormatting.YELLOW));
						}
					} else if (stressImpact <= 4) {
						if (GogglesItem.isWearingGoggles(player)) {
							event.getToolTip().add(
								Component.translatable("create_mechanical_miners.tooltip.stress_impact.medium.full",
								Math.round(stressImpact)
							).withStyle(ChatFormatting.GOLD));
						} else {
							event.getToolTip().add(Component.translatable("create_mechanical_miners.tooltip.stress_impact.medium").withStyle(ChatFormatting.GOLD));
						}
					} else {
						if (GogglesItem.isWearingGoggles(player)) {
							event.getToolTip().add(
								Component.translatable("create_mechanical_miners.tooltip.stress_impact.high.full",
								Math.round(stressImpact)
							).withStyle(ChatFormatting.RED));
						} else {
							event.getToolTip().add(Component.translatable("create_mechanical_miners.tooltip.stress_impact.high").withStyle(ChatFormatting.RED));
						}
					}
				};
			}
			return TooltipModifier.EMPTY;
		});
		REGISTRATE.registerEventListeners(modEventBus);

		CMMBlocks.register();
		CMMBlockEntities.register();
		CMMItems.register();
		CMMCreativeModeTabs.register(modEventBus);
		CMMMenus.register(modEventBus);

		modEventBus.addListener(CMMCapabilities::registerCapabilities);
	}
}