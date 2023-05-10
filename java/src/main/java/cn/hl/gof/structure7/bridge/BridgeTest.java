package cn.hl.gof.structure7.bridge;

import cn.hl.gof.util.XMLUtil;

public class BridgeTest {
	

	public static void main(String[] args) {
		DataReader reader = (DataReader) XMLUtil.getBeanByPatternName("dataBase");
		DataConverter converter = (DataConverter) XMLUtil.getBeanByPatternName("fileFormat");
		converter.setData(reader);
		converter.convert();
	}
}

