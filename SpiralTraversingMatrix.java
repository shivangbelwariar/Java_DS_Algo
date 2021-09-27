package package1;

import com.sun.source.tree.WhileLoopTree;

public class SpiralTraversingMatrix {
	
	private int arr[][];
	
	public SpiralTraversingMatrix(int arr[][]) {
		
		this.arr = arr;
		
	}
	
	public void printMatrix() {
		
		int rows = arr.length;
		int column = arr[0].length;
		
//		System.out.println("Rows = " + rows);
//		System.out.println();
//		System.out.println("Column = " + column);
		
		int xlength = column;
		int ylength = rows;
		
		int xstart = 0;
		int ystart = 1;
		
		int i=0, j=0;
		
		int N = rows*column;
		
		while(N > 0) {
			
			
			for(i= xstart; i<xlength; i++) {
				
				System.out.print(arr[j][i] + " ");
				N--;
			}
			
			System.out.println();
			i--;
			xstart++;
			
			for(j=ystart; j<ylength; j++) {
				
				System.out.print(arr[j][i] + " ");
				N--;
			}
			
			System.out.println();
			j--;
			ystart++;
			
		}
		
		
		
	}
}
