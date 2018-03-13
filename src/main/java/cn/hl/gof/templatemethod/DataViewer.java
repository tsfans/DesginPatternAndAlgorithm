package cn.hl.gof.templatemethod;

public abstract class DataViewer {

	public abstract void getData();
	
	public void convertData() {
		System.out.println("将数据转化为xml格式");
	}
	
	public abstract void display();
	
	public void process() {
		getData();
		if(!isXml()) {
			convertData();
		}
		display();
	}
	
	public boolean isXml() {
		return false;
	}
}
