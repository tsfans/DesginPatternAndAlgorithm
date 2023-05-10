package cn.hl.gof.structure7.bridge;

public class RedisDataReader implements DataReader{

	@Override
	public String getData() {
		return "data from redis";
	}
}
