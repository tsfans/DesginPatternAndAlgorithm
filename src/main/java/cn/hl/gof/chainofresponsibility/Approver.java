package cn.hl.gof.chainofresponsibility;

public abstract class Approver {

	protected Approver approver;
	
	protected String name;
	
	public Approver() {}
	
	public Approver(String name) {
		this.name = name;
	}
	
	public void setApprover(Approver approver) {
		this.approver = approver;
	}
	public abstract void handle(LeaveRequest request);
}
