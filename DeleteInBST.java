package package1;

public class DeleteInBST {

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
		System.out.println();
		
		rootNode = deleteNode(20, rootNode);
		
		inorder(rootNode);
		System.out.println();
		
		
		rootNode = deleteNode(30, rootNode);
		
		inorder(rootNode);
		System.out.println();
		
		rootNode = deleteNode(50, rootNode);
		
		inorder(rootNode);
		System.out.println();
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
	
	public static void inorder(Node root) {
		
		if(root == null) {
			
			return;
		}
		
		inorder(root.leftNode);
		
		System.out.print(root.data + " ");
		
		inorder(root.rightNode);
	}
	
	public static Node deleteNode(int key, Node root) {
		
		if(root == null) {
			
			return root;
		}
		
		if(root.data > key) {
			
			root.leftNode = deleteNode(key, root.leftNode);
		}
		else if(root.data < key) {
			
			root.rightNode = deleteNode(key, root.rightNode);
		}
		else {
			
			if(root.leftNode == null && root.rightNode == null) {
				
				return null;
			}
			else if(root.leftNode == null) {
				
				return root.rightNode;
			}
			else if(root.rightNode == null) {
				
				return root.leftNode;
			}
			else {
				
				Node tempNode = root.rightNode;
				
				while(tempNode.leftNode != null) {
					
					tempNode = tempNode.leftNode;
				}
				
				root.data = tempNode.data;
				
				deleteNode(tempNode.data, root.rightNode);
			}
			
		}
		
		return root;
	}
}
