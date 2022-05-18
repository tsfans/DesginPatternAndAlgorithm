package cn.hl.gof.creation5.simplefactory;

public class RectangleTool extends PaintingTools{
	
	@Override
	public void draw() {
		System.out.println("use Rectangle tool draw on the blackborad");
	}
	@Override
	public void erase() {
		System.out.println("use Rectangle tool erase the blackborad");
	}

}
