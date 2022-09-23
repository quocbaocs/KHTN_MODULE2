package baiTap.bai5;

public class QuickDeliveryStrategy implements DeliveryStrategy{

	@Override
	public String delivery() {
		
		return "Giao hàng nhanh trong khoảng từ 1 đến 2 ngày \nPhí giao hàng 10.000đ";
	}

}
