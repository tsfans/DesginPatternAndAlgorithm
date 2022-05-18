package cn.hl.gof.structure7.bridge;

public class MysqlDataReader implements DataReader{

	@Override
	public String getData() {
		return "data from mysql";
	}
}
