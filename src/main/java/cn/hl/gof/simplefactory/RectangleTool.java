package cn.hl.gof.simplefactory;

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
