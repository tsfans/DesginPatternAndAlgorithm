package cn.hl.gof.action11.observer;

import java.util.Observable;

public class Share extends Observable{

	private String name;
	
	private Double price;
	
	public Share() {}
	
	public Share(Double price,String name) {
		this.name = name;
		this.price = price;
	}
	
	public void change(Double newPrice) {
		Double change = ((newPrice-price)/price)*100;
		Double result = null;
		if(change > 5) {
			this.setChanged();
			result = change;
		}
		if(change < -5) {
			this.setChanged();
			result = change;
		}
		setPrice(newPrice);
		this.notifyObservers(result);
	}
	
	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
