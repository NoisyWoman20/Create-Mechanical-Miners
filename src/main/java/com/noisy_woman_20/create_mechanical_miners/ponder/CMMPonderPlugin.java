package com.noisy_woman_20.create_mechanical_miners.ponder;

import com.noisy_woman_20.create_mechanical_miners.CreateMechanicalMiners;
import net.createmod.ponder.api.registration.PonderPlugin;
import org.jetbrains.annotations.NotNull;

public class CMMPonderPlugin implements PonderPlugin {
	@Override
	public @NotNull String getModId() {
		return CreateMechanicalMiners.MOD_ID;
	}
}