package com.noisy_woman_20.create_mechanical_miners.ponders;

import com.simibubi.create.content.kinetics.base.KineticBlockEntity;
import net.createmod.ponder.api.scene.SceneBuilder;
import net.createmod.ponder.api.scene.SceneBuildingUtil;
import net.minecraft.core.Direction;
import org.jetbrains.annotations.NotNull;

public class AndesiteStressMinerScene {
	public static void scene(@NotNull SceneBuilder scene, @NotNull SceneBuildingUtil util) {
		scene.title("andesite_stress_miner", "Mine it with an Andesite Stress Miner");
		scene.configureBasePlate(0, 0, 5);

		scene.world().showSection(util.select().layer(0).substract(util.select().position(1, 0, 5)), Direction.UP);
		scene.idleSeconds(1);

		scene.overlay()
			.showText(80)
			.text("This is a Diamond Vein")
			.attachKeyFrame()
			.pointAt(util.vector().blockSurface(util.grid().at(2, 0, 2), Direction.UP))
			.placeNearTarget();
		scene.idle(80);
		scene.idle(10);
		scene.overlay()
			.showText(80)
			.text("It can be mined with an Andesite Stress Miner")
			.pointAt(util.vector().blockSurface(util.grid().at(2, 0, 2), Direction.UP))
			.placeNearTarget();
		scene.idle(80);

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
			.showText(80)
			.text("Mined ores are stored in the Andesite Stress Miner's internal inventory")
			.pointAt(util.vector().blockSurface(util.grid().at(2, 2, 2), Direction.UP))
			.attachKeyFrame()
			.placeNearTarget();
		scene.idle(80);
	}
}