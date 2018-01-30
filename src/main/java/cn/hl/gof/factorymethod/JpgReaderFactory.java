package cn.hl.gof.factorymethod;

public class JpgReaderFactory implements ReaderFactory{

	@Override
	public ImageReader getReader() {
		return new JpgReader();
	}
}
