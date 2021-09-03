package package1;

import java.util.Stack;

public class EvaluatePostfix {
	
	public static void main(String[] args) {
		
		String str = "231*+9-";
		
		int result = calculatePostfix(str);
		
		System.out.println("Result = " + result);
		
	}
	
	static int calculate(int a, int b, int expr) {
		
		int result = -9999;
		
		if(expr == '*') {
			
			result = a * b;
		}
		else if(expr == '+') {
			
			result = a + b;
		}
		else if(expr == '-') {
			
			result = a - b;
		}
		else if(expr == '/') {
			
			result = a / b;
		}
		
		
		return result;
	}

	private static int calculatePostfix(String str) {
		
		int result;
		
		Stack<Integer> st = new Stack<>();
		
		for(int i=0; i<str.length(); i++) {
			
			char c = str.charAt(i);
			
			if(Character.isDigit(c)) {
				
				st.push(c - '0');
			}
			else {
				
				int b = st.pop();
				int a = st.pop();
				
				int temp = calculate(a,b,c);
				
				st.push(temp);
			}
		}
		
		result = st.pop();
		
		return result;
	}
}
