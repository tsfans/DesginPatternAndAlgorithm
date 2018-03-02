package cn.hl.gof.facade;

public class EncryptFacade extends AbstractEncryptFacade{

	private FileReader reader;
	
	private FileEncrypt encrypt;
	
	private FileKeeper keeper;
	
	public EncryptFacade() {
		this.reader = new FileReader();
		this.encrypt = new FileEncrypt();
		this.keeper = new FileKeeper();
	}
	
	@Override
	protected void encryptFile(String fileNameSrc, String fileNameDes) {
		keeper.saveFile(encrypt.encrypt(reader.readFile(fileNameSrc)), fileNameDes);
	}

}
