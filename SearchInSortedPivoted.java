package package1;

public class SearchInSortedPivoted {
	
	public static void main(String[] args) {
		
		int arr[] = {4, 5, 6, 7, 8, 9, 1, 2, 3};
		int k = 6;
		
		
		int result = findIndex(arr, 0, arr.length-1, k);
		
		System.out.println("Index = " + result);
		
	}
	
	private static int findIndex(int arr[], int start, int end, int k) {
		
		int mid = start + (end-start)/2;
		
		if(arr[mid] == k) {
			
			return mid;
		}
		
		if(arr[start] < arr[mid]) {
			
			if(k < arr[mid] && k >= arr[start]) {
				
				return findIndex(arr, start, mid-1, k);
			}
			else {
				
				return findIndex(arr, mid+1, end, k);
			}
			 
		}
		
		if(arr[end] > arr[mid]) {
			
			if(k > arr[mid] && k <= arr[end]) {
				
				return findIndex(arr, mid+1, end, k);
			}
			else {
				
				return findIndex(arr, start, mid-1, k);
			}
		}
		
		return -1;
		
	}

}
