package baiTap.bai7;

public class CarBuildDirector {
	private CarBuilder builder;

	public CarBuildDirector(final CarBuilder builder) {
		this.builder = builder;
	}

	public Car construct() {
		return builder.setWheels(4).setColor("Black").build();
	}

	public Car construct1(int numWheels, String color) {
		return builder.setWheels(numWheels).setColor(color).build();
	}

	public Car construct2(int numWheels) {
		return builder.setWheels(numWheels).setColor("Black").build();
	}

	public Car construct3(String color) {
		return builder.setWheels(4).setColor(color).build();
	}
}
