package cn.hl.gof.action11.observer;

public class ObserverTest {

	
	
	public static void main(String[] args) {
		Share share1 = new Share(2000d,"baidu");
		Share share2 = new Share(3000d,"jd");
		ShareHolder s1,s2,s3,s4,s5;
		s1 = new ShareHolder("andy");
		s2 = new ShareHolder("bob");
		s3 = new ShareHolder("cat");
		s4 = new ShareHolder("david");
		s5 = new ShareHolder("emma");
		share1.addObserver(s1);
		share1.addObserver(s5);
		share1.addObserver(s3);
		share2.addObserver(s4);
		share2.addObserver(s2);
		share2.addObserver(s3);
		share1.change(1500d);
		share2.change(4500d);
	}
}
