package package1;

public class TrappingRainWater {
	
	public static void main(String[] args) {
		
		int[] arr = { 2, 0, 2 };
		
		int result = maxWaterTrapped(arr);
		
		System.out.println("Total water that can be trapped = " + result);
	}
	
	public static int maxWaterTrapped(int arr[]) {
		
		int lgreatest[] = new int[arr.length];
		int rgreatest[] = new int[arr.length];
		
		lgreatest[0] = 0;
		rgreatest[arr.length-1] = 0;
		
		int lmax = Integer.MIN_VALUE;
		int rmax = Integer.MIN_VALUE;
		
		for(int i = 1; i < arr.length; i++) {
			
			if(arr[i-1] > lmax) {
				
				lmax = arr[i-1];
			}
			
			lgreatest[i] = lmax;
		}
		
		
		for(int j = arr.length-2; j>=0; j--) {
			
			if(arr[j+1] > rmax) {
				
				rmax = arr[j+1];
			}
			
			rgreatest[j] = rmax; 
		}
		
		int sum = 0;
		
		for(int i = 1; i<arr.length-1; i++) {
			
			System.out.print(rgreatest[i] + " ");
//			System.out.println();
//			System.out.print(rgreatest[i] + " ");
//			System.out.println();
			
			if(Math.min(lgreatest[i], rgreatest[i]) - arr[i] > 0) {
				
				sum = sum + Math.min(lgreatest[i], rgreatest[i]) - arr[i];
			}
			
			
			// 0 1 1 2 2 2 2 3 3 3
			// 3 3 3 3 3 3 2 2 2 1
		}
		
		return sum;
	}

}
