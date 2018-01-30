package cn.hl.gof.factorymethod;

public class GifReader extends ImageReader{

	@Override
	public void readImage() {

		System.out.println("read GIF");
	}
}
