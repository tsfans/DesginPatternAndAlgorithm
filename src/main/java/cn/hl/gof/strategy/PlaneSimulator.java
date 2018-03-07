package cn.hl.gof.strategy;

public class PlaneSimulator {

	private Plane plane;

	public void setPlane(Plane plane) {
		this.plane = plane;
	}
	
	public void flySimlate() {
		plane.takeOff();
		plane.fly();
	}
	
}
