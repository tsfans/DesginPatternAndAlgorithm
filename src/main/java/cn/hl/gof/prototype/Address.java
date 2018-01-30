package cn.hl.gof.prototype;

import java.io.Serializable;

public class Address implements Serializable{

	private static final long serialVersionUID = 1L;

	private String province;
	
	private String city;

	@Override
	public String toString() {
		return "Address [province=" + province + ", city=" + city + "]";
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	
}
