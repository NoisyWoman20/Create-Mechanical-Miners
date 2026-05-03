package com.noisy_woman_20.create_mechanical_miners.visuals;

import com.noisy_woman_20.create_mechanical_miners.CMMPartialModels;
import com.noisy_woman_20.create_mechanical_miners.block_entities.AndesiteStressMinerBlockEntity;
import com.noisy_woman_20.create_mechanical_miners.blocks.AndesiteStressMinerBlock;
import com.simibubi.create.content.kinetics.base.SingleAxisRotatingVisual;
import dev.engine_room.flywheel.api.visualization.VisualizationContext;
import dev.engine_room.flywheel.lib.model.Models;
import dev.engine_room.flywheel.lib.model.baked.PartialModel;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public class AndesiteStressMinerVisual extends SingleAxisRotatingVisual<AndesiteStressMinerBlockEntity> {
	private int retryDelay = 0;
	private final boolean isUpper;

	public AndesiteStressMinerVisual(VisualizationContext context, AndesiteStressMinerBlockEntity blockEntity, float partialTick) {
		super(context, blockEntity, partialTick, Models.partial(getModel(blockEntity)));
		isUpper = (blockEntity.getBlockState().getValue(AndesiteStressMinerBlock.HALF) == DoubleBlockHalf.UPPER);
	}

	@Contract(pure = true)
	private static PartialModel getModel(@NotNull AndesiteStressMinerBlockEntity be) {
		PartialModel model;

		if (be.getBlockState().getValue(AndesiteStressMinerBlock.HALF) == DoubleBlockHalf.UPPER) {
			model = CMMPartialModels.ANDESITE_STRESS_MINER_HEAD_UPPER;
		} else {
			model = CMMPartialModels.ANDESITE_STRESS_MINER_HEAD_LOWER;
		}

		return model;
	}

	@Override
	public void tick(Context context) {
		BlockPos abovePos = this.blockEntity.getBlockPos().above();
		if (!isUpper && this.blockEntity.getLevel() != null && ++retryDelay >= 5) {
			BlockEntity above = this.blockEntity.getLevel().getBlockEntity(abovePos);
			if (above instanceof AndesiteStressMinerBlockEntity upper) {
				rotatingModel.setup(upper);
				rotatingModel.setChanged();
			} else {
				rotatingModel.setup(blockEntity);
				rotatingModel.setChanged();
			}
			retryDelay = 0;
		}

		super.tick(context);
	}
}