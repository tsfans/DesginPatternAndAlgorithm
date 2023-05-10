package cn.hl.gof.structure7.composite;

public class Button extends ControlLibrary{

	private String name;
	
	public Button(String name) {
		this.name = name;
	}
	
	@Override
	protected void add(ControlLibrary controlLibrary) {
		System.out.println("error!this is a "+name+" button!");
	}

	@Override
	protected void remove(ControlLibrary controlLibrary) {
		System.out.println("error!this is a "+name+" button!");
	}

	@Override
	protected ControlLibrary getControl(int index) {
		System.out.println("error!this is a "+name+" button!");
		return null;
	}

	@Override
	protected void draw() {
		System.out.println("draw a "+name+" button");
	}

}
