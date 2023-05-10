package cn.hl.gof.action11.observer;

import java.util.Observable;
import java.util.Observer;

public class ShareHolder implements Observer{

	private String name;
	
	public ShareHolder() {}
	
	public ShareHolder(String name) {
		this.name = name;
	}
	
	@Override
	public void update(Observable o, Object arg) {
		Share share = (Share) o;
		Double change = (Double) arg;
		if(change > 0) {
			System.out.println(name+" 你好,股票 ["+share.getName()+"] 上涨"+change+"%!最新价格为 ["+share.getPrice()+"]");
		}
		if(change < 0) {
			change = Math.abs(change);
			System.out.println(name+" 你好,股票 ["+share.getName()+"] 下降"+change+"%!最新价格为 ["+share.getPrice()+"]");
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
