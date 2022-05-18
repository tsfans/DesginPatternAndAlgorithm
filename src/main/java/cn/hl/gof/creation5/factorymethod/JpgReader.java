package cn.hl.gof.creation5.factorymethod;

public class JpgReader extends ImageReader{

	@Override
	public void readImage() {

		System.out.println("read JPG");
	}
}
