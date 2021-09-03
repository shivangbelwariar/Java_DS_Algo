package package1;

import java.util.Stack;

public class ReverseStackRecursion {
	
	public static void reverseStackUtil(Stack<Integer> st, int temp) {
		
		if(st.isEmpty()) {
			
			st.push(temp);
		}
		else {
			
			int var = st.peek();
			
			st.pop();
			
			reverseStackUtil(st, temp);
			
			st.push(var);
		}
		
		
		
		
	}
	
	public static void reverseStack(Stack<Integer> st) {
		
		if(st.isEmpty()) {
			
			return;
		}
		
		int temp = st.peek();
		
		st.pop();
		
		reverseStack(st);
		
		reverseStackUtil(st, temp);
	}
	
	
	public static void main(String[] args) {
		
		Stack<Integer> st = new Stack<>();
		
		st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
		
        for(int i : st) {
			
			System.out.print(i + " ");
		}
        
        System.out.println();
        System.out.println();
        
		reverseStack(st);
		
		for(int i : st) {
			
			System.out.print(i + " ");
		}
	}

}
