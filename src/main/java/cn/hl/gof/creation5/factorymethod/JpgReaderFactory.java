package cn.hl.gof.creation5.factorymethod;

public class JpgReaderFactory implements ReaderFactory{

	@Override
	public ImageReader getReader() {
		return new JpgReader();
	}
}
