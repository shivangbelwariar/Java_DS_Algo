package package1;

public class InsertionInBST {
	
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
		
		
		Node rootNode = insertKey(50, null);
		rootNode = insertKey(30, rootNode);
		rootNode = insertKey(20, rootNode);
		rootNode = insertKey(40, rootNode);
		rootNode = insertKey(70, rootNode);
		rootNode = insertKey(60, rootNode);
		rootNode = insertKey(80, rootNode);
		
		inorder(rootNode);
		
	}
	
	public static void inorder(Node root) {
		
		if(root == null) {
			
			return;
		}
		
		inorder(root.leftNode);
		
		System.out.print(root.data + " ");
		
		inorder(root.rightNode);
	}
	
	public static Node insertKey(int key, Node root) {
		
		if(root == null) {
			
			Node tempNode = new Node(key);
			return tempNode;
		}
		
		if(key < root.data) {
			
			root.leftNode = insertKey(key, root.leftNode);
		}
		else {
			
			root.rightNode = insertKey(key, root.rightNode);
		}
		
		return root;
	}

}
