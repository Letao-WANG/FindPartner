/**
 * This class is for manage view files (GUI)
 * 
 * @author Letao WANG
 */

package View;

import Controller.Controller;

public class MainView {
	
	Controller controller;
	Menu menu;
	Game game;
	FailureMessage failureMessage;
	SuccessMessage successMessage;
	
	/**
	 * Open the game window when the game starts
	 * @param controller
	 */
	public MainView(Controller controller) {
		this.controller = controller;
		menu = new Menu(controller);
	}
	
	public void disposeGame() {
		game.dispose();
	}
	
	public void showGame() {
		game = new Game(controller);
	}
	
	public void showMenu() {
		menu = new Menu(controller);
	}
	
	public void disposeFailureMessage() {
		failureMessage.dispose();
	}
	
	public void disposeSuccessMessage() {
		successMessage.dispose();
	}
	
	public void ShowFailureMessage() {
		failureMessage = new FailureMessage(controller);
	}
	
	public void ShowSuccessMessage() {
		successMessage = new SuccessMessage(controller);
	}
	
}
