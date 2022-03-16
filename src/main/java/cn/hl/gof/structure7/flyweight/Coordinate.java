package cn.hl.gof.structure7.flyweight;

public class Coordinate {

	public Coordinate() {}
	
	public Coordinate(int x,int y) {
		this.x = x;
		this.y = y;
	}
	
	private int x;
	
	private int y;

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	
}
