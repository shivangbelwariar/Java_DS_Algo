package package1;

public class ArrayCanRepresentPreorderBST {

	static class Node{
		
		int data;
		Node leftNode;
		Node rightNode;
		
		public Node(int data) {
			
			this.data = data;
			this.leftNode = null;
			this.rightNode = null;

		}
		
	}
		
	public static void main(String[] args) {
	
		//int[] pre1 = new int[]{40, 30, 35, 80, 100};
		
		 int[] pre1 = new int[]{40, 30, 35, 20, 80, 100};
		
		
		checkPreorder(pre1, 0, pre1.length-1);
		
		System.out.println("Flag = " + flag);
	}
	
	protected static int flag = 1;
	
	
	// APPROACH:
	// For preorder, the fist element is the root
	// Now we need to find the first next element which is greater than the root (first element)
	// Once we find, this will represent preorder only when
	// None of the next element in the array is smaller thant the first element
	// As this is BST, root can never be less than any child of its right subtree
	// Changing the flag value from 1 to 0
	// THIS SOLUTION ASSUMES THAT ALL VALUES ARE UNIQUE. IF NOT UNIQUE THEN IT CANNOT BE BST
	public static void checkPreorder(int arr[], int start, int end) {
		
		if(start >= end) {
			
			return;
		}
		
		int i, j;
		
		for(i=start+1; i <= end; i++) {
			
			if(arr[i] > arr[start]) {
				break;
			}
		}
		
		for(j=i; j<=end; j++) {
			
			if(arr[j] < arr[start]) {
				
				flag = 0;
			}
		}
		
		checkPreorder(arr, start+1, i-1);
		
		checkPreorder(arr, i, end);
	}
}
