package cn.hl.gof.creation5.prototype;

public class FAR implements OfficeDocument{

	@Override
	public OfficeDocument clone() {
		OfficeDocument far = null;
		try {
			far = (OfficeDocument)super.clone();
		}catch(CloneNotSupportedException e) {
			System.out.println("不支持复制!");
		}return far;
	}
	
	@Override
	public void display() {
		System.out.println("《可行性分析报告》");
	}
}
