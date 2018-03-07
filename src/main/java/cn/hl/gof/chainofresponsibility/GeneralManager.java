package cn.hl.gof.chainofresponsibility;

public class GeneralManager extends Approver{

	public GeneralManager(String name) {
		this.name = name;
	}
	@Override
	public void handle(LeaveRequest request) {
		if(request.getTime() < 30) {
			System.out.println("general manager "+this.name+" approved "+request.getName()+"'s leave request("+request.getTime()+" days)");
		}else {
			System.out.println("general manager "+this.name+" refused "+request.getName()+"'s leave request("+request.getTime()+" days)");
		}
	}
}
