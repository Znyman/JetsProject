package com.skilldistillery.jets;

import java.util.ArrayList;
import java.util.Objects;
import java.lang.*;

public class AirField {
	
	private ArrayList<Jet> jets;

	public AirField() {
		jets = new ArrayList<>();
		jets.add(new FighterJet("F-35 Lightning II", 1227.63, 1380, 85000000));
		jets.add(new FighterJet("F-35 Lightning II", 1227.63, 1380, 85000000));
		jets.add(new CargoPlane("C-5M Super Galaxy", 531, 5524, 100000000));
		jets.add(new CargoPlane("C-5M Super Galaxy", 531, 5524, 100000000));
		jets.add(new PassengerJet("Airbus A350", 652, 9300, 385000000));
		
	}

	@Override
	public int hashCode() {
		return Objects.hash(jets);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof AirField))
			return false;
		AirField other = (AirField) obj;
		return Objects.equals(jets, other.jets);
	}

	@Override
	public String toString() {
		//TODO get toString() to print getSimpleName for each instanceof Jet/FighterJet/CargoPlane
		String jetsNewLine = "";
		for (Jet jet : jets) {
			jetsNewLine += jet.toString() + "\n";
		}
		return jetsNewLine;
	}
	
	
	
	

}
