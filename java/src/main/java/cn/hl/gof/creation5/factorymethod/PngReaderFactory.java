package cn.hl.gof.creation5.factorymethod;

public class PngReaderFactory implements ReaderFactory{

	@Override
	public ImageReader getReader() {
		return new PngReader();
	}
}
