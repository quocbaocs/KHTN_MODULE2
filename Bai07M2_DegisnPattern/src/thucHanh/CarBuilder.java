package thucHanh;

public interface CarBuilder {
	Car build();
	CarBuilder setColor(final String color);
	CarBuilder setWheels(final int wheels);
}
