/**
 * 
 */
package cn.hl.gof.creation5.prototype;

public class SRS implements OfficeDocument{
	@Override
	public OfficeDocument clone() {
		OfficeDocument srs = null;
		try {
			srs = (OfficeDocument)super.clone();
		}catch(CloneNotSupportedException e) {
			System.out.println("不支持复制!");
		}
		return srs;
	}
	@Override
	public void display() {
		System.out.println("《软件需求规格说明书》");
	}
}
