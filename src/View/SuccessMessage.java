package View;
import javax.swing.JFrame;

import javax.swing.JLabel;

import Controller.Controller;
import Model.World;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

/**
 * This window pops up when the player wins the game
 * 
 * @author Letao WANG
 * @author Jingyao FANG
 */
public class SuccessMessage extends JFrame implements ActionListener {

	Controller controller;

	public SuccessMessage(Controller controller) {
		this.controller = controller;
		setTitle("Success");
		getContentPane().setLayout(null);

		JLabel lblSuccess = new JLabel("You have successfully found your partner ");
		lblSuccess.setBounds(33, 32, 379, 28);
		getContentPane().add(lblSuccess);

		JLabel lblMission = new JLabel("Mission completed and Congratulations !");
		lblMission.setBounds(33, 63, 301, 35);
		getContentPane().add(lblMission);

		JButton btnOnceAgain = new JButton("Next level !");
		btnOnceAgain.setBounds(22, 116, 117, 42);
		getContentPane().add(btnOnceAgain);
		btnOnceAgain.addActionListener(this);

		JButton btnQuit = new JButton("Quit");
		btnQuit.setBounds(261, 116, 73, 42);
		getContentPane().add(btnQuit);
		btnQuit.addActionListener(this);

		JButton btnMenu = new JButton("Menu");
		btnMenu.setBounds(165, 116, 73, 42);
		getContentPane().add(btnMenu);
		btnMenu.addActionListener(this);

		setBounds(100, 100, 400, 250);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String command = e.getActionCommand();
		if ("Quit".equals(command)) {
			controller.Quit();
		}
		if ("Next level !".equals(command)) {
			// increase the level
			controller.setLevel(controller.getLevel() + 1);
			// change point of view
			if (controller.getLevel() == 4)
				controller.setViewType(World.VIEW_ABOVE_AGENT);
			else if (controller.getLevel() == 6)
				controller.setViewType(World.VIEW_ABOVE_AGENT_NEAR);
			controller.showGame();
			controller.disposeSuccessMessage();
		}
		if ("Menu".equals(command)) {
			controller.showMenu();
			controller.disposeSuccessMessage();
		}

	}
}
