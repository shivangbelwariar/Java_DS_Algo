package package1;

public class RootToLeafPathWithGivenSequence {
	
	static int flag = 0;

	static class Node{
		
		int data;
		Node leftNode;
		Node rightNode;
		Node prevNode;
		Node nextNode;
		
		public Node(int data) {
			
			this.data = data;
			this.leftNode = null;
			this.rightNode = null;
			this.prevNode = null;
			this.nextNode = null;
		}
		
	}
		
	public static void main(String[] args) {
		
		int arr[] = {5, 8, 6, 7};
	    int n = arr.length;
	    Node root = new Node(5);
	    root.leftNode = new Node(3);
	    root.rightNode = new Node(8);
	    root.leftNode.leftNode = new Node(2);
	    root.leftNode.rightNode = new Node(4);
	    root.leftNode.leftNode.leftNode = new Node(1);
	    root.rightNode.leftNode = new Node(6);
	    root.rightNode.leftNode.rightNode = new Node(7);
	    
	    int temp[] = new int[arr.length];
	    
	    preOrder(root, 0, arr, temp);
	    
	    if(flag == 1) {
	    	
	    	System.out.println("Exists");
	    }
	    else {
	    	
	    	System.out.println("Does not Exists");
	    }
	}
	
	
	// Can see recursive solution without using array etc here:
	// https://www.geeksforgeeks.org/check-root-leaf-path-given-sequence/
	public static void preOrder(Node root, int index, int arr[], int temp[]) {
		
		if(root == null) {
			return;
		}
		
		temp[index] = root.data;
		
		if(root.data == arr[arr.length-1] && arr.length == index+1) {
			
			int i;
			
			for(i = 0; i<=index; i++) {
				
				if(arr[i] != temp[i]){
					
					break;
					
				}
			}
			
			if(i == index+1) {
				
				flag = 1;
			}
		}
		
		index++;
		
		preOrder(root.leftNode, index, arr, temp);
		preOrder(root.rightNode, index, arr, temp);
	}
	
}
