package package1;


public class ConvertTreeToSumTree {

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
		
		Node root = new Node(10);
        root.leftNode = new Node(-2);
        root.rightNode = new Node(6);
        root.leftNode.leftNode = new Node(8);
        root.leftNode.rightNode = new Node(-4);
        root.rightNode.leftNode = new Node(7);
        root.rightNode.rightNode = new Node(5);
        
        postOrder(root);
        
        inorder(root);
			
	}
	
	public static void inorder(Node root) {
		
		if(root == null) {
			
			return;
		}
		
		inorder(root.leftNode);
		
		System.out.print(root.data + " ");
		
		inorder(root.rightNode);
	}
	
	
	// APPROACH:
	// Calculate left and right's sum
	// store the current node's value in a temp variable
	// now replace current' node's value as left+right
	// return the temp+left+right
	public static int postOrder(Node root) {
		
		if(root == null) {
			
			return 0;
		}
		
		int left = postOrder(root.leftNode);
		int right = postOrder(root.rightNode);
		
		int temp = root.data;
		
		root.data = left + right;
		
		return (temp + left + right);
	}
}
