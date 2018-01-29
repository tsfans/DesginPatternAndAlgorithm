/**
 * 
 */
package cn.hl.gof.prototype;

/**
 * <p></p>
 * @author HULIN
 * @date 2018年1月29日下午8:34:17
 * @version
 */
public class PPR implements OfficeDocument{

	@Override
	public OfficeDocument clone() {
		OfficeDocument ppr = null;
		try {
			ppr = (OfficeDocument) super.clone();
		}catch(CloneNotSupportedException e) {
			System.out.println("不支持复制!");
		}
		return ppr;
	}
	
	@Override
	public void display() {

		System.out.println("《项目进展报告》");
	}
}
