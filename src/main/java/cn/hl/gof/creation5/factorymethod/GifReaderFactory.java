package cn.hl.gof.creation5.factorymethod;

public class GifReaderFactory implements ReaderFactory{

	@Override
	public ImageReader getReader() {
		
		return new GifReader();
	}
}
