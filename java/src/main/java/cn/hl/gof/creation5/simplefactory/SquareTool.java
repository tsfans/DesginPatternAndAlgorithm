package cn.hl.gof.creation5.simplefactory;

public class SquareTool extends PaintingTools{

	@Override
	public void draw() {
		System.out.println("use square tool draw on the blackborad");
	}
	@Override
	public void erase() {
		System.out.println("use square tool erase the blackborad");
	}
}
