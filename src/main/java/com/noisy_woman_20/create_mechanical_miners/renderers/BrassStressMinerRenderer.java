package com.noisy_woman_20.create_mechanical_miners.renderers;

import com.noisy_woman_20.create_mechanical_miners.CMMPartialModels;
import com.noisy_woman_20.create_mechanical_miners.block_entities.BrassStressMinerBlockEntity;
import com.noisy_woman_20.create_mechanical_miners.blocks.BrassStressMinerBlock;
import com.simibubi.create.content.kinetics.base.KineticBlockEntityRenderer;
import dev.engine_room.flywheel.lib.model.baked.PartialModel;
import net.createmod.catnip.render.CachedBuffers;
import net.createmod.catnip.render.SuperByteBuffer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import org.jetbrains.annotations.NotNull;

public class BrassStressMinerRenderer extends KineticBlockEntityRenderer<BrassStressMinerBlockEntity> {
	public BrassStressMinerRenderer(BlockEntityRendererProvider.Context context) {
		super(context);
	}

	protected SuperByteBuffer getRotatedModel(@NotNull BrassStressMinerBlockEntity be, @NotNull BlockState state) {
		PartialModel model;

		if (state.getValue(BrassStressMinerBlock.HALF) == DoubleBlockHalf.UPPER) {
			model = CMMPartialModels.BRASS_STRESS_MINER_HEAD_LOWER;
		} else {
			model = CMMPartialModels.BRASS_STRESS_MINER_HEAD_LOWER;
		}

		return CachedBuffers.partial(model, state);
	}
}