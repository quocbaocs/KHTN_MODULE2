package thucHanh;

public class Car {
	private int wheels;
	private String color;

	public int getWheels() {
		return wheels;
	}

	public void setWheels(int wheels) {
		this.wheels = wheels;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Car() {
		super();
	}

	public Car(int wheels, String color) {
		super();
		this.wheels = wheels;
		this.color = color;
	}

	@Override
	public String toString() {
		return "Car [wheels=" + wheels + ", color=" + color + "]";
	}

}
