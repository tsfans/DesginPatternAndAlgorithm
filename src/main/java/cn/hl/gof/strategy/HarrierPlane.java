package cn.hl.gof.strategy;

public class HarrierPlane implements Plane{

	@Override
	public void takeOff() {
		System.out.println("HarrierPlane VerticalTakeOff");
	}
	
	@Override
	public void fly() {
		System.out.println("SuperSonicFly");
	}
}
