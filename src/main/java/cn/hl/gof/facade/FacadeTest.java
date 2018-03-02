package cn.hl.gof.facade;

public class FacadeTest {

	public static void main(String[] args) {
		AbstractEncryptFacade facade = new EncryptFacade();
		facade.encryptFile("123.jpg", "456.png");
	}

}
