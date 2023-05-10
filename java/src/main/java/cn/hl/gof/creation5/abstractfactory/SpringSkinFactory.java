package cn.hl.gof.creation5.abstractfactory;

public class SpringSkinFactory implements SkinFactory{

	@Override
	public Button createButton() {
		return new SpringButton();
	}

	@Override
	public TextField createTextField() {
		return new SpringTextField();
	}

	@Override
	public ComboBox createComboBox() {
		return new SpringComboBox();
	}

}
