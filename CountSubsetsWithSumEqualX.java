package package1;

public class CountSubsetsWithSumEqualX {
	
	public static void main(String[] args) {
		
		int arr[] = { 3, 3, 3, 3 };
		
		Integer count = count(arr, arr.length-1, 6);
		
		System.out.println("Count = " + count);
	}
	
	public static int count(int arr[], int n, int sum) {
		
		if(sum < 0) {
			
			return 0;
		}
		
		if(n < 0) {
			
			return 0;
		}
		
		if(sum == 0) {
			
			return 1;
		}
		
		if(arr[n] > sum) {
			
			return count(arr, n-1, sum);
		}
		
		return count(arr, n-1, sum) + count(arr, n-1, sum-arr[n]);
	}

}
