package cn.hl.gof.creation5.factorymethod;

public class PngReader extends ImageReader{

	@Override
	public void readImage() {

		System.out.println("read PNG");
	}
}
