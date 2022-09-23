package baiTap.bai5;

public class StandardDeliveryStrategy implements DeliveryStrategy {

	@Override
	public String delivery() {

		return "Giao hàng tiêu chẩn trong khoảng từ 3 đến 5 ngày Miễn phí";
	}

}
