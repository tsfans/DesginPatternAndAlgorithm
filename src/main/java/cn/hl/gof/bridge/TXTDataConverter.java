package cn.hl.gof.bridge;

public class TXTDataConverter extends DataConverter{

	@Override
	protected void convert() {
		System.out.println("convert "+data.getData()+" to txt");
	}

}
