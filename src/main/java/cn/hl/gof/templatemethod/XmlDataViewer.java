package cn.hl.gof.templatemethod;

public class XmlDataViewer extends DataViewer{

	
	@Override
	public void getData() {
		System.out.println("从xml文件中获取data");
	}
	
	@Override
	public void display() {
		System.out.println("以柱状图显示数据");
	}
	
	@Override
	public boolean isXml() {
		return true;
	}
}
