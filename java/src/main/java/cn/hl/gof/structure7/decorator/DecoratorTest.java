package cn.hl.gof.structure7.decorator;

public class DecoratorTest {

	public static void main(String[] args) {
		Encoder encoder = new ModEncoder(new ReverseEncoder(new ShiftEncoder()));
		System.out.println(encoder.encode("abc123"));
	}

}
