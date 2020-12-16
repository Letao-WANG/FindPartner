/**
 * This window pops up when the player wins the game
 * 
 * @author Letao WANG
 */

package View;

import javax.swing.JFrame;
import javax.swing.JLabel;

import Controller.Controller;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class SuccessMessage extends JFrame implements ActionListener {

	Controller controller;

	public SuccessMessage(Controller controller) {
		this.controller = controller;
		getContentPane().setLayout(null);

		JLabel lblSuccess = new JLabel("You have successfully found your partner ");
		lblSuccess.setBounds(33, 56, 379, 28);
		getContentPane().add(lblSuccess);

		JLabel lblMission = new JLabel("Mission completed and Congratulations !");
		lblMission.setBounds(33, 85, 301, 35);
		getContentPane().add(lblMission);

		JButton btnOnceAgain = new JButton("Once again !");
		btnOnceAgain.setBounds(43, 147, 142, 25);
		getContentPane().add(btnOnceAgain);
		btnOnceAgain.addActionListener(this);

		JButton btnQuit = new JButton("Quit");
		btnQuit.setBounds(217, 147, 117, 25);
		getContentPane().add(btnQuit);
		btnQuit.addActionListener(this);

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
		if ("Once again !".equals(command)) {
			controller.ShowMain();
			controller.disposeSuccessMessage();
		}

	}
}
