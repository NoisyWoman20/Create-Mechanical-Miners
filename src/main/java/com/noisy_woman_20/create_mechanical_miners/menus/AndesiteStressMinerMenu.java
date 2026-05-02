package com.noisy_woman_20.create_mechanical_miners.menus;

import com.noisy_woman_20.create_mechanical_miners.block_entities.AndesiteStressMinerBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.items.ItemStackHandler;
import net.neoforged.neoforge.items.SlotItemHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class AndesiteStressMinerMenu extends AbstractContainerMenu {
	private final AndesiteStressMinerBlockEntity blockEntity;

	public AndesiteStressMinerMenu(int containerId, Inventory playerInventory) {
		this(containerId, playerInventory, null);
	}

	public AndesiteStressMinerMenu(int containerId, Inventory playerInventory, @Nullable AndesiteStressMinerBlockEntity blockEntity) {
		super(CMMMenus.ANDESITE_STRESS_MINER_MENU.get(), containerId);

		this.blockEntity = blockEntity;

		if (blockEntity != null) {
			this.addSlot(new SlotItemHandler(blockEntity.itemHandler, 0, 78, 35));
		} else {
			this.addSlot(new SlotItemHandler(new ItemStackHandler(1), 0, 78, 35));
		}

		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 9; col++) {
				this.addSlot(new Slot(playerInventory, (col + row * 9 + 9), (8 + col * 18), (97 + row * 18)));
			}
		}
		for (int col = 0; col < 9; col++) {
			this.addSlot(new Slot(playerInventory, col, (8 + col * 18), 155));
		}
	}

	@Override
	public @NotNull ItemStack quickMoveStack(@NotNull Player player, int index) {
		Slot slot = this.slots.get(index);
		if (!slot.hasItem()) {
			return ItemStack.EMPTY;
		}

		ItemStack stackInSlot = slot.getItem();
		ItemStack copy = stackInSlot.copy();

		if (index == 0) {
			if (!this.moveItemStackTo(stackInSlot, 1, 37, true)) {
				return ItemStack.EMPTY;
			}
		}
		else if (!this.moveItemStackTo(stackInSlot, 0, 1, false)) {
			return ItemStack.EMPTY;
		}

		if (stackInSlot.isEmpty()) {
			slot.set(ItemStack.EMPTY);
		} else {
			slot.setChanged();
		}

		return copy;
	}

	@Override
	public boolean stillValid(@NotNull Player player) {
		if (blockEntity == null) {
			return true;
		}

		BlockPos pos = blockEntity.getBlockPos();
		return (player.distanceToSqr((pos.getX() + 0.5), (pos.getY() + 0.5), (pos.getZ() + 0.5)) <= 64.0);
	}

	public AndesiteStressMinerBlockEntity getBlockEntity() {
		return blockEntity;
	}
}