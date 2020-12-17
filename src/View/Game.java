/**
 * Main game window
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

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import Controller.Controller;
import Model.Simulator;
import Model.World;
import javax.swing.JTextPane;

public class Game extends JFrame implements KeyListener {

	// ATTRIBUTS
	Controller controller;
	World world;
	WorldWindow worldWindow;
	Simulator simulator;
	JDesktopPane desktop;
	AgentInspector agentInspector = null;
	
	JButton btnMenu;
	
	public Game(Controller controller) {
		getContentPane().setLayout(null);
		this.controller = controller;
		world = controller.getWorld();
		simulator = new Simulator(desktop, world, controller.getEd(), 0, false);
		desktop = new JDesktopPane();
		getContentPane().add(desktop);
		desktop.setLayout(null);

		// part of WorldWindow
		worldWindow = new WorldWindow(world, controller);
		worldWindow.setBounds(200, 0, 1200, 800);
		desktop.add(worldWindow);
		desktop.setBounds(0, 0, 1200, 800);
		worldWindow.setRequestFocusEnabled(true);
		worldWindow.show();
		worldWindow.setBorder(null);

		// part of AgentFollower
		AgentFollower agentFollower;
		agentFollower = new AgentFollower(world, controller.getRobot());
		agentFollower.setViewPointType(controller.getViewType());
		agentFollower.resume();

		setSize(1200, 800);
		setLocation(100,100);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		desktop.setFocusable(true);
		desktop.addKeyListener(this);
		btnMenu = new JButton("Menu");
		btnMenu.setBounds(20, 20, 100, 30);
		desktop.add(btnMenu);
		
		JTextPane txtpnArrowKeysControl = new JTextPane();
		txtpnArrowKeysControl.setText("Arrow keys control robot movement.\n\nYou control the robot to move and rescue your white RobotPartner, but you cannot touch the black RobotHostile.\n\nBe careful not to click on the window with the mouse, otherwise the keyboard signal cannot be obtained.\n\nBon courage !");
		txtpnArrowKeysControl.setBounds(20, 77, 155, 382);
		desktop.add(txtpnArrowKeysControl);
		btnMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.showMenu();
				dispose();
			}
		});
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
