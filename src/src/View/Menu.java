/**
 * Game menu
 * Players can choose different difficulty levels
 * 
 * @author Jingyao FANG
 * @author Letao WANG
 */

package View;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JRadioButton;

import Controller.Controller;
import Model.World;

public class Menu extends JFrame {
	
	private final JTextPane txtPnWelcome = new JTextPane();
	Controller controller;
	
	public Menu(Controller controller) {
		this.controller = controller;
		
		getContentPane().setLayout(null);
		txtPnWelcome.setText(
				"Welcome to FindPartner !\n\nYou are a white robot. Your task is to rescue your white RobotPartner, and the only thing you know is that the RobotPartner is northwest of you.  There are many hostile black robots who want to catch yom, you can avoid or lure them into a nearby wall. Once the black robot hits the wall, it cannot move.\n\nArrow keys control movement. \nChoose the difficulty level and start game !");
		txtPnWelcome.setBounds(12, 12, 416, 156);
		getContentPane().add(txtPnWelcome);

		ButtonGroup bg = new ButtonGroup();

		JRadioButton rdLevel1 = new JRadioButton("level 1");
		rdLevel1.setBounds(12, 180, 75, 20);
		rdLevel1.setBackground(Color.white);
		getContentPane().add(rdLevel1);

		JRadioButton rdLevel2 = new JRadioButton("level 2");
		rdLevel2.setBounds(12, 200, 75, 20);
		rdLevel2.setBackground(Color.white);
		getContentPane().add(rdLevel2);

		JRadioButton rdLevel3 = new JRadioButton("level 3");
		rdLevel3.setBounds(12, 220, 75, 20);
		rdLevel3.setBackground(Color.white);
		getContentPane().add(rdLevel3);

		JRadioButton rdLevel4 = new JRadioButton("level 4");
		rdLevel4.setBounds(12, 240, 75, 20);
		rdLevel4.setBackground(Color.white);
		getContentPane().add(rdLevel4);
		
		JRadioButton rdLevel5 = new JRadioButton("level 5");
		rdLevel5.setBounds(102, 180, 75, 20);
		rdLevel5.setBackground(Color.white);
		getContentPane().add(rdLevel5);
		
		JRadioButton rdLevel6 = new JRadioButton("level 6");
		rdLevel6.setBounds(102, 200, 75, 20);
		rdLevel6.setBackground(Color.white);
		getContentPane().add(rdLevel6);
		
		JRadioButton rdLevel7 = new JRadioButton("level 7");
		rdLevel7.setBounds(102, 220, 75, 20);
		rdLevel7.setBackground(Color.white);
		getContentPane().add(rdLevel7);
		
		JRadioButton rdLevel8 = new JRadioButton("level 8");
		rdLevel8.setBounds(102, 240, 75, 20);
		rdLevel8.setBackground(Color.white);
		getContentPane().add(rdLevel8);

		JButton btnStart = new JButton("Start game!");
		btnStart.setBounds(276, 195, 133, 25);
		getContentPane().add(btnStart);

		bg.add(rdLevel1);
		bg.add(rdLevel2);
		bg.add(rdLevel3);
		bg.add(rdLevel4);
		bg.add(rdLevel5);
		bg.add(rdLevel6);
		bg.add(rdLevel7);
		bg.add(rdLevel8);
		
		JButton btnQuit = new JButton("Quit");
		btnQuit.setBounds(276, 230, 133, 25);
		getContentPane().add(btnQuit);
		btnQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		/**
		 * choose different difficulty levels
		 * set point of view and level
		 */
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdLevel1.isSelected()) {
					controller.setLevel(1);
					controller.setViewType(World.VIEW_FROM_TOP);
					controller.showGame();
					dispose();
				}
				else if (rdLevel2.isSelected()) {
					controller.setLevel(2);
					controller.setViewType(World.VIEW_FROM_TOP);
					controller.showGame();
					dispose();
				}
				else if (rdLevel3.isSelected()) {
					controller.setLevel(3);
					controller.setViewType(World.VIEW_FROM_TOP);
					controller.showGame();
					dispose();
				}
				else if (rdLevel4.isSelected()) {
					controller.setLevel(4);
					controller.setViewType(World.VIEW_FROM_TOP);
					controller.showGame();
					dispose();
				}
				else if (rdLevel5.isSelected()) {
					controller.setLevel(5);
					controller.setViewType(World.VIEW_ABOVE_AGENT);
					controller.showGame();
					dispose();
				}
				else if (rdLevel6.isSelected()) {
					controller.setLevel(6);
					controller.setViewType(World.VIEW_ABOVE_AGENT);
					controller.showGame();
					dispose();
					
				}
				else if (rdLevel7.isSelected()) {
					controller.setLevel(7);
					controller.setViewType(World.VIEW_ABOVE_AGENT_NEAR);
					controller.showGame();
					dispose();
				}
				else if (rdLevel8.isSelected()) {
					controller.setLevel(8);
					controller.setViewType(World.VIEW_ABOVE_AGENT_NEAR);
					controller.showGame();
					dispose();
				}
				else {
					JOptionPane.showMessageDialog(null, "You must choose a game difficulty level ! ", "Game difficulty level not selected", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		
		getContentPane().setBackground(Color.white);
		
		
		
		setBounds(100, 100, 440, 320);
		setVisible(true);

	}
}
