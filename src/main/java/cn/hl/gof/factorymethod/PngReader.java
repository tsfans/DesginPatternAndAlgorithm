package cn.hl.gof.factorymethod;

public class PngReader extends ImageReader{

	@Override
	public void readImage() {

		System.out.println("read PNG");
	}
}
