package cn.hl.gof.structure7.bridge;

public class OracleDataReader implements DataReader{

	@Override
	public String getData() {
		return "data from oracle";
	}
}
