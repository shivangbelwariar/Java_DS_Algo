package package1;

public class CountSubsetsWithSumEqualX {
	
	public static void main(String[] args) {
		
		int arr[] = { 1, 1, 1, 1 };
		
		int T[][] = new int[1000][1000];
		
		for(int i=0; i<1000; i++) {
			
			for(int j=0; j<1000; j++) {
				
				T[i][j] = -1;
			}
		}
		
		Integer count = countMemoized(arr, arr.length-1, 1, T);
		
		System.out.println("Count = " + count);
	}
	
	public static int countMemoized(int arr[], int n, int sum, int T[][]) {
		
		// VERY VERY VERY IMPORTANT
		// IN RECURSION, THE ORDER OF WRITING THE BASE CONDITION MATTERS
		// IN THIS EXAMPLE, IF (sum ==0)return1; STATEMENT WAS WRITTEN
		// AFTER THE NEXT 2 BASE STATEMENT, THEN THE OUTPUT WOULD BE WRONG
		// THIS IS BECAUSE WHEN YOU DRWA THE RECURSIVE TREE, YOU WILL SEE THAT
		// IN SOME CASES, n becomes -1 & SUM BECOMES 0 AT SAME TIME
		// IN THAT CASE, YOU WILL MISS THE +1 FROM sum==0 BASE CONDITION
		// IF IT WAS WRITTEN LATER.
		//SO "ALWAYS DRAW THE RECURSIVE TREE AND ANALYSE THE PROBLEM TO VERIFY CORRECTNESS"
		if(sum == 0) {
			
			return 1;
		}
		
		if(sum < 0) {
			
			return 0;
		}
		
		if(n < 0) {
			
			return 0;
		}
		
		if(T[n][sum] != -1) {
			
			return T[n][sum];
		}
		
		if(arr[n] > sum) {
			
			return T[n][sum] = countMemoized(arr, n-1, sum, T);
		}
		
		return T[n][sum] = 
				countMemoized(arr, n-1, sum, T) + countMemoized(arr, n-1, sum-arr[n], T);
	}
	
	public static int count(int arr[], int n, int sum) {
		
		// VERY VERY VERY IMPORTANT
		// IN RECURSION, THE ORDER OF WRITING THE BASE CONDITION MATTERS
		// IN THIS EXAMPLE, IF (sum ==0)return1; STATEMENT WAS WRITTEN
		// AFTER THE NEXT 2 BASE STATEMENT, THEN THE OUTPUT WOULD BE WRONG
		// THIS IS BECAUSE WHEN YOU DRWA THE RECURSIVE TREE, YOU WILL SEE THAT
		// IN SOME CASES, n becomes -1 & SUM BECOMES 0 AT SAME TIME
		// IN THAT CASE, YOU WILL MISS THE +1 FROM sum==0 BASE CONDITION
		// IF IT WAS WRITTEN LATER.
		//SO "ALWAYS DRAW THE RECURSIVE TREE AND ANALYSE THE PROBLEM TO VERIFY CORRECTNESS"
		if(sum == 0) {
			
			return 1;
		}
		
		if(sum < 0) {
			
			return 0;
		}
		
		if(n < 0) {
			
			return 0;
		}
		
		if(arr[n] > sum) {
			
			return count(arr, n-1, sum);
		}
		
		return count(arr, n-1, sum) + count(arr, n-1, sum-arr[n]);
	}

}
