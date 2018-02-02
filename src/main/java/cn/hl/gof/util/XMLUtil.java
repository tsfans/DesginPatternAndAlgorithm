package cn.hl.gof.util;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class XMLUtil {

	/**
	 * 
	 * <p>获取目标类同包下的配置文件路径</p>
	 * @date 2018年1月30日下午5:43:19
	 * @param clazz	目标类
	 * @param fileName	配置文件全名
	 * @return 配置文件系统全路径
	 */
	public static String getPath(Class<?> clazz,String fileName) {
		String path = clazz.getResource(fileName).toString();
		path = path.substring(path.indexOf("/"));
		return path;
	}
	
	public static String getValue(String path,String tagName) {
		String value = null;
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db;
		try {
			db = dbf.newDocumentBuilder();
			Document doc = db.parse(new File(path));
			NodeList nodeList = doc.getElementsByTagName(tagName);
			Node node = nodeList.item(0).getFirstChild();
			value = node.getNodeValue().trim();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return value;
	}
	public static String getValue(String tagName) {
		return getValue(getPath(XMLUtil.class,"config.xml"),tagName);
	}
	
	/**
	 * 
	 * <p>通过类名的完整路径使用反射获取对象</p>
	 * @date 2018年1月30日下午6:12:46
	 * @param className 类名完整路径
	 * @return
	 */
	public static Object getBean(String className) {
		Object o = null;
		Class<?> clazz;
		try {
			clazz = Class.forName(className);
			o =clazz.newInstance();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return o;
	}
	/**
	 * 
	 * <p>统一配置，根据pattern name获取对象</p>
	 * @date 2018年2月2日下午4:51:53
	 * @param pattern 模式名称
	 * @return
	 */
	public static Object getBeanByPatternName(String pattern) {
		String path = getPath(XMLUtil.class,"config.xml");
		String className = getValue(path,pattern);
		Object o = getBean(className);
		return o;
	}
	
}
