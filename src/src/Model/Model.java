/**
 * Manage Robot, RobotPartner, EnvironmentDescription, World and transfer data to MainGUI
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

	public Model(Controller controller) {
		this.controller = controller;
		robot = new Robot(new Vector3d(8.5, 0, 8), "Robot", controller);
		robot.setColor(new Color3f(1f, 1f, 1f));
		robotPartner = new RobotPartner(new Vector3d(-7.5, 0, -7), "RobotPartner", controller);
		robotPartner.setColor(new Color3f(1f, 1f, 1f));
		ed = new MyEnv(robot, robotPartner);
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

}
