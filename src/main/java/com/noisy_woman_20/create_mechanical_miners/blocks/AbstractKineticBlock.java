package com.noisy_woman_20.create_mechanical_miners.blocks;

import com.simibubi.create.content.kinetics.base.KineticBlock;

public abstract class AbstractKineticBlock extends KineticBlock {
	public AbstractKineticBlock(Properties properties) {
		super(properties);
	}

	public abstract float getStressImpact();
}