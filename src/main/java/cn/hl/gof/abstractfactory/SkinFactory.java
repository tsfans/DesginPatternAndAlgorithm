package cn.hl.gof.abstractfactory;

public interface SkinFactory {

	Button createButton();
	
	TextField createTextField();
	
	ComboBox createComboBox();
}
