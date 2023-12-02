package com.skilldistillery.jets;

import java.util.Objects;

public abstract class Jet {

	private String model;
	private double speed;
	private int range;
	private long price;

	public Jet(String model, double speed, int range, long price) {
		setModel(model);
		setSpeed(speed);
		setRange(range);
		setPrice(price);
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public int getRange() {
		return range;
	}

	public void setRange(int range) {
		this.range = range;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public void fly() {
		System.out.println(this + " can fly for " + calculateHowLongCanFly() + " hours before it runs out of fuel.");
	}

	public double calculateHowLongCanFly() {
		// Time aircraft can fly in hours = range in miles / miles per hour
		return getRange() / getSpeed();
	}

	public double getSpeedInMach() {
		// Mach = speed of aircraft MPH / speed of sound MPH
		return getSpeed() / 767.269;
	}

	@Override
	public int hashCode() {
		return Objects.hash(model, price, range, speed);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Jet))
			return false;
		Jet other = (Jet) obj;
		return Objects.equals(model, other.model) && price == other.price && range == other.range
				&& Double.doubleToLongBits(speed) == Double.doubleToLongBits(other.speed);
	}

	@Override
	public String toString() {
		return "Jet " + getModel() + " travels at a speed of " + getSpeed() + " MPH, which is " + getSpeedInMach()
				+ " in Mach. It has a range of " + getRange() + " and was purchsed for " + getPrice();
	}

}
