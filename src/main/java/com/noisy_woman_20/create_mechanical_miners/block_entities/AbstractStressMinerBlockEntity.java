package com.noisy_woman_20.create_mechanical_miners.block_entities;

import com.noisy_woman_20.create_mechanical_miners.blocks.AbstractStressMinerBlock;
import com.noisy_woman_20.create_mechanical_miners.blocks.AbstractVeinBlock;
import com.simibubi.create.content.kinetics.base.KineticBlockEntity;
import com.simibubi.create.foundation.utility.CreateLang;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.items.IItemHandlerModifiable;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractStressMinerBlockEntity extends KineticBlockEntity implements MenuProvider {
	protected int speedUpdateTimer = 0;
	protected int mineTimer = 0;
	protected double lastProgress = 0.0;

	protected NonNullList<ItemStack> items = NonNullList.withSize(1, ItemStack.EMPTY);
	public final IItemHandler itemHandler = new ItemHandler();

	protected class ItemHandler implements IItemHandler, IItemHandlerModifiable {
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

		@Override
		public void setStackInSlot(int slot, @NotNull ItemStack stack) {
			if (slot == 0) {
				items.set(0, stack);
				setChanged();
			}
		}
	}

	public AbstractStressMinerBlockEntity(BlockEntityType<?> typeIn, BlockPos pos, BlockState state) {
		super(typeIn, pos, state);
	}

	public abstract Class<? extends AbstractStressMinerBlock> getBlockClass();

	protected boolean isUpper() {
		return (getBlockState().getValue(AbstractStressMinerBlock.HALF) == DoubleBlockHalf.UPPER && getBlockState().getBlock().getClass().equals(getBlockClass()));
	}

	protected boolean isLower() {
		return (getBlockState().getValue(AbstractStressMinerBlock.HALF) == DoubleBlockHalf.LOWER && getBlockState().getBlock().getClass().equals(getBlockClass()));
	}

	protected void updateSpeed() {
		if (isUpper()) {
			return;
		}

		if (level == null) {
			return;
		}

		if (!(level.getBlockEntity(getBlockPos().above()) instanceof AbstractStressMinerBlockEntity upper)) {
			return;
		}

		if (!upper.getBlockClass().equals(getBlockClass())) {
			return;
		}

		if (++speedUpdateTimer >= 5) {
			super.setSpeed(getTheoreticalSpeed());
			overStressed = isOverStressed();
			speedUpdateTimer = 0;
		}
	}

	@Override
	public float getSpeed() {
		if (isUpper()) {
			return super.getSpeed();
		}

		if (level == null) {
			return 0f;
		}

		if (!(level.getBlockEntity(getBlockPos().above()) instanceof AbstractStressMinerBlockEntity upper)) {
			return 0f;
		}

		if (!upper.getBlockClass().equals(getBlockClass())) {
			return 0f;
		}

		return upper.getSpeed();
	}

	@Override
	public float getTheoreticalSpeed() {
		if (isUpper()) {
			return super.getTheoreticalSpeed();
		}

		if (level == null) {
			return 0f;
		}

		if (!(level.getBlockEntity(getBlockPos().above()) instanceof AbstractStressMinerBlockEntity upper)) {
			return 0f;
		}

		if (!upper.getBlockClass().equals(getBlockClass())) {
			return 0f;
		}

		return upper.getTheoreticalSpeed();
	}

	@Override
	public boolean isOverStressed() {
		if (isUpper()) {
			return false;
		}

		if (level == null) {
			return false;
		}

		if (!(level.getBlockEntity(getBlockPos().above()) instanceof AbstractStressMinerBlockEntity upper)) {
			return false;
		}

		if (!upper.getBlockClass().equals(getBlockClass())) {
			return false;
		}

		return upper.isOverStressed();
	}

	@Override
	public void updateFromNetwork(float maxStress, float currentStress, int networkSize) {
		if (isUpper()) {
			super.updateFromNetwork(maxStress, currentStress, networkSize);
		}
	}

	@Override
	public void setSpeed(float speed) {
		if (isLower()) {
			super.setSpeed(speed);
			return;
		}

		if (level == null) {
			super.setSpeed(speed);
			return;
		}

		if (!(level.getBlockEntity(getBlockPos().below()) instanceof AbstractStressMinerBlockEntity lower)) {
			super.setSpeed(speed);
			return;
		}

		if (!lower.getBlockClass().equals(getBlockClass())) {
			super.setSpeed(speed);
			return;
		}

		lower.setSpeed(speed);
		super.setSpeed(speed);
	}

	@Override
	public void tick() {
		super.tick();

		updateSpeed();
		mine();
	}

	protected void mine() {
		if (isLower()) {
			return;
		}

		if (level == null || level.isClientSide()) {
			return;
		}

		float speed = Math.abs(getSpeed());

		if (speed <= 0) {
			return;
		}

		Block below = level.getBlockState(getBlockPos().below(2)).getBlock();

		if (!(below instanceof AbstractVeinBlock veinBlock)) {
			return;
		}

		if (!isMineable(veinBlock)) {
			return;
		}

		Item veinDrop = veinBlock.getOutput();

		int mineCooldown = (int)(5120f / speed);
		if (++mineTimer >= mineCooldown) {
			itemHandler.insertItem(0, new ItemStack(veinDrop, 1), false);
			mineTimer = 0;

			lastProgress = 1.0;
		} else {
			lastProgress = Math.min(1.0, Math.max(0.0, (mineTimer / (5120.0 / speed))));
		}

		sendData();
	}

	public void dropItem() {
		if (level == null) {
			return;
		}

		if (level.isClientSide()) {
			return;
		}

		if (isLower()) {
			BlockEntity above = level.getBlockEntity(getBlockPos().above());

			if (!(above instanceof AbstractStressMinerBlockEntity upper)) {
				return;
			}

			if (!upper.getBlockClass().equals(getBlockClass())) {
				return;
			}

			upper.dropItem();
			return;
		}

		if (items.getFirst().isEmpty()) {
			return;
		}

		Containers.dropItemStack(level, worldPosition.below().getX(), worldPosition.below().getY(), worldPosition.below().getZ(), items.getFirst());
		items.set(0, ItemStack.EMPTY);
		setChanged();
	}

	@Override
	protected void write(CompoundTag compound, HolderLookup.Provider registries, boolean clientPacket) {
		super.write(compound, registries, clientPacket);
		ContainerHelper.saveAllItems(compound, items, registries);

		if (clientPacket) {
			compound.putDouble("LastProgress", lastProgress);
		}
	}

	@Override
	protected void read(CompoundTag compound, HolderLookup.Provider registries, boolean clientPacket) {
		super.read(compound, registries, clientPacket);
		items = NonNullList.withSize(1, ItemStack.EMPTY);
		ContainerHelper.loadAllItems(compound, items, registries);

		if (clientPacket && compound.contains("LastProgress")) {
			lastProgress = compound.getDouble("LastProgress");
		}
	}

	public abstract boolean isMineable(Block oreBlock);

	protected static final Map<Item, Integer> ORE_COLORS = new HashMap<>();

	static {
		ORE_COLORS.put(Items.RAW_IRON, 0xd9b68b);
		ORE_COLORS.put(Items.RAW_COPPER, 0xe07c3c);
		ORE_COLORS.put(Items.RAW_GOLD, 0xf5c842);
		ORE_COLORS.put(Items.DIAMOND, 0x55ffff);
	}

	@Override
	public boolean addToGoggleTooltip(List<Component> tooltip, boolean isPlayerSneaking) {
		boolean added = super.addToGoggleTooltip(tooltip, isPlayerSneaking);

		if (level == null) {
			return added;
		}

		AbstractStressMinerBlockEntity miner = this;
		if (
			isLower() &&
			level.getBlockEntity(getBlockPos().above()) instanceof AbstractStressMinerBlockEntity upper &&
			upper.getBlockClass().equals(getBlockClass())
		) {
			miner = upper;
		}
		if (miner.isLower()) {
			return added;
		}

		Block below = level.getBlockState(miner.getBlockPos().below(2)).getBlock();
		if (!(below instanceof AbstractVeinBlock veinBlock)) {
			return added;
		}

		CreateLang.builder().add(Component.literal("")).forGoggles(tooltip);

		if (!isMineable(veinBlock)) {
			CreateLang.builder()
				.add(Component.translatable("gui.goggles.stress_miner.incompatible_ore").withStyle(ChatFormatting.RED))
				.forGoggles(tooltip);

			return added;
		}

		int mined = (int)Math.round((miner.lastProgress * 32));

		CreateLang.builder()
			.add(Component.translatable("gui.goggles.stress_miner.currently_mining").withStyle(ChatFormatting.GRAY))
			.add(Component.translatable(veinBlock.getOutput().getDescriptionId()).withColor(ORE_COLORS.getOrDefault(veinBlock.getOutput(), 0xffffff)))
			.forGoggles(tooltip);
		CreateLang.builder()
			.add(Component.translatable("gui.goggles.stress_miner.mining_progress").withStyle(ChatFormatting.GRAY))
			.add(Component.literal("[").withStyle(ChatFormatting.GRAY))
			.add(Component.literal("|".repeat(mined)).withStyle(ChatFormatting.GRAY))
			.add(Component.literal("|".repeat((32 - mined))).withStyle(ChatFormatting.DARK_GRAY))
			.add(Component.literal("]").withStyle(ChatFormatting.GRAY))
			.forGoggles(tooltip);

		return added;
	}
}