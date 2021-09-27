package package1;


public class FindLargestSubtreeSumInTree {

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
		
		Node root = new Node(1);
	    root.leftNode = new Node(-2);
	    root.rightNode = new Node(3);
	    root.leftNode.leftNode = new Node(4);
	    root.leftNode.rightNode = new Node(5);
	    root.rightNode.leftNode = new Node(-6);
	    root.rightNode.rightNode = new Node(2);
	    
	    postOrder(root);
	    
	    System.out.println("Max = " + max);
	}
	
	private static int max = Integer.MIN_VALUE;
	
	public static int postOrder(Node root) {
		
		if(root == null) {
			
			return 0;
		}
		
		int left = postOrder(root.leftNode);
		int right = postOrder(root.rightNode);
		
		int temp = root.data + left + right;
		
		if(temp > max) {
			
			max = temp;
		}
		
		return temp;
		
	}
}
