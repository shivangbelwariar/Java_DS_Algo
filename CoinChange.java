package package1;

public class CoinChange {

	public static void main(String[] args) {
		
		int arr[] = { 1,2,3 };
		
		int T[][] = new int[1000][1000];
		
		int i,j;
		
		for(i=0; i<1000; i++) {
			
			for(j=0; j<1000; j++) {
				
				T[i][j] = -1;
			}
		}
		
		int result = coinChangeSolutionMemoized(arr, 4, arr.length-1, T);
		
		System.out.println("Total ways = " + result);
	}
	
	public static int coinChangeSolutionMemoized(int arr[], int sum, int n, int T[][]) {
		
		if(n < 0) {
			
			return 0;
		}
		
		if(sum == 0) {
			
			return 1;
		}
		
		if(T[sum][n] != -1) {
			
			return T[sum][n];
		}
		
		if(arr[n] > sum) {
			
			return T[sum][n] = coinChangeSolutionMemoized(arr, sum, n-1, T);
		}
		
		return T[sum][n] = 
				coinChangeSolutionMemoized(arr, sum, n-1, T) 
				+ coinChangeSolutionMemoized(arr, sum-arr[n], n, T);
		
		
	}
	
	public static int coinChangeSolution(int arr[], int sum, int n) {
		
		if(n < 0) {
			
			return 0;
		}
		
		if(sum == 0) {
			
			return 1;
		}
		
		if(arr[n] > sum) {
			
			return coinChangeSolution(arr, sum, n-1);
		}
		
		return coinChangeSolution(arr, sum, n-1) 
				+ coinChangeSolution(arr, sum-arr[n], n);
		
		
	}
}
