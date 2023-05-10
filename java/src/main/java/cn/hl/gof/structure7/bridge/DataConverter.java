package cn.hl.gof.structure7.bridge;

public abstract class DataConverter {

	protected DataReader data;
	
	public void setData(DataReader data) {
		this.data = data;
	}
	
	protected abstract void convert(); 
}
