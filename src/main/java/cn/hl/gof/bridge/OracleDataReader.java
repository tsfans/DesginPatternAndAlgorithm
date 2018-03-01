package cn.hl.gof.bridge;

public class OracleDataReader implements DataReader{

	@Override
	public String getData() {
		return "data from oracle";
	}
}
