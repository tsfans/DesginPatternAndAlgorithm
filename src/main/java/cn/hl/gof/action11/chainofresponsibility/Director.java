package cn.hl.gof.action11.chainofresponsibility;

public class Director extends Approver{

	public Director(String name) {
		super(name);
	}
	@Override
	public void handle(LeaveRequest request) {
		if(request.getTime() < 3) {
			System.out.println("director "+this.name+" approved "+request.getName()+"'s leave request("+request.getTime()+" days)");
		}else {
			this.approver.handle(request);
		}
	}
}
