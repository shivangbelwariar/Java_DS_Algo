package package1;

public class CountWaysToReachTheNthStair {

	public static void main(String[] args) {
		
		int result = solution(4);
		
		System.out.println("Total ways = " + result);
	}
	
	public static int solution(int n) {
		
		if(n <= 0) {
			
			return 0;
		}
		
		if(n == 1) {
			
			return 1;
		}
		
		if(n == 2) {
			
			return 2;
		}
		
		// Apply memoization here
		return solution(n-1) + solution(n-2);
	}
}
