package com.noisy_woman_20.create_mechanical_miners.ponders;

import com.simibubi.create.content.kinetics.base.KineticBlockEntity;
import com.simibubi.create.content.logistics.funnel.FunnelBlockEntity;
import com.simibubi.create.foundation.ponder.CreateSceneBuilder;
import net.createmod.ponder.api.scene.SceneBuilder;
import net.createmod.ponder.api.scene.SceneBuildingUtil;
import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import org.jetbrains.annotations.NotNull;

public class BrassStressMinerScene {
	public static void scene(@NotNull SceneBuilder builder, @NotNull SceneBuildingUtil util) {
		CreateSceneBuilder scene = new CreateSceneBuilder(builder);

		scene.title("brass_stress_miner", "使用黄铜应力矿机来开采高级矿物");
		scene.configureBasePlate(0, 0, 5);

		scene.world().showSection(util.select().layer(0).substract(util.select().position(1, 0, 5)), Direction.UP);

		scene.idleSeconds(1);

		scene.overlay()
			.showText(60)
			.text("有些时候，你可能在矿洞中发现更高级的矿脉")
			.pointAt(util.vector().blockSurface(util.grid().at(2, 0, 2), Direction.UP))
			.attachKeyFrame()
			.placeNearTarget();
		scene.idle(60);

		scene.idle(10);

		scene.world().showSection(util.select().position(1, 0, 5), Direction.DOWN);
		scene.world().modifyBlockEntity(util.grid().at(1, 0, 5), KineticBlockEntity.class, be -> be.setSpeed(-32f));
		scene.idle(2);
		scene.world().showSection(util.select().position(2, 1, 5), Direction.DOWN);
		scene.world().modifyBlockEntity(util.grid().at(2, 1, 5), KineticBlockEntity.class, be -> be.setSpeed(64f));
		scene.idle(2);
		scene.world().showSection(util.select().position(2, 1, 4), Direction.DOWN);
		scene.world().modifyBlockEntity(util.grid().at(2, 1, 4), KineticBlockEntity.class, be -> be.setSpeed(-64f));
		scene.idle(2);
		scene.world().showSection(util.select().position(2, 2, 4), Direction.DOWN);
		scene.world().modifyBlockEntity(util.grid().at(2, 2, 4), KineticBlockEntity.class, be -> be.setSpeed(-64f));
		scene.idle(2);
		scene.world().showSection(util.select().position(2, 3, 4), Direction.DOWN);
		scene.world().modifyBlockEntity(util.grid().at(2, 3, 4), KineticBlockEntity.class, be -> be.setSpeed(64f));
		scene.idle(2);
		scene.world().showSection(util.select().position(2, 3, 3), Direction.DOWN);
		scene.world().modifyBlockEntity(util.grid().at(2, 3, 3), KineticBlockEntity.class, be -> be.setSpeed(64f));
		scene.idle(2);
		scene.world().showSection(util.select().position(2, 3, 2), Direction.DOWN);
		scene.world().modifyBlockEntity(util.grid().at(2, 3, 2), KineticBlockEntity.class, be -> be.setSpeed(-64f));
		scene.idle(2);
		scene.world().showSection(util.select().position(2, 1, 2), Direction.DOWN);
		scene.world().modifyBlockEntity(util.grid().at(2, 1, 2), KineticBlockEntity.class, be -> be.setSpeed(64f));
		scene.world().showSection(util.select().position(2, 2, 2), Direction.DOWN);
		scene.world().modifyBlockEntity(util.grid().at(2, 2, 2), KineticBlockEntity.class, be -> be.setSpeed(64f));

		scene.idleSeconds(1);

		scene.overlay()
			.showText(60)
			.text("这些高级矿脉需要用黄铜应力矿机开采")
			.pointAt(util.vector().blockSurface(util.grid().at(2, 0, 2), Direction.UP))
			.attachKeyFrame()
			.placeNearTarget();
		scene.idle(60);

		scene.idle(10);

		scene.world().showSection(util.select().position(0, 1, 5), Direction.DOWN);
		scene.world().modifyBlockEntity(util.grid().at(0, 1, 5), KineticBlockEntity.class, be -> be.setSpeed(64f));
		scene.idle(2);
		scene.world().showSection(util.select().position(0, 1, 4), Direction.DOWN);
		scene.world().modifyBlockEntity(util.grid().at(0, 1, 4), KineticBlockEntity.class, be -> be.setSpeed(64f));
		scene.idle(2);
		scene.world().showSection(util.select().position(0, 1, 3), Direction.DOWN);
		scene.world().modifyBlockEntity(util.grid().at(0, 1, 3), KineticBlockEntity.class, be -> be.setSpeed(64f));
		scene.idle(2);
		scene.world().showSection(util.select().position(0, 1, 2), Direction.DOWN);
		scene.world().modifyBlockEntity(util.grid().at(0, 1, 2), KineticBlockEntity.class, be -> be.setSpeed(64f));
		scene.world().showSection(util.select().position(1, 1, 2), Direction.DOWN);
		scene.world().modifyBlockEntity(util.grid().at(1, 1, 2), KineticBlockEntity.class, be -> be.setSpeed(64f));
		scene.idle(2);
		scene.world().showSection(util.select().position(1, 2, 2), Direction.DOWN);

		scene.idleSeconds(1);

		scene.overlay()
			.showText(60)
			.text("别忘了用漏斗和传送带把矿物及时提取出来")
			.pointAt(util.vector().blockSurface(util.grid().at(1, 2, 2), Direction.UP))
			.attachKeyFrame()
			.placeNearTarget();
		scene.idle(60);

		scene.idle(10);

		scene.world().modifyBlockEntity(util.grid().at(1, 2, 2), FunnelBlockEntity.class, be -> be.flap(false));
		scene.world().createItemOnBelt(util.grid().at(1, 1, 2), Direction.EAST, new ItemStack(Items.DIAMOND));
		scene.idle(10);
		scene.world().modifyBlockEntity(util.grid().at(1, 2, 2), FunnelBlockEntity.class, be -> be.flap(false));
		scene.world().createItemOnBelt(util.grid().at(1, 1, 2), Direction.EAST, new ItemStack(Items.DIAMOND));
		scene.idle(10);
		scene.world().modifyBlockEntity(util.grid().at(1, 2, 2), FunnelBlockEntity.class, be -> be.flap(false));
		scene.world().createItemOnBelt(util.grid().at(1, 1, 2), Direction.EAST, new ItemStack(Items.DIAMOND));
		scene.idle(10);
		scene.world().modifyBlockEntity(util.grid().at(1, 2, 2), FunnelBlockEntity.class, be -> be.flap(false));
		scene.world().createItemOnBelt(util.grid().at(1, 1, 2), Direction.EAST, new ItemStack(Items.DIAMOND));
		scene.idle(10);
		scene.world().modifyBlockEntity(util.grid().at(1, 2, 2), FunnelBlockEntity.class, be -> be.flap(false));
		scene.world().createItemOnBelt(util.grid().at(1, 1, 2), Direction.EAST, new ItemStack(Items.DIAMOND));
		scene.idle(10);
		scene.world().modifyBlockEntity(util.grid().at(1, 2, 2), FunnelBlockEntity.class, be -> be.flap(false));
		scene.world().createItemOnBelt(util.grid().at(1, 1, 2), Direction.EAST, new ItemStack(Items.DIAMOND));
		scene.idle(10);
		scene.world().modifyBlockEntity(util.grid().at(1, 2, 2), FunnelBlockEntity.class, be -> be.flap(false));
		scene.world().createItemOnBelt(util.grid().at(1, 1, 2), Direction.EAST, new ItemStack(Items.DIAMOND));
		scene.idle(10);
		scene.world().modifyBlockEntity(util.grid().at(1, 2, 2), FunnelBlockEntity.class, be -> be.flap(false));
		scene.world().createItemOnBelt(util.grid().at(1, 1, 2), Direction.EAST, new ItemStack(Items.DIAMOND));
		scene.idle(10);
		scene.world().modifyBlockEntity(util.grid().at(1, 2, 2), FunnelBlockEntity.class, be -> be.flap(false));
		scene.world().createItemOnBelt(util.grid().at(1, 1, 2), Direction.EAST, new ItemStack(Items.DIAMOND));
		scene.idle(10);
		scene.world().modifyBlockEntity(util.grid().at(1, 2, 2), FunnelBlockEntity.class, be -> be.flap(false));
		scene.world().createItemOnBelt(util.grid().at(1, 1, 2), Direction.EAST, new ItemStack(Items.DIAMOND));
		scene.idle(10);
	}
}