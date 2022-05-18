package cn.hl.gof.creation5.factorymethod;

public class GifReader extends ImageReader{

	@Override
	public void readImage() {

		System.out.println("read GIF");
	}
}
