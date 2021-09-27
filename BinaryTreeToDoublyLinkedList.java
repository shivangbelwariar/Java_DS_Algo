package package1;

	public class BinaryTreeToDoublyLinkedList {
		
		public static Node headNode = null;
		public static Node prevNode = null;

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
        root.leftNode = new Node(12);
        root.rightNode = new Node(15);
        root.leftNode.leftNode = new Node(25);
        root.leftNode.rightNode = new Node(30);
        root.rightNode.leftNode = new Node(36);
		
		inorder(root);
		
		while(headNode != null) {
			
			System.out.print(headNode.data + " ");
			headNode = headNode.nextNode;
		}
	}
	
	
	public static void inorder(Node root) {
		
		if(root == null) {
			
			return;
		}	
	
		inorder(root.leftNode);
		
		if(prevNode == null) {
			
			headNode = root;
			if(root != null) {
				prevNode = root;
			}
		}
		else {
			
			root.prevNode = prevNode;
			prevNode.nextNode = root;
			if(root != null) {
				prevNode = root;
			}
		}
		
		inorder(root.rightNode);
		
	}
}
