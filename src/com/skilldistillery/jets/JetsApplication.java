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
			System.out.println(airField);
			break;
		case 2:
			airField.flyJets();
			break;
		case 3:
			System.out.println(airField.findFastestJet());
			break;
		case 4:
			System.out.println(airField.findLongestRangeJet());
			break;
		case 5:
			airField.loadAllCargoPlanes();
			break;
		case 6:
			airField.dogFight();
			break;
		case 7:
			addJetMenu();
			break;
		case 8:
			removeJetMenu();
			break;
		case 9:
			System.out.println("Goodbye! Thank you for flying with Lockheed Martin and Airbus!");
			return;
		default:
			System.out.println("Option not recognized. Please input a valid choice of 1-9.");
			break;
		}
	}

	private void addJetMenu() {

		System.out.println("Please enter a numerical response for what kind of Jet you would like to add:");
		System.out.println("1. Fighter Jet");
		System.out.println("2. Cargo Plane");
		System.out.println("3. Passenger Jet");
		int choice = keyboard.nextInt();
		keyboard.nextLine();

		String model = "";
		double speed = 0;
		int range = 0;
		long price = 0;

		if (choice > 0 && choice <= 3) {
			System.out.println("What is the model of the Jet?");
			model = keyboard.nextLine();
			System.out.println("What is the top speed of the Jet?");
			speed = keyboard.nextDouble();
			System.out.println("What is the range of the Jet?");
			range = keyboard.nextInt();
			System.out.println("How much did the Jet cost?");
			price = keyboard.nextLong();
		}

		switch (choice) {
		case 1:
			FighterJet fighterJet = new FighterJet(model, speed, range, price);
			if (airField.addJet(fighterJet)) {
				System.out.println("Your Fighter Jet was successfully added!");
			} else {
				System.out.println("There was an error adding your Fighter Jet. Please try again.");
			}
			break;
		case 2:
			CargoPlane cargoPlane = new CargoPlane(model, speed, range, price);
			if (airField.addJet(cargoPlane)) {
				System.out.println("Your Cargo Plane was successfully added!");
			} else {
				System.out.println("There was an error adding your Cargo Plane. Please try again.");
			}
			break;
		case 3:
			PassengerJet passengerJet = new PassengerJet(model, speed, range, price);
			if (airField.addJet(passengerJet)) {
				System.out.println("Your Passenger Jet was successfully added!");
			} else {
				System.out.println("There was an error adding your Passenger Jet. Please try again.");
			}
			break;
		default:
			System.out.println("Input not recognized. Please try again.");
			break;
		}
	}

	public void removeJetMenu() {
		System.out.println("Please choose which jet you would like to remove by using an index between 0 and "
				+ (airField.getJets().size() - 1));
		int index = keyboard.nextInt();
		System.out.println("You have removed " + airField.removeJet(index));
	}

	private void cleanUp() {
		keyboard.close();
	}

}
