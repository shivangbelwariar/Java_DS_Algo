package package1;

public class LastIndexOfOne {
	
	public static void main(String[] args) {
		
		LastIndexOfOne lastIndexOfOne = new LastIndexOfOne();
		
		StringBuffer str = new StringBuffer("00001");
		
//		int result = lastIndexOfOne.lastIndex(str);
//		
//		System.out.println(result);
		
		int[][] matrix = {{1,2,3}, {4,5,6}, {7,8,9}, {10,11,12}};
		
		SpiralTraversingMatrix spiralTraversingMatrix 
		= new SpiralTraversingMatrix(matrix);
		
		spiralTraversingMatrix.printMatrix();
	}
	
	public int lastIndex(StringBuffer str) {
		
		int i, result = -1;
		
		for(i=0; i<str.length(); i++) {
			
			if(str.charAt(i) == '1') {
				
				result = i;
			}
		}
		
		return result;
	}

}
