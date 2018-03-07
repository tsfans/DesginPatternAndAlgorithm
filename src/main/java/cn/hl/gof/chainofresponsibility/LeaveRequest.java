package cn.hl.gof.chainofresponsibility;

public class LeaveRequest {

	private String name;
	
	private Integer time;

	public LeaveRequest() {}
	
	public LeaveRequest(String name,Integer time) {
		this.name = name;
		this.time = time;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getTime() {
		return time;
	}

	public void setTime(Integer time) {
		this.time = time;
	}
	
}
