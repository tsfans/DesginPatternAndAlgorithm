package cn.hl.gof.factorymethod;

public class PngReaderFactory implements ReaderFactory{

	@Override
	public ImageReader getReader() {
		return new PngReader();
	}
}
