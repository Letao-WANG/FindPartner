package Controller;

import Model.EnvironmentDescription;
import Model.Model;
import Model.Robot;
import Model.RobotPartner;
import Model.World;
import View.MainView;

/**
 * Main control program, connect View(GUI), Model(Modele)
 * Realize the connection between multiple windows
 * 
 * @author Jingyao FANG
 * @author Letao WANG
 */

public class Controller {
	int level;
	int viewType;
	Model model;
	MainView mainView;
	/**
	 * Create model and game
	 */
	public Controller() {
		// level is 1 by default 
		level = 1;
		//point of view by default
		viewType = World.VIEW_FROM_TOP;
		
		model = new Model(this, level);
		mainView = new MainView(this);
	}
	
	public void disposeGame() {
		mainView.disposeGame();
	}
	
	/**
	 * Open game window
	 */
	public void showGame() {
		model = new Model(this, level);
		mainView.showGame();
	}
	
	/**
	 * Open game menu
	 */
	public void showMenu() {
		mainView.showMenu();;
	}
	
	/**
	 * @return game difficulty level
	 */
	public int getLevel() {
		return this.level;
	}
	
	/**
	 * Set game difficulty level
	 * @param level game difficulty level
	 */
	public void setLevel(int level) {
		this.level = level;
	}
	
	/**
	 * End the program
	 */
	public void Quit() {
		System.exit(0);
	}

	/**
	 * @return Robot (white) which is controled by player
	 */
	public Robot getRobot() {
		return model.getRobot();
	}

	/**
	 * @return RobotPartner (white) which player aimed to rescue
	 */
	public RobotPartner getRobotPartner() {
		return model.getRobotPartner();
	}

	/**
	 * Get EnvironmentDescription
	 * @return MyEnv for this program
	 */
	public EnvironmentDescription getEd() {
		return model.getEd();
	}
	
	/**
	 * Set the game perspective
	 * @param viewType game perspective
	 */
	public void setViewType(int viewType) {
		this.viewType = viewType;
	}
	
	/**
	 * @return game perspective
	 */
	public int getViewType() {
		return viewType;
	}

	/**
	 * @return the world we describe
	 */
	public World getWorld() {
		return model.getWorld();
	}
	
	/**
	 * Close failure message
	 */
	public void disposeFailureMessage() {
		mainView.disposeFailureMessage();
	}
	
	/**
	 * Close success message
	 */
	public void disposeSuccessMessage() {
		mainView.disposeSuccessMessage();
	}
	
	/**
	 * Open failure message
	 */
	public void ShowFailureMessage() {
		mainView.ShowFailureMessage();
	}
	
	/**
	 * Open success message
	 */
	public void ShowSuccessMessage() {
		mainView.ShowSuccessMessage();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Controller();
	}

}
