package cn.hl.gof.bridge;

public class RedisDataReader implements DataReader{

	@Override
	public String getData() {
		return "data from redis";
	}
}
