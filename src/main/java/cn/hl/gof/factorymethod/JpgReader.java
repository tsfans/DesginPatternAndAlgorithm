package cn.hl.gof.factorymethod;

public class JpgReader extends ImageReader{

	@Override
	public void readImage() {

		System.out.println("read JPG");
	}
}
