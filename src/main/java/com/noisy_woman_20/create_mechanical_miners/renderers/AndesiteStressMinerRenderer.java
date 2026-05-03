package com.noisy_woman_20.create_mechanical_miners.renderers;

import com.noisy_woman_20.create_mechanical_miners.CMMPartialModels;
import com.noisy_woman_20.create_mechanical_miners.block_entities.AndesiteStressMinerBlockEntity;
import com.noisy_woman_20.create_mechanical_miners.blocks.AndesiteStressMinerBlock;
import com.simibubi.create.content.kinetics.base.KineticBlockEntityRenderer;
import dev.engine_room.flywheel.lib.model.baked.PartialModel;
import net.createmod.catnip.render.CachedBuffers;
import net.createmod.catnip.render.SuperByteBuffer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import org.jetbrains.annotations.NotNull;

public class AndesiteStressMinerRenderer extends KineticBlockEntityRenderer<AndesiteStressMinerBlockEntity> {
	public AndesiteStressMinerRenderer(BlockEntityRendererProvider.Context context) {
		super(context);
	}

	protected SuperByteBuffer getRotatedModel(@NotNull AndesiteStressMinerBlockEntity be, @NotNull BlockState state) {
		PartialModel model;

		if (state.getValue(AndesiteStressMinerBlock.HALF) == DoubleBlockHalf.UPPER) {
			model = CMMPartialModels.ANDESITE_STRESS_MINER_HEAD_UPPER;
		} else {
			model = CMMPartialModels.ANDESITE_STRESS_MINER_HEAD_LOWER;
		}

		return CachedBuffers.partial(model, state);
	}
}