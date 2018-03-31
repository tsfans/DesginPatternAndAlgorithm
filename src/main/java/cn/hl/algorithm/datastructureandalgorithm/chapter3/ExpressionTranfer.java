package cn.hl.algorithm.datastructureandalgorithm.chapter3;

/**
 * 表达式转换
 * @author HULIN
 */
public class ExpressionTranfer {

	/**
	 * 中缀转后缀
     * a+b*c+(d*e+f)*g  -->  abc*+de*f+g*+
	 * @param exp
	 */
	public static void infixToPostfix(String exp) {
		StringBuilder sb = new StringBuilder();
		ArrayStack<Operator> as = new ArrayStack<>();
		Operator[] arr = new Operator[exp.length()];
		for(int i=0;i<exp.length();i++) {
			arr[i] = getOper(exp.charAt(i));
		}
		for(int i=0;i<arr.length;i++) {
			if(arr[i].getPriority()==0) {
				sb.append(arr[i].getNotation());
				continue;
			}
			if(as.size()==0) {
				as.push(arr[i]);
				continue;
			}
			if(arr[i].getPriority()>as.top().getPriority() && arr[i].getPriority()!=4) {
				//优先级比栈顶高的压入栈中(右括号除外)
				as.push(arr[i]);
				continue;
			}
			if(arr[i].getPriority()>as.top().getPriority() && arr[i].getPriority()==4) {
				//遇到右括号,弹出栈元素直到左括号
				while(as.size()>0 && as.top().getPriority()<3) {
						sb.append(as.pop().getNotation());
				}
				as.pop();
			}
			if(arr[i].getPriority()<as.top().getPriority()) {
				//优先级低于等于栈顶元素,弹出栈顶元素直到遇到左括号
				while(as.size()>0 && arr[i].getPriority()<=as.top().getPriority() && as.top().getPriority()!=3) {
						sb.append(as.pop().getNotation());
				}
				as.push(arr[i]);
			}
			
		}
		while(as.size()>0) {
			//输入为空,将栈中元素全部弹出并输出
			sb.append(as.pop().getNotation());
		}
		System.out.println(sb.toString());
	}
	
	private static Operator getOper(char c) {
		if(c=='+' || c=='-') {
			return new Operator(c,1,true);
		}
		if(c=='*' || c=='/') {
			return new Operator(c,2,true);
		}
		if(c=='(') {
			return new Operator(c,3,false);
		}
		if(c==')') {
			return new Operator(c,4,false);
		}
		else {
			return new Operator(c,0,true);
		}
	}
	
	public static void main(String[] args) {
		String exp = "a+b*c+(d*e+f)*g";
		infixToPostfix(exp);
	}
	
	
	
	
	
	
	
	
	
	
	
	static class Operator implements Comparable<Operator>{
		char notation;
		int priority;
		boolean isOut;
		public Operator() {}
		public Operator(char operator,int priority,boolean isOut) {
			this.notation = operator;
			this.priority = priority;
			this.isOut = isOut;
		}
		@Override
		public int compareTo(Operator o) {
			return priority-o.getPriority();
		}
		@Override
		public boolean equals(Object obj) {
			if(this==obj) {
				return true;
			}
			if(obj!=null && obj.getClass()==Operator.class) {
				Operator o = (Operator) obj;
				if(this.getNotation()==o.getNotation()) {
					return true;
				}
			}
			return false;
		}
		public char getNotation() {
			return notation;
		}
		public void setNotation(char operator) {
			this.notation = operator;
		}
		public int getPriority() {
			return priority;
		}
		public void setPriority(int priority) {
			this.priority = priority;
		}
		public boolean isOut() {
			return isOut;
		}
		public void setOut(boolean isOut) {
			this.isOut = isOut;
		}
		
	}
}
