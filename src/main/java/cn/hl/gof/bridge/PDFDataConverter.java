package cn.hl.gof.bridge;

public class PDFDataConverter extends DataConverter{

	@Override
	protected void convert() {
		System.out.println("convert "+data.getData()+" to pdf");
	}

}
