package package1;

public class EqualPartitionProblem {

	public static void main(String[] args) {
		
		int arr[] = { 1, 5, 11, 5 };
		int size = arr.length;
		
		int sum = 0;
		
		for(int i = 0; i<size; i++) {
			
			sum += arr[i];
		}
		
		int T[][] = new int[1000][1000];
		
		for(int i=0; i<1000; i++) {
			
			for(int j=0; j<1000; j++) {
				
				T[i][j] = -1;
			}
		}
		
		boolean result;
		
		if(sum %2 != 0) {
			
			result = false;
		}
		else {
			
			result = findEqualPartitionMemoized(arr, size-1, (sum/2), T);
		}
		
		System.out.println("Equal Partition Exists? " + result);
		
		
	}
	
	public static boolean findEqualPartitionMemoized(int arr[], int n, int halfSum, int T[][]) {
		
		if(n < 0 || halfSum < 0) {
			
			return false;
		}
		
		if(halfSum == 0) {
			
			return true;
		}
		
		if(T[n][halfSum] == 1) {
			
			return true;
		}
		
		if(T[n][halfSum] == 0) {
			
			return false;
		}
		
		
		if(arr[n] > halfSum) {
			
			boolean temp = findEqualPartition(arr, n-1, halfSum);
			
			if(temp == true) {
				
				T[n][halfSum] = 1;
			}
			else {
				
				T[n][halfSum] = 0;
			}
			return temp;
		}
		
		// CAN TO IMPROVEMENT HERE. INSTEAD OF CALLING BOTH THE RECUSRIVE CALLS,
		// WE CAN CALL ONE AND THEN PUT THE VALUE AND THEN CALL THE SECOND CALL
		// IMPROVEMENT IMPLEMENTED BELOW (COMMENTED NOW)
		boolean temp = (findEqualPartition(arr, n-1, halfSum) 
				|| findEqualPartition(arr, n-1, halfSum-arr[n]));
		
		if(temp == true) {
			
			T[n][halfSum] = 1;
		}
		else {
			
			T[n][halfSum] = 0;
		}
		return temp;
		
		// IMPORTANT...CHECK THE FURTHER IMPROVEMENT TO ABOVE MEMOIZED SOLUTION
		// BELOW: --->
		
		/*
		 boolean temp = findEqualPartition(arr, n-1, halfSum);
		
		if(temp == true) {
			
			T[n][halfSum] = 1;
		}
		else {
			
			T[n][halfSum] = 0;
		}
		
		boolean temp2 = findEqualPartition(arr, n-1, halfSum-arr[n]);
		
		if(temp2 == true) {
			
			T[n][halfSum] = 1;
		}
		else {
			
			T[n][halfSum] = 0;
		}

		return (temp || temp2);
		 
		*/
		
	}
	
	public static boolean findEqualPartition(int arr[], int n, int halfSum) {
		
		if(n < 0 || halfSum < 0) {
			
			return false;
		}
		
		if(halfSum == 0) {
			
			return true;
		}
		
		if(arr[n] > halfSum) {
			
			return findEqualPartition(arr, n-1, halfSum);
		}
		
		return (findEqualPartition(arr, n-1, halfSum) 
				|| findEqualPartition(arr, n-1, halfSum-arr[n])); 
	}
	
}
