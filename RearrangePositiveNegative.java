package package1;

public class RearrangePositiveNegative {
	
	public static void main(String[] args) {
		
		int arr[] = { -12, 11, -13, -5, 6, -7, 5, -3, -6 };
		
		rearrange(arr, 0, 0, arr.length-1);
		
		for(int i=0; i < arr.length; i++) {
			
			System.out.print(arr[i] + " ");
		}
	}
	
	public static void swap(int a, int b) {
		
		int temp = a;
		a = b;
		b = temp;
	}
	
	static void rearrange(int arr[], int k, int start, int end) {
		
		int i = start - 1;
		
		int j;
		
		for(j=start; j<=end; j++) {
			
			if(arr[j] < k) {
				
				i++;
				
				//{ -12, 11, -13, -5, 6, -7, 5, -3, -6 };
				
				// swap(arr[i], arr[j]);
				
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		
	}

}
