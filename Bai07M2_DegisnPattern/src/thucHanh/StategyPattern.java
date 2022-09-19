package thucHanh;

class DeliveryContext {
	private DeliveryStategy strategy;

	public DeliveryContext(DeliveryStategy strategy) {
		this.strategy = strategy;
	}

	public void executeDelivery() {
		strategy.delivery();
	}
}

interface DeliveryStategy {
	void delivery();
}

class StandardDeliveryStrategy implements DeliveryStategy {

	@Override
	public void delivery() {
		System.out.println("Giao hàng tiêu chẩn trong khoảng từ 3 đến 5 ngày" + " Miễn phí");

	}

}

class QuickDeliveryStrategy implements DeliveryStategy {

	@Override
	public void delivery() {
		System.out.println("Giao hàng nhanh trong khoảng từ 1 đến 2 ngày " + " Phí giao hàng 10.000đ");

	}

}

public class StategyPattern {
	public static void main(String[] args) {
		DeliveryStategy standard = new StandardDeliveryStrategy();
		DeliveryStategy quick = new QuickDeliveryStrategy();

		DeliveryContext d1 = new DeliveryContext(standard);
		DeliveryContext d2 = new DeliveryContext(quick);
		d1.executeDelivery();
		d2.executeDelivery();
	}
}
