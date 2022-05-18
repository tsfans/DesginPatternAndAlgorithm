package cn.hl.gof.creation5.abstractfactory;

public interface SkinFactory {

	Button createButton();
	
	TextField createTextField();
	
	ComboBox createComboBox();
}
