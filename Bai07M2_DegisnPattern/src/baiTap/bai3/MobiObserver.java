package baiTap.bai3;

public class MobiObserver extends Observer {

	public MobiObserver(Account account) {

		this.account = account;
		this.account.attach(this);

	}

	@Override
	public String update() {

		return "Mobi: Xin chao. Tai khoan cua quy khách da thay doi. \nSo du hien tai la: " + account.getState()
				+ "vnđ";
	}

}
