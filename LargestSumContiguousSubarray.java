package package1;

public class LargestSumContiguousSubarray {

	public static void main(String[] args) {
		
		int [] a = {-2, -3, 4, -1, -2, 1, 5, -3};
		
		int result = solution(a);
		
		System.out.println("Largest Sum Contiguous Subarray = " + result);
	}
	
	public static int solution(int arr[]) {
		
		int maxTillHere = 0;
		
		int maximum = Integer.MIN_VALUE;
		
		for(int i=0; i<arr.length; i++) {
			
			maxTillHere += arr[i];
			
			if(maxTillHere < 0) {
				maxTillHere = 0;
			}
			
			if(maximum < maxTillHere) {
				
				maximum = maxTillHere;
			}
		}
		
		return maximum;
	}
}
