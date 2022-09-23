package baiTap.bai5;

public class DeliveryContext {
	private DeliveryStrategy strategy;

	public DeliveryContext(DeliveryStrategy strategy) {
		super();
		this.strategy = strategy;
	}

	public String executeDelivery() {
		return strategy.delivery();
	}

}
