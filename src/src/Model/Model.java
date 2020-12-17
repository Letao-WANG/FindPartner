/**
 * Manage Robot, RobotPartner, EnvironmentDescription, World and transfer data to Game
 * 
 * @author Letao WANG
 */

package Model;

import javax.vecmath.Color3f;
import javax.vecmath.Vector3d;
import Controller.Controller;

public class Model {
	
	Controller controller;
	Robot robot;
	RobotPartner robotPartner;
	EnvironmentDescription ed;
	World world;
	int level;

	public Model(Controller controller, int level) {
		this.controller = controller;
		this.level = level;
		robot = new Robot(new Vector3d(8.5, 0, 8), "Robot", controller);
		robot.setColor(new Color3f(1f, 1f, 1f));
		robotPartner = new RobotPartner(new Vector3d(-7.5, 0, -7), "RobotPartner", controller);
		robotPartner.setColor(new Color3f(1f, 1f, 1f));
		ed = new MyEnv(robot, robotPartner, level);
		world = new World(ed);
	}

	public Controller getController() {
		return controller;
	}

	public Robot getRobot() {
		return robot;
	}

	public RobotPartner getRobotPartner() {
		return robotPartner;
	}

	public EnvironmentDescription getEd() {
		return ed;
	}

	public World getWorld() {
		return world;
	}
	
	public int getLevel() {
		return level;
	}
	
	/*public void updateLevel(int level) {
		this.level = level;
		ed = new MyEnv(robot, robotPartner, level);
		world = new World(ed);
	}*/

}
