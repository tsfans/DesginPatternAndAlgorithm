package cn.hl.gof.action11.strategy;

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
