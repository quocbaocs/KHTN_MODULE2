package baiTap.bai1;

public class RedShapeDecorator extends ShapeDecorator {

	public RedShapeDecorator(Shape shape) {
		super(shape);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String draw() {
		// TODO Auto-generated method stub
		return super.shape.draw() + " and " + setRedBorder(shape);
	}

	private String setRedBorder(Shape shape) {
		return "Border Color: Red";
	}

}
