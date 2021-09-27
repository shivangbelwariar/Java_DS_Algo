package package1;

import java.util.Arrays;

public class minimumPlatform {
	
	public static void main(String[] args) {
		
		minimumPlatform minimumPlatform1 = new minimumPlatform();
		
		int arr[] = { 900, 940, 950, 1100, 1500, 1800 };
	    int dep[] = { 910, 1200, 1120, 1130, 1800, 2000 };
		
		int result = minimumPlatform1.minPlatformResult(arr, dep);
		
		System.out.println("Minimum Platform = " + result);
	}
	
	public int minPlatformResult(int arr[], int dep[]) {
		
		int result = 0;
		int i = 0, j = 0;
		int max = -1;
		
		Arrays.sort(arr);
		Arrays.sort(dep);
		
		while(i<arr.length && j<dep.length) {
			
			if(arr[i] < dep[j]) {
				
				result++;
				i++;
				
				max = Math.max(result, max);
			}
			else if(arr[i] > dep[j]){
				
				result--;
				j++;
			}
			else {
				
				i++;
				j++;
			}
		}
		
		return max;
	}

}
