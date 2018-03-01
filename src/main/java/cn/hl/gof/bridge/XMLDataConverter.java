package cn.hl.gof.bridge;

public class XMLDataConverter extends DataConverter{

	@Override
	protected void convert() {
		System.out.println("convert "+data.getData()+" to xml");
	}

}
