package cn.hl.gof.action11.templatemethod;

import cn.hl.gof.util.XMLUtil;

public class TemplateMethodTest {

	public static void main(String[] args) {
		DataViewer dw = (DataViewer) XMLUtil.getBeanByPatternName("templatemethod");
		dw.process();
	}
}
