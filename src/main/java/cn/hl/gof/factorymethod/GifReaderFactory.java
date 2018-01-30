package cn.hl.gof.factorymethod;

public class GifReaderFactory implements ReaderFactory{

	@Override
	public ImageReader getReader() {
		
		return new GifReader();
	}
}
