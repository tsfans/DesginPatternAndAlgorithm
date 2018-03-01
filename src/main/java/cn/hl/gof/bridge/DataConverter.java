package cn.hl.gof.bridge;

public abstract class DataConverter {

	protected DataReader data;
	
	public void setData(DataReader data) {
		this.data = data;
	}
	
	protected abstract void convert(); 
}
