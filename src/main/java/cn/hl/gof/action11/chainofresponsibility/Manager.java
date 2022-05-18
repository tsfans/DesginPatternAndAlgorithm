package cn.hl.gof.action11.chainofresponsibility;

public class Manager extends Approver{

	public Manager(String name) {
		this.name = name;
	}
	
	@Override
	public void handle(LeaveRequest request) {
		if(request.getTime() < 10) {
			System.out.println("manager "+this.name+" approved "+request.getName()+"'s leave request("+request.getTime()+" days)");
		}else {
			this.approver.handle(request);
		}
	}
}
