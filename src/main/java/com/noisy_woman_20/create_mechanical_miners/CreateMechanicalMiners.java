package com.noisy_woman_20.create_mechanical_miners;

import com.noisy_woman_20.create_mechanical_miners.block_entities.CMMBlockEntities;
import com.noisy_woman_20.create_mechanical_miners.blocks.CMMBlocks;
import com.noisy_woman_20.create_mechanical_miners.items.CMMItems;
import com.simibubi.create.foundation.data.CreateRegistrate;
import net.minecraft.resources.ResourceKey;
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
		REGISTRATE.registerEventListeners(modEventBus);

		CMMBlocks.register();
		CMMBlockEntities.register();
		CMMItems.register();
		CMMCreativeModeTabs.register(modEventBus);
	}
}