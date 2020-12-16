/**
 * Robot controlled by the player
 * Avoid hostile robots and find robot partner
 * 
 * @author Letao WANG
 */

package Model;

import javax.vecmath.Vector3d;
import Controller.Controller;
import Model.Agent;
import Model.RangeSensorBelt;
import Model.RobotFactory;
import Model.SimpleAgent;

public class Robot extends Agent {

	RangeSensorBelt sonars;
	Controller controller;

	public Robot(Vector3d position, String name, Controller controller) {
		super(position, name);
		// Add sonars
		sonars = RobotFactory.addSonarBeltSensor(this);
		this.controller = controller;
	}

	/** This method is called by the simulator engine on reset. */
	public void initBehavior() {
		// nothing particular in this case
	}

	/**
	 * If touch a hostile robot, the game will fail
	 */
	public void performBehavior() {
		setTranslationalVelocity(2);
		if (anOtherAgentIsVeryNear()) {
			SimpleAgent agent = getVeryNearAgent();
			if (agent instanceof RobotHostile) {
				agent.detach();
				controller.disposeMain();
				controller.ShowFailureMessage();

			}
		}
	}
}