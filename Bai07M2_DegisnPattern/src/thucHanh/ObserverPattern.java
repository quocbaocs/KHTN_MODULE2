package thucHanh;

import java.util.ArrayList;
import java.util.List;

class TaiKhoan {

	private List<GiamSat> dsgs = new ArrayList<>();
	private int sd;

	public int getSd() {
		return sd;
	}

	public void setSd(int sd) {
		this.sd = sd;
		thongBaoGiamSat("So tien thay doi: " + sd);
	}

	private void thongBaoGiamSat(String tb) {
		for (GiamSat gs : dsgs) {
			gs.thongBao(tb);
		}
	}

	public void themGiamSat(GiamSat gs) {
		dsgs.add(gs);
	}

}

abstract class GiamSat {
	protected TaiKhoan taiKhoan;
	public abstract void thongBao(String tb);
}

class SMS extends GiamSat {
	public SMS(TaiKhoan tk) {
		taiKhoan = tk;
		taiKhoan.themGiamSat(this);
	}

	@Override
	public void thongBao(String tb) {
		System.out.println("SMS: " + tb);

	}

}

class Email extends GiamSat {
	public Email(TaiKhoan tk) {
		taiKhoan = tk;
		taiKhoan.themGiamSat(this);
	}

	@Override
	public void thongBao(String tb) {
		System.out.println("Email: " + tb);

	}

}

public class ObserverPattern {
	public static void main(String[] args) {
		TaiKhoan tk1 = new TaiKhoan();
		SMS sms = new SMS(tk1);
		Email email = new Email(tk1);
		tk1.setSd(100);
	}

}
