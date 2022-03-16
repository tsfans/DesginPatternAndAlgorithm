package cn.hl.gof.structure7.flyweight;

public abstract class AbstractMedia {

	abstract protected String getMediaType();
	
	public void insert(Coordinate coordinate) {
		System.out.printf("insert %s into texteditor on (%s,%s)",
				this.getMediaType(),
				coordinate.getX(),
				coordinate.getY());
		System.out.println();
	};
	
}
