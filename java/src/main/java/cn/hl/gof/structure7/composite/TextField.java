package cn.hl.gof.structure7.composite;

public class TextField extends ControlLibrary{

	private String name;
	
	public TextField(String name) {
		this.name = name;
	}
	
	@Override
	protected void add(ControlLibrary controlLibrary) {
		System.out.println("error!this is a "+name+" textfield!");
	}

	@Override
	protected void remove(ControlLibrary controlLibrary) {
		System.out.println("error!this is a "+name+" textfield!");
		
	}

	@Override
	protected ControlLibrary getControl(int index) {
		System.out.println("error!this is a "+name+" textfield!");
		return null;
	}

	@Override
	protected void draw() {
		System.out.println("draw a "+name+" textfield");
	}

}
