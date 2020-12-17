/**
 * Set the environment according to the configuration file ( myenv.txt )
 * 
 * @author Jingyao Fang
 */

package Model;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.vecmath.Color3f;
import javax.vecmath.Vector3d;

import Controller.Controller;

public class MyEnv extends EnvironmentDescription {

	Controller controller;
	int level;

	public MyEnv(Robot robot, RobotPartner robotPartner, int level) {
		this.controller = controller;
		this.level = level;
		add(robotPartner);
		add(robot);
		lireFichier();
	}

	public MyEnv(Robot robot, RobotPartner robotPartner) {
		add(robotPartner);
		add(robot);
		lireFichier();
	}

	private void lireFichier() {

		try {
			String nomFichier = "../env_files/myenv" + Integer.toString(level) + ".txt";

			String ligne = null;
			InputStream ips = this.getClass().getResourceAsStream(nomFichier);
			InputStreamReader ipsr = new InputStreamReader(ips);
			BufferedReader fichier = new BufferedReader(ipsr);
			while ((ligne = fichier.readLine()) != null) {
				traiteLigne(ligne);
			}
			fichier.close();
		} catch (Exception exc) {
			System.out.println("Erreur fichier" + exc);
		}
	}

	private void traiteLigne(String ligne) {
		String[] tabChamp = ligne.split(" ");

		BaseObject tmp = null;

		if (tabChamp[0].charAt(0) == 'W') {

			tmp = new Wall(
					new Vector3d(Integer.parseInt(tabChamp[1]), Integer.parseInt(tabChamp[2]),
							Integer.parseInt(tabChamp[3])),
					Integer.parseInt(tabChamp[4]), Integer.parseInt(tabChamp[5]), this);
			((BlockWorldObject) tmp).rotate90(Integer.parseInt(tabChamp[6]));

		} else if (tabChamp[0].charAt(0) == 'R') {

			tmp = new RobotHostile(new Vector3d(Integer.parseInt(tabChamp[1]), Integer.parseInt(tabChamp[2]),
					Integer.parseInt(tabChamp[3])), "RobotHostile");
		}
		if (tmp != null)
			add(tmp);

	}
}
