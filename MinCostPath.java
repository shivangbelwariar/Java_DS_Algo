package package1;

public class MinCostPath {

	public static void main(String[] args) {
		
		int cost[][]= { {1, 8, 8, 1, 5},
                {4, 1, 1, 8, 1},
                {4, 2, 8, 8, 1},
                {1, 5, 8, 8, 1} };
		
		int result = solution(cost, 3, 4, 0, 0);
		
		System.out.println("Min Cost = " + result);
	}
	
	
	
	public static int solution(int arr[][], int xEnd, int yEnd, int xStart, int yStart) {
		
		if(xStart > xEnd || yStart > yEnd) {
			
			//returning max int value as out logic will always reject this as
			// our logic is finding the minimum value
			return Integer.MAX_VALUE;
		}
		
		if(xStart == xEnd && yStart == yEnd) {
			
			return arr[xStart][yStart];
		}
		
		return arr[xStart][yStart] + 
				Math.min(solution(arr, xEnd, yEnd, xStart+1, yStart), 
						Math.min(solution(arr, xEnd, yEnd, xStart, yStart+1)
								, solution(arr, xEnd, yEnd, xStart+1, yStart+1)));
		
		
	}
}
