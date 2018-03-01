package cn.hl.gof.bridge;

public class MysqlDataReader implements DataReader{

	@Override
	public String getData() {
		return "data from mysql";
	}
}
