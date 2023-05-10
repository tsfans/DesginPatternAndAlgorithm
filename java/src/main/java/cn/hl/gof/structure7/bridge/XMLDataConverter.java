package cn.hl.gof.structure7.bridge;

public class XMLDataConverter extends DataConverter{

	@Override
	protected void convert() {
		System.out.println("convert "+data.getData()+" to xml");
	}

}
