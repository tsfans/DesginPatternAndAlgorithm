package cn.hl.gof.strategy;

public class Helicopter implements Plane{

	@Override
	public void takeOff() {
		System.out.println("Helicopter VerticalTakeOff");
	}
	
	@Override
	public void fly() {
		System.out.println("SubSonicFly");
	}
}
