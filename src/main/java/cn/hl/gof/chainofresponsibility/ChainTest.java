package cn.hl.gof.chainofresponsibility;

public class ChainTest {

	public static void main(String[] args) {
		Approver director,manager,generalManager;
		director = new Director("Bob");
		manager = new Manager("Cat");
		generalManager = new GeneralManager("Dandy");
		director.setApprover(manager);
		manager.setApprover(generalManager);
		LeaveRequest request = new LeaveRequest("Tom",9);
		director.handle(request);
	}
}
