package baiTap.bai7;

public interface CarBuilder {
	Car build();
	CarBuilder setColor(final String color);
	CarBuilder setWheels(final int wheels);
}
