package cn.hl.gof.structure7.composite;

public class CompositeTest {

	public static void main(String[] args) {
		ControlLibrary 
		control1,control2,control3,control4,
		control5,control6,control7,control8,control9;
		control1 = new Button("login");
		control2 = new Button("submit");
		control3 = new TextField("title");
		control4 = new TextField("content");
		control5 = new CheckBox("radio");
		control6 = new CheckBox("multi");
		control7 = new ControlContainer("submenu");
		control8 = new ControlContainer("dashboard");
		control9 = new ControlContainer("window");
		control7.add(control1);
		control7.add(control3);
		control7.add(control5);
		control8.add(control2);
		control8.add(control4);
		control8.add(control6);
		control8.add(control1);
		control8.add(control7);
		control9.add(control1);
		control9.add(control8);
		control9.draw();
	}
}
