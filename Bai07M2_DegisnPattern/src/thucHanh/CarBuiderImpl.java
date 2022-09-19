package thucHanh;

public class CarBuiderImpl implements CarBuilder{

	private Car car;
	
	
	public CarBuiderImpl() {
		car = new Car();
	}

	@Override
	public Car build() {
		// TODO Auto-generated method stub
		return car;
	}

	@Override
	public CarBuilder setColor(String color) {
		// TODO Auto-generated method stub
	car.setColor(color);
		return this;
	}

	@Override
	public CarBuilder setWheels(int wheels) {
		// TODO Auto-generated method stub
		car.setWheels(wheels);
		return this;
	}

}
