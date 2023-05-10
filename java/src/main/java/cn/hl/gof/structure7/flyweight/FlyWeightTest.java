package cn.hl.gof.structure7.flyweight;

public class FlyWeightTest {

	public static void main(String[] args) {
		AbstractMedia media1,media2,media3,media4,media5,media6;
		Coordinate c1,c2,c3;
		c1 = new Coordinate(1,1);
		c2 = new Coordinate(2,3);
		c3 = new Coordinate(3,5);
		media1 = TextEditorFactory.getInstance().getMedia("video");
		media2 = TextEditorFactory.getInstance().getMedia("video");
		media3 = TextEditorFactory.getInstance().getMedia("flash");
		media4 = TextEditorFactory.getInstance().getMedia("flash");
		media5 = TextEditorFactory.getInstance().getMedia("picture");
		media6 = TextEditorFactory.getInstance().getMedia("picture");
		media1.insert(c1);
		media3.insert(c3);
		media5.insert(c2);
		System.out.println(media1==media2);
		System.out.println(media3==media4);
		System.out.println(media5==media6);
	}

}
