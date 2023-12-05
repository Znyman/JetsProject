package com.skilldistillery.jets;

import java.util.ArrayList;
import java.util.Objects;

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

	public ArrayList<Jet> getJets() {
		return jets;
	}
	
	public boolean addJet(Jet jet) {
		jets.add(jet);
		return true;
	}
	
	public Jet removeJet(int index) {
		return jets.remove(index);
	}
	
	public void flyJets() {
		for (Jet jet : jets) {
			jet.fly();
		}
	}
	
	public Jet findFastestJet() {
		Jet fastestJet = jets.get(0);
		for (Jet jet : jets) {
			if (jet.getSpeed() > fastestJet.getSpeed()) {
				fastestJet = jet;
			}
		}
		return fastestJet;
	}
	
	public Jet findLongestRangeJet() {
		Jet longestRangeJet = jets.get(0);
		for (Jet jet : jets) {
			if (jet.getRange() > longestRangeJet.getRange()) {
				longestRangeJet = jet;
			}
		}
		return longestRangeJet;
	}
	
	public void loadAllCargoPlanes() {
		for (Jet jet : jets) {
			if (jet instanceof CargoPlane) {
				((CargoPlane) jet).loadCargo();
			}
		}
	}
	
	public void dogFight() {
		for (Jet jet : jets) {
			if (jet instanceof FighterJet) {
				((FighterJet) jet).fight();
			}
		}
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
		String jetsNewLine = "";
		for (Jet jet : jets) {
			jetsNewLine += jet.toString() + "\n";
		}
		return jetsNewLine;
	}
	
	
	
	

}
