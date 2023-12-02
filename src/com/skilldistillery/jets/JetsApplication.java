package com.skilldistillery.jets;

import java.util.Scanner;

public class JetsApplication {

	private AirField airField;
	Scanner keyboard = new Scanner(System.in);

	public JetsApplication() {
		airField = new AirField();
	}

	public static void main(String[] args) {

		JetsApplication jetApp = new JetsApplication();
		jetApp.launch();
		jetApp.cleanUp();

	}

	private void launch() {
		displayUserMenu();
	}

	private void displayUserMenu() {
		int userResponse = 0;
		while (userResponse != 9) {
			System.out.println("Please enter a numerical response for what you would like to do:");
			System.out.println("1. List fleet");
			System.out.println("2. Fly all jets");
			System.out.println("3. View fastest jet");
			System.out.println("4. View jet with longest range");
			System.out.println("5. Load all cargo planes");
			System.out.println("6. Dogfight!");
			System.out.println("7. Add a jet to the fleet");
			System.out.println("8. Remove a jet from the fleet");
			System.out.println("9. Quit");
			userResponse = keyboard.nextInt();
			executeUserResponse(userResponse);
		}
	}

	private void executeUserResponse(int choice) {
		switch (choice) {
		case 1:
			//TODO get toString() to print getSimpleName for each instanceof Jet/FighterJet/CargoPlane
			System.out.println(airField);
			break;
		case 2:
			// TODO Fly all jets
			break;
		case 3:
			// TODO find fastest jet
			break;
		case 4:
			// TODO find jet with longest range
			break;
		case 5:
			// TODO load all cargo planes
			break;
		case 6:
			// TODO fighter jets fight
			break;
		case 7:
			// TODO add a jet to the fleet
			break;
		case 8:
			// TODO remove a jet from the fleet
			break;
		case 9:
			System.out.println("Goodbye! Thank you for flying with Lockheed Martin and Airbus!");
			System.exit(0);
		default:
			System.out.println("Option not recognized. Please input a valid choice of 1-9.");
			break;
		}
	}

	private void cleanUp() {
		keyboard.close();
	}

}
