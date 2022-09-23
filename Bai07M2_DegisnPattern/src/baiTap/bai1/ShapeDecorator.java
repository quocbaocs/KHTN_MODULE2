package baiTap.bai1;

public abstract class ShapeDecorator implements Shape {
	protected Shape shape;

	public ShapeDecorator(Shape shape) {
		// TODO Auto-generated constructor stub
		this.shape = shape;
	}

	public Shape getShape() {
		return shape;
	}

	public void setShape(Shape shape) {
		this.shape = shape;
	}

	@Override
	public String draw() {
		// TODO Auto-generated method stub
		return shape.draw();
	}
}
