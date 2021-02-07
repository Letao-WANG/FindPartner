package Model;

import javax.vecmath.Vector3d;
import Controller.Controller;
import Model.Agent;
import Model.Robot;
import Model.SimpleAgent;

/**
 * Robot partner sought by robot  controlled by player
 * Not moving, waiting for the player to rescue
 * 
 * @author Letao WANG
 */


public class RobotPartner extends Agent {

	Controller controller;
	
	public RobotPartner(Vector3d position, String name, Controller controller) {
		super(position, name);
		this.controller = controller;
	}

	public void initBehavior() {
	}

	
	/**
	 * If found by the player, the game wins
	 */
	public void performBehavior() {
		SimpleAgent agent = getVeryNearAgent();
		if (agent instanceof Robot) {
			this.detach();
			controller.disposeGame();
			controller.ShowSuccessMessage();
		}
	}
}