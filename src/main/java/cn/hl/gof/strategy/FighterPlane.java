package cn.hl.gof.strategy;

public class FighterPlane implements Plane{

	@Override
	public void takeOff() {
		System.out.println("FighterPlane LongDistanceTakeOff");
	}
	
	@Override
	public void fly() {
		System.out.println("SuperSonicFly");
	}
}
