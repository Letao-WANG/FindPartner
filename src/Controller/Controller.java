/**
 * Main control program, connection result message and game interface
 * 
 * @author Letao WANG
 */

package Controller;

import View.FailureMessage;
import View.MainGUI;
import View.SuccessMessage;

public class Controller {

	MainGUI mainGUI;
	FailureMessage failureMessage;
	SuccessMessage successMessage;
	
	public Controller() {
		mainGUI = new MainGUI(this);
	}
	
	public void disposeMain() {
		mainGUI.dispose();
	}
	
	public void disposeFailureMessage() {
		failureMessage.dispose();
	}
	
	public void disposeSuccessMessage() {
		successMessage.dispose();
	}
	
	public void ShowFailureMessage() {
		failureMessage = new FailureMessage(this);
	}
	
	public void ShowSuccessMessage() {
		successMessage = new SuccessMessage(this);
	}
	
	public void ShowMain() {
		mainGUI = new MainGUI(this);
	}
	
	public void Quit() {
		System.exit(0);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Controller();
	}

}
