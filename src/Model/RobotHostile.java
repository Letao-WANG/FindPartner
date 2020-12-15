/**
 * Robot partner sought by robot  controlled by player
 * Move slowly without touching the wall
 * 
 * @author Letao WANG
 */

package Model;

import javax.vecmath.Vector3d;

import Model.Agent;
import Model.RangeSensorBelt;
import Model.RobotFactory;

public class RobotHostile extends Agent {

	RangeSensorBelt sonars;

	public RobotHostile(Vector3d position, String name) {
		super(position, name);
		sonars = RobotFactory.addSonarBeltSensor(this, 8);
	}

	public void initBehavior() {
	}

	/**
	 * Move slowly without touching the wall
	 */
	public void performBehavior() {
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