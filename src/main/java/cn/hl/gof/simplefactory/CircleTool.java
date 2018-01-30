package cn.hl.gof.simplefactory;

public class CircleTool extends PaintingTools{

	@Override
	public void draw() {

		System.out.println("use circle tool draw on the blackborad");
	}
	@Override
	public void erase() {

		System.out.println("user circle tool erase the blackborad");
	}
}
