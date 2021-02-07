package Model;

import java.awt.Color;
import java.awt.image.BufferedImage;
import javax.vecmath.Vector3d;
import Model.Agent;
import Model.RangeSensorBelt;
import Model.RobotFactory;

/**
 * Robot partner sought by robot  controlled by player
 * Move slowly as close as possible to Robot or move without touching the wall
 * 
 * @author Letao WANG
 */

public class RobotHostile extends Agent {

	RangeSensorBelt sonars;
	CameraSensor camera;
	BufferedImage cameraImage;
	final int WHITE;

	public RobotHostile(Vector3d position, String name) {
		super(position, name);
		sonars = RobotFactory.addSonarBeltSensor(this, 8);
		camera = RobotFactory.addCameraSensor(this);
		cameraImage = camera.createCompatibleImage();
		//Color of Robot
		WHITE = new Color(255, 255, 255).getRGB();
	}

	public void initBehavior() {
	}

	/**
	 * Move slowly
	 * There are two situations:
	 * 
	 * If the camera of the RobotHostile finds Robot, it will move as close as possible to Robot
	 * If Robot is not found, RobotHostile will continue to avoid the wall
	 */
	public void performBehavior() {

		int X = -1;

		cameraImage = camera.getVisionImage();
		for (int y = 0; y < cameraImage.getHeight(); y++) {
			for (int x = 0; x < cameraImage.getWidth(); x++) {
				if (cameraImage.getRGB(x, y) == WHITE)
					X = x;
			}
		}

		//move as close as possible to Robot
		if (X != -1) {
			if (X < cameraImage.getWidth() * 0.75 && X > cameraImage.getWidth() * 0.25)
				setRotationalVelocity(0);
			else if (X > cameraImage.getWidth() * 0.75)
				setRotationalVelocity(-3);
			else if (X < cameraImage.getWidth() * 0.25)
				setRotationalVelocity(3);
		}
		//avoid the wall
		else {
			setTranslationalVelocity(0.4);
			double left = sonars.getFrontLeftQuadrantMeasurement();
			double right = sonars.getFrontRightQuadrantMeasurement();
			double front = sonars.getFrontQuadrantMeasurement();
			if ((front < 1) || (left < 1) || (right < 1)) {
				if (left < right)
					setRotationalVelocity(-5);
				else
					setRotationalVelocity(5);
			}
		}
	}
}