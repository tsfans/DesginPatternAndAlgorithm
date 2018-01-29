package cn.hl.gof.prototype;

public class FAR implements OfficeDocument{

	@Override
	public OfficeDocument clone() throws CloneNotSupportedException {
		return (OfficeDocument)super.clone();
	}
	
	@Override
	public void display() {

		System.out.println();
	}
}
