package cn.hl.gof.composite;

import java.util.ArrayList;
import java.util.List;

public class ControlContainer extends ControlLibrary{

	private List<ControlLibrary> controlList = new ArrayList<ControlLibrary>();
	
	private String name;
	
	public ControlContainer(String name) {
		this.name = name;
	}
	
	@Override
	protected void add(ControlLibrary controlLibrary) {
		controlList.add(controlLibrary);
	}

	@Override
	protected void remove(ControlLibrary controlLibrary) {
		controlList.remove(controlLibrary);
	}

	@Override
	protected ControlLibrary getControl(int index) {
		return controlList.get(index);
	}

	@Override
	protected void draw() {
		System.out.println("draw a "+name+" container");
		controlList.forEach(o -> o.draw());
	}

}
