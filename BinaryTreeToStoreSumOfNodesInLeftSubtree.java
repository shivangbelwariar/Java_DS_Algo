package package1;

public class BinaryTreeToStoreSumOfNodesInLeftSubtree {

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
	    root.leftNode = new Node(2);
	    root.rightNode = new Node(3);
	    root.leftNode.leftNode = new Node(4);
	    root.leftNode.rightNode = new Node(5);
	    root.rightNode.rightNode = new Node(6);
	    
		postorder(root);
		
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
	// Add the left data to the current node to make new value of curr node
	// And return the sum of entire subtree which will be used as left subtree
	public static int postorder(Node root) {
		
		if(root == null) {
			
			return 0;
		}
		
		int left = postorder(root.leftNode);
		int right = postorder(root.rightNode);
		
		int temp = root.data;
		
		root.data += left;
		
		return (temp+left+right);
	}
}
