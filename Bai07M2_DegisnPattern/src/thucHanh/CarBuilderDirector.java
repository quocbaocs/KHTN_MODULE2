package thucHanh;

public class CarBuilderDirector {
	private CarBuilder builder;

	public CarBuilderDirector(CarBuilder builder) {
		
		this.builder = builder;
	}

	public Car construct() {
		return builder.setWheels(4).setColor("red").build();
	}

	public static void main(final String[] args) {
		final CarBuilder builder = new CarBuiderImpl();
		final CarBuilderDirector carBuildDirector = new CarBuilderDirector(builder);
		System.out.println(carBuildDirector.construct());
	}
}
