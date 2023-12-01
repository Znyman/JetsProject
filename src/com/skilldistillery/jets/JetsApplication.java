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
		
	}
	
	private void cleanUp() {
		keyboard.close();
	}

}
