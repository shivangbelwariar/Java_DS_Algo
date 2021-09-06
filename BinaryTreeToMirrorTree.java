package package1;

public class BinaryTreeToMirrorTree {

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
	
	public static void postOrder(Node root) {
		
		if(root == null) {
			return;
		}
		
		postOrder(root.leftNode);
		
		postOrder(root.rightNode);
		
		Node tempNode = root.leftNode;
		
		root.leftNode = root.rightNode;
		
		root.rightNode = tempNode;
	}
}
