package cn.hl.gof.prototype;

public interface OfficeDocument extends Cloneable{

	public OfficeDocument clone() throws CloneNotSupportedException;
	public void display();
}
