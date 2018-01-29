/**
 * 
 */
package cn.hl.gof.prototype;

import java.util.Hashtable;

/**
 * <p>原型管理器（使用饿汉式单例实现）</p>
 * @author HULIN
 * @date 2018年1月29日下午8:23:40
 * @version
 */
public class PrototypeManager {

	private Hashtable<String,OfficeDocument> ht = new Hashtable<String,OfficeDocument>();
	
	private static PrototypeManager pm = new PrototypeManager();
	
	private PrototypeManager() {
		ht.put("far", new FAR());
		ht.put("srs", new SRS());
	}
	public static PrototypeManager getInstance() {
		return pm;
	}
	/**
	 * 
	 * <p>通过浅克隆获取新的公文对象</p>
	 * @date 2018年1月29日下午8:28:37
	 * @param key
	 * @return
	 */
	public OfficeDocument getOfficeDocument(String key) {
		return ht.get(key).clone();
	}
	public void addOfficeDocument(String key,OfficeDocument document) {
		ht.put(key, document);
	}
}
