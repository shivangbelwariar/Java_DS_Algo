package package1;

public class CountOneInSorted {

	public static void main(String[] args) {
		
		int arr[] = { 0, 0, 0, 0, 0, 0, 0 };
		
		int result = countOnes(arr, 0, arr.length-1);
		
		if(result == -1) {
			
			System.out.println("total 1 = 0");
		}
		else {
			
			System.out.println("total 1 = " + (arr.length-result));
		}
		
	}
	
	protected static int countOnes(int arr[], int start, int end) {
		
		int mid = start + (end-start)/2;
		
		if(arr[mid] == 1) {
			
			if(mid > 0 && arr[mid-1] == 0) {
				
				return mid;
			}
			else if(mid > 0 && arr[mid-1] == 1){
				
				return countOnes(arr, start, mid-1);
			}
			else {
				
				return 0;
			}
		}
		
		else {
			
			if(mid < arr.length-1) {
				
				countOnes(arr, mid+1, end);
			}
		}
		
		return -1;
	}
}
