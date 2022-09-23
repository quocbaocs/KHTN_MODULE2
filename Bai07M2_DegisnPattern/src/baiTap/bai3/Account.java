package baiTap.bai3;

import java.util.ArrayList;
import java.util.List;

public class Account {
	private List<Observer> observers = new ArrayList<>();
	private double state;

	public double getState() {
		return state;
	}

	public void setState(double state) {
		this.state = state;
		notifyAllObserver();
	}

	public void attach(Observer observer) {
		observers.add(observer);
	}

	public void notifyAllObserver() {
		observers.forEach(observer -> observer.update());
	}

}
