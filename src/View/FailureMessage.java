/**
 * This window pops up when the player fails the game
 * 
 * @author Letao WANG
 */

package View;

import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Controller.Controller;
import javax.swing.JButton;
import javax.swing.JLabel;

public class FailureMessage extends JFrame implements ActionListener {

	Controller controller;

	public FailureMessage(Controller controller) {

		this.controller = controller;

		getContentPane().setLayout(null);

		JButton btnRestart = new JButton("Restart");
		btnRestart.setBounds(40, 108, 92, 42);
		getContentPane().add(btnRestart);
		btnRestart.addActionListener(this);

		JButton btnQuit = new JButton("Quit");
		btnQuit.setBounds(240, 108, 92, 42);
		getContentPane().add(btnQuit);
		btnQuit.addActionListener(this);

		JLabel lblGameOver = new JLabel("GAME OVER !");
		lblGameOver.setBounds(79, 37, 117, 17);
		getContentPane().add(lblGameOver);

		JLabel lblAgain = new JLabel("Want to try again ?");
		lblAgain.setBounds(77, 56, 151, 26);
		getContentPane().add(lblAgain);
		
		JButton btnMenu = new JButton("Menu");
		btnMenu.setBounds(140, 108, 92, 42);
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
		else if ("Restart".equals(command)) {
			controller.showGame();
			controller.disposeFailureMessage();
		}
		else if ("Menu".equals(command)) {
			controller.showMenu();
			controller.disposeFailureMessage();
		}
	}
}
