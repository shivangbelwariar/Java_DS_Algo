package package1;

public class PartitionInTwoSubsetsDifferenceIsMinimum {
	
	int diff = 0;
	
	public static void main(String[] args) {
		
		int arr[] = { 1, 6, 11, 5 };
        int n = arr.length;
        
        int sum = 0;
        
        for(int i=0; i<n; i++) {
        	
        	sum += arr[i];
        }
        
        int T[][] = new int[1000][1000];
        
        for(int i=0; i<1000; i++) {
        	
        	for(int j=0; j<1000; j++) {
        		
        		T[i][j] = -1;
        	}
        }
        
        sumOfPartitionMemoized(arr, n-1, sum, sum, T);
		
		System.out.println("Minimum difference = " + min);
	}
	
	static int min = Integer.MAX_VALUE;
	
	public static void sumOfPartitionMemoized(int arr[], int n, int sum, int sumUnchanged, int T[][]) {
		
		if(n < 0) {
			
			return;
		}
		
		if(T[n][sum] != -1) {
			
			return;
		}
		
		if(Math.abs(sumUnchanged - 2*sum) < min) {
			
			min = Math.abs(sumUnchanged - 2*sum);
			T[n][sum] = min;
		}
		
		sumOfPartitionMemoized(arr, n-1, sum, sumUnchanged, T);
		
		sumOfPartitionMemoized(arr, n-1, sum-arr[n], sumUnchanged, T);
	}
	
	// APPROACH:
	// HERE, I AM USING TAKING BOTH THE CASE:
	// 1. CONSIDERING THE ELEMENT IN THE SUBSET AND SO REDUCING THE SUM
	// 2. NOT CONSIDERING THE ELEMENT AND MOVING TO NEXT ELEMENT
	// I AM THEN CHECKING AT EVERY POINT THAT IF THE DIFFERENCE IS MINIMUM
	// FOR THAT I AM USING "sumUnchanged" VARIABLE. AND STORING THE MINIMIM
	// TO min VARIABLE
	// IN THE END I AM PRINTING min VARIABLE
	public static void sumOfPartition(int arr[], int n, int sum, int sumUnchanged) {
		
		if(n < 0) {
			
			return;
		}
		
		if(Math.abs(sumUnchanged - 2*sum) < min) {
			
			min = Math.abs(sumUnchanged - 2*sum);
		}
		
		sumOfPartition(arr, n-1, sum, sumUnchanged);
		
		sumOfPartition(arr, n-1, sum-arr[n], sumUnchanged);
	}

}
