package thucHanh;

public class TestCouponMachine {
	public static void main(String[] args) {
		// Create the coupon machine;
		CouponMachine cm = new CouponMachine();
		Constomer[] con = new Constomer[5];
		for (int i = 0; i < 5; i++) {
			con[i] = new Constomer(cm);
			con[i].start();
		}
		Producer prod = new Producer(cm);
		prod.start();
		System.out.println("End main thread!");
	}
}

class CouponMachine {
	private int couponID;
	private boolean couponExists = false;

	public synchronized void createCoupon(int coup) {
		while (couponExists) {
			try {
				wait();
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Exception :" + e);
			}
		}
		this.couponID = coup;
		couponExists = true;
		notify();
	}

	public synchronized int consumecoupon() {
		while (!couponExists) {
			try {
				wait();
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Exception :" + e);
			}
		}

		couponExists = false;
		notify();
		return couponID;
	}

}

class Producer extends Thread {
	int count = 0;
	CouponMachine cpm;

	public Producer(CouponMachine cpm) {
		// TODO Auto-generated constructor stub
		this.cpm = cpm;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 5; i++) {
			cpm.createCoupon(++count);
			System.out.println("Coupon produced :" + count);
		}
	}
}

class Constomer extends Thread {
	int count;
	CouponMachine cpm;

	public Constomer(CouponMachine cpm) {
		// TODO Auto-generated constructor stub
		this.cpm = cpm;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		count = cpm.consumecoupon();
		System.out.println("Coupon consumed :" + count);

	}
}
