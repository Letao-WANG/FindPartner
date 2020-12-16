/**
 * Main display window
 * Build Robot, RobotPartner, MyEnv, World, WorldWindow, Simulator, AgentInspector
 * The game interface is displayed by WorldWindow
 * 
 * The player controls Robot through the arrow keys according to the WorldWindow to play the game
 * 
 * @author Jingyao FANG
 * @author Letao WANG
 * @version 1.2
 */

package View;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.vecmath.Vector3d;
import Controller.Controller;
import Model.Agent;
import Model.SimpleAgent;
import Model.Simulator;
import Model.World;

public class MainGUI extends JFrame implements KeyListener {

	// ATTRIBUTS
	Controller controller;
	World world;
	WorldWindow worldWindow;
	Simulator simulator;
	JDesktopPane desktop;
	AgentInspector agentInspector = null;

	/**
	 * Different views 
	 * VIEW_ABOVE_AGENT_NEAR for gaming operated by player
	 * VIEW_FROM_TOP for testing or overview
	 * 
	 * @param controller
	 */
	public MainGUI(Controller controller) {
		this.controller = controller;
		world = controller.getWorld();
		simulator = new Simulator(desktop, world, controller.getEd(), 0, false);
		desktop = new JDesktopPane();
		getContentPane().add(desktop);

		worldWindow = new WorldWindow(world);
		this.add(worldWindow);
		worldWindow.setRequestFocusEnabled(true);
		worldWindow.show();
		worldWindow.setLocation(300, 20);
		worldWindow.setBorder(null);

		AgentFollower agentFollower;
		agentFollower = new AgentFollower(world, controller.getRobot());

		agentFollower.setViewPointType(World.VIEW_ABOVE_AGENT_NEAR);
		// agentFollower.setViewPointType(World.VIEW_FROM_TOP);
		agentFollower.resume();

		setSize(1200, 800);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setAutoRequestFocus(true);
		this.setFocusable(false);
		desktop.setFocusable(true);
		desktop.addKeyListener(this);
		worldWindow.setFocusable(false);
		// frame.setFocusable(false);
	}

	private AgentInspector createAgentInspector(Simulator simulator, int x, int y) {
		ArrayList agents = simulator.getAgentList();
		SimpleAgent a = ((SimpleAgent) agents.get(0));
		if (a instanceof Agent) {
			AgentInspector ai = new AgentInspector((Agent) a, true, simulator);
			desktop.add(ai);
			ai.show();
			ai.setLocation(x, y);
			return ai;
		} else
			return null;
	}

	/**
	 * The game starts when the player presses any build Use the arrow keys to
	 * control the movement of Robot Send robotStart signal is true to Simulator
	 * 
	 * Attention : robotStart is only valid for class Robot !
	 * 
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		// Game starts
		simulator.startSimulation();
		int keyCode = e.getKeyCode();

		// Use the arrow keys to control the movement of Robot and send robotStart
		// signal is true to Simulator
		switch (keyCode) {
		case KeyEvent.VK_LEFT:
			simulator.setDirection(1);
			simulator.setRobotStart(true);
			break;
		case KeyEvent.VK_UP:
			simulator.setDirection(3);
			simulator.setRobotStart(true);
			break;
		case KeyEvent.VK_DOWN:
			simulator.setDirection(2);
			simulator.setRobotStart(true);
			break;
		case KeyEvent.VK_RIGHT:
			simulator.setDirection(0);
			simulator.setRobotStart(true);
			break;
		}
	}

	/**
	 * Send robotStart signal is false to Simulator
	 * 
	 * Attention : robotStart is only valid for class Robot !
	 */
	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		simulator.setRobotStart(false);
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

}
