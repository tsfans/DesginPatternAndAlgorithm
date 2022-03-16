package cn.hl.gof.creation5.prototype;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Customer implements Serializable,Cloneable{

	private static final long serialVersionUID = 1L;

	private String username;
	
	private String password;
	
	private Address address;
	
	@Override
	public String toString() {
		return "Customer [username=" + username + ", password=" + password + ", address=" + address.toString() + "]";
	}

	public Customer deepClone() {
		Customer customer = null;
		//将对象写入流中
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(bos);
			oos.writeObject(this);
			//将对象从流中取出
            ByteArrayInputStream bis = new  ByteArrayInputStream(bos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bis);
            customer = (Customer) ois.readObject();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
		return customer;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	public static void main(String[] args) throws CloneNotSupportedException {
		Customer customer = new Customer();
		customer.setUsername("abc");
		customer.setPassword("123456");
		Address addr = new Address();
		addr.setProvince("guangdong");
		addr.setCity("shenzheng");
		customer.setAddress(addr);
		Customer c1 = (Customer) customer.clone();
		Customer c2 = customer.deepClone();
		System.out.println(customer.getAddress()==c1.getAddress());
		System.out.println(customer.getAddress()==c2.getAddress());
	}
}
