/**
 * Main control program, connection View(GUI), Model(Modele) and result message 
 * 
 * @author Letao WANG
 */

package Controller;

import Model.EnvironmentDescription;
import Model.Model;
import Model.Robot;
import Model.RobotPartner;
import Model.World;
import View.FailureMessage;
import View.MainGUI;
import View.SuccessMessage;

public class Controller {
	Model model;
	MainGUI mainGUI;
	FailureMessage failureMessage;
	SuccessMessage successMessage;
	
	/**
	 * Create model and mainGUI
	 */
	public Controller() {
		model = new Model(this);
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
		model = new Model(this);
		mainGUI = new MainGUI(this);
	}
	
	public void Quit() {
		System.exit(0);
	}

	public Robot getRobot() {
		return model.getRobot();
	}

	public RobotPartner getRobotPartner() {
		return model.getRobotPartner();
	}

	public EnvironmentDescription getEd() {
		return model.getEd();
	}

	public World getWorld() {
		return model.getWorld();
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Controller();
	}

}
