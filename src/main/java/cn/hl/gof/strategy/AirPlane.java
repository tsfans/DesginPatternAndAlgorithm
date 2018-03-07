package cn.hl.gof.strategy;

public class AirPlane implements Plane{

	@Override
	public void takeOff() {
		System.out.println("AirPlane LongDistanceTakeOff");
	}
	
	@Override
	public void fly() {
		System.out.println("SubSonicFly");
	}
}
