package package1;

//https://www.geeksforgeeks.org/program-for-nth-fibonacci-number/

public class ProgramForFibonacciNumbers {

	public static void main(String[] args) {
		
		int input = 20;
		
		int result = nthFibonacciNumber(input);
		
		System.out.println("Result = " + result);
	}
	
	public static int nthFibonacciNumber(int n) {
		
		if(n==0) {
			
			return 0;
		}
		
		if(n==1) {
			
			return 1;
		}
		
		int superPrev = 0;
		int prev = 1;
		
		int temp = 0;
		
		while(n>1) {
			
			temp = superPrev + prev;
			superPrev = prev;
			prev = temp;
			n--;
		}
		
		return temp;
	}
}
