package com.noisy_woman_20.create_mechanical_miners.block_entities;

import com.noisy_woman_20.create_mechanical_miners.CreateMechanicalMiners;
import com.noisy_woman_20.create_mechanical_miners.blocks.CMMBlocks;
import com.noisy_woman_20.create_mechanical_miners.blocks.AndesiteStressMinerBlock;
import com.simibubi.create.content.kinetics.base.KineticBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.Containers;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.items.ItemHandlerHelper;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class AndesiteStressMinerBlockEntity extends KineticBlockEntity { //implements MenuProvider {
	private int speedUpdateTimer = 0;
	private int mineTimer = 0;

	private NonNullList<ItemStack> items = NonNullList.withSize(1, ItemStack.EMPTY);

	public final IItemHandler itemHandler = new ItemHandler();

	private class ItemHandler implements IItemHandler {
		@Override
		public int getSlots() {
			return items.size();
		}

		@Override
		public @NotNull ItemStack getStackInSlot(int slot) {
			return slot == 0 ? items.get(slot) : ItemStack.EMPTY;
		}

		@Override
		public @NotNull ItemStack insertItem(int slot, @NotNull ItemStack stack, boolean simulate) {
			if (slot != 0 || stack.isEmpty()) return stack;
			if (!isItemValid(slot, stack)) return stack;

			ItemStack existing = items.getFirst();
			int limit = Math.min(getSlotLimit(slot), stack.getMaxStackSize());

			if (!existing.isEmpty()) {
				if (!ItemStack.isSameItemSameComponents(stack, existing))
					return stack;
				limit -= existing.getCount();
			}

			if (limit <= 0) return stack;

			int toInsert = Math.min(limit, stack.getCount());

			if (!simulate) {
				if (existing.isEmpty()) {
					items.set(0, stack.copyWithCount(toInsert));
				} else {
					existing.grow(toInsert);
				}
				setChanged();
			}

			if (toInsert >= stack.getCount()) return ItemStack.EMPTY;
			return stack.copyWithCount(stack.getCount() - toInsert);
		}

		@Override
		public @NotNull ItemStack extractItem(int slot, int amount, boolean simulate) {
			if (slot != 0 || amount <= 0 || items.getFirst().isEmpty())
				return ItemStack.EMPTY;

			int toExtract = Math.min(amount, items.getFirst().getCount());
			ItemStack extracted = items.getFirst().copyWithCount(toExtract);

			if (!simulate) {
				items.getFirst().shrink(toExtract);
				setChanged();
			}

			return extracted;
		}

		@Override
		public int getSlotLimit(int slot) {
			return 64;
		}

		@Override
		public boolean isItemValid(int slot, @NotNull ItemStack itemStack) {
			return (slot == 0);
		}
	}

	public AndesiteStressMinerBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
		super(type, pos, state);
	}

	@Override
	public float calculateStressApplied() {
		this.lastStressApplied = 256f;
		return this.lastStressApplied;
	}

	@Override
	public float getSpeed() {
		if (getBlockState().getValue(AndesiteStressMinerBlock.HALF) == DoubleBlockHalf.LOWER && level != null) {
			BlockEntity above = level.getBlockEntity(getBlockPos().above());
			if (above instanceof AndesiteStressMinerBlockEntity upper) {
				return upper.getSpeed();
			}
			return 0f;
		}
		return super.getSpeed();
	}

	@Override
	public float getTheoreticalSpeed() {
		if (getBlockState().getValue(AndesiteStressMinerBlock.HALF) == DoubleBlockHalf.LOWER && level != null) {
			BlockEntity above = level.getBlockEntity(getBlockPos().above());
			if (above instanceof AndesiteStressMinerBlockEntity upper) {
				return upper.getTheoreticalSpeed();
			}
			return 0f;
		}
		return super.getTheoreticalSpeed();
	}

	@Override
	public boolean isOverStressed() {
		if (getBlockState().getValue(AndesiteStressMinerBlock.HALF) == DoubleBlockHalf.LOWER && level != null) {
			BlockEntity above = level.getBlockEntity(getBlockPos().above());
			if (above instanceof AndesiteStressMinerBlockEntity upper) {
				return upper.isOverStressed();
			}
			return false;
		}
		return super.isOverStressed();
	}

	@Override
	public void setSpeed(float speed) {
		if (getBlockState().getValue(AndesiteStressMinerBlock.HALF) == DoubleBlockHalf.UPPER && level != null) {
			BlockEntity below = level.getBlockEntity(getBlockPos().below());
			if (below instanceof AndesiteStressMinerBlockEntity lower) {
				lower.setSpeed(speed);
			}
		}
		super.setSpeed(speed);
	}

	@Override
	public boolean addToGoggleTooltip(List<Component> tooltip, boolean isPlayerSneaking) {
		return super.addToGoggleTooltip(tooltip, isPlayerSneaking);
	}

	@Override
	public void tick() {
		super.tick();

		updateSpeed();
		mine();
	}

	private void updateSpeed() {
		if (getBlockState().getValue(AndesiteStressMinerBlock.HALF) == DoubleBlockHalf.UPPER) {
			return;
		}

		if (level == null || level.isClientSide()) {
			return;
		}

		BlockState above = level.getBlockState(getBlockPos().above());

		if (
			above.is(CMMBlocks.ANDESITE_STRESS_MINER_BLOCK) &&
			above.getValue(AndesiteStressMinerBlock.HALF) == DoubleBlockHalf.UPPER &&
			++speedUpdateTimer >= 5
		) {
			super.setSpeed(getTheoreticalSpeed());
			overStressed = isOverStressed();
			speedUpdateTimer = 0;
		}
	}

	private void mine() {
		if (getBlockState().getValue(AndesiteStressMinerBlock.HALF) == DoubleBlockHalf.LOWER) {
			return;
		}

		if (level == null || level.isClientSide()) {
			return;
		}

		float speed = Math.abs(getSpeed());

		if (speed <= 0) {
			return;
		}

		Item veinDrop;
		BlockState below = level.getBlockState(getBlockPos().below(2));
		if (below.is(CMMBlocks.DIAMOND_VEIN_BLOCK) || below.is(CMMBlocks.DEEPSLATE_DIAMOND_VEIN_BLOCK)) {
			veinDrop = Items.DIAMOND;
		} else {
			return;
		}

		int mineCooldown = (int)(5120f / speed);

		if (++mineTimer >= mineCooldown) {
			CreateMechanicalMiners.LOGGER.debug("mine!\n    mine cooldown: {}s\n    vein type: {}", mineCooldown / 20, veinDrop.getName(new ItemStack(veinDrop)));
			mineTimer = 0;
		}
	}

	@Override
	protected void write(CompoundTag compound, HolderLookup.Provider registries, boolean clientPacket) {
		super.write(compound, registries, clientPacket);
		ContainerHelper.saveAllItems(compound, items, registries);
	}

	@Override
	protected void read(CompoundTag compound, HolderLookup.Provider registries, boolean clientPacket) {
		super.read(compound, registries, clientPacket);
		items = NonNullList.withSize(1, ItemStack.EMPTY);
		ContainerHelper.loadAllItems(compound, items, registries);
	}

	public void dropItem() {
		if (level == null) {
			return;
		}

		if (level.isClientSide()) {
			return;
		}

		if (getBlockState().getValue(AndesiteStressMinerBlock.HALF) == DoubleBlockHalf.LOWER) {
			BlockEntity above = level.getBlockEntity(getBlockPos().above());
			if (above instanceof AndesiteStressMinerBlockEntity upper) {
				upper.dropItem();
			}
			return;
		}

		if (items.getFirst().isEmpty()) {
			return;
		}

		Containers.dropItemStack(level, worldPosition.below().getX(), worldPosition.below().getY(), worldPosition.below().getZ(), items.getFirst());
		items.set(0, ItemStack.EMPTY);
		setChanged();
	}
}