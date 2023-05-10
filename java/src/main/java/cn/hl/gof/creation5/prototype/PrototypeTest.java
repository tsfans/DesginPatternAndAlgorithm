/**
 * 
 */
package cn.hl.gof.creation5.prototype;

/**
 * <p></p>
 * @author HULIN
 * @date 2018年1月29日下午8:29:55
 * @version
 */
public class PrototypeTest {

	public static void main(String[] args) {
		PrototypeManager pm = PrototypeManager.getInstance();
		OfficeDocument doc1,doc2,doc3,doc4,doc5,doc6;
		doc1 = pm.getOfficeDocument("far");
		doc2 = pm.getOfficeDocument("far");
		doc3 = pm.getOfficeDocument("srs");
		doc4 = pm.getOfficeDocument("srs");
		pm.addOfficeDocument("ppr", new PPR());
		doc5 = pm.getOfficeDocument("ppr");
		doc6 = pm.getOfficeDocument("ppr");
		doc1.display();
		doc2.display();
		doc3.display();
		doc4.display();
		doc5.display();
		doc6.display();
		System.out.println(doc1==doc2);
		System.out.println(doc3==doc4);
		System.out.println(doc5==doc6);
	}
}
