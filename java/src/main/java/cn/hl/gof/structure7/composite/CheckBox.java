package cn.hl.gof.structure7.composite;

public class CheckBox extends ControlLibrary{

	private String name;
	
	public CheckBox(String name) {
		this.name = name;
	}
	
	@Override
	protected void add(ControlLibrary controlLibrary) {
		System.out.println("error!this is a "+name+" checkbox!");
	}

	@Override
	protected void remove(ControlLibrary controlLibrary) {
		System.out.println("error!this is a "+name+" checkbox!");
	}

	@Override
	protected ControlLibrary getControl(int index) {
		System.out.println("error!this is a "+name+" checkbox!");
		return null;
	}

	@Override
	protected void draw() {
		System.out.println("draw a "+name+" checkbox!");
	}

}
