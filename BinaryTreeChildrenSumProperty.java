package package1;

public class BinaryTreeChildrenSumProperty {

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
	
	public static void inorder(Node root) {
		
		if(root == null) {
			
			return;
		}
		
		inorder(root.leftNode);
		
		System.out.print(root.data + " ");
		
		inorder(root.rightNode);
	}

	public static void main(String[] args) {
		
		Node root = new Node(50);
        root.leftNode = new Node(7);
        root.rightNode = new Node(2);
        root.leftNode.leftNode = new Node(3);
        root.leftNode.rightNode = new Node(5);
        root.rightNode.leftNode = new Node(1);
        root.rightNode.rightNode = new Node(30);
		
		postorder(root);
		
		inorder(root);
	}
	
	
	// Approach:
	// Traverse in postorder and then check to maintain the sum relation
	// If not maintaining and root.data > the sum of children,
	// try to increment left child's till possible
	// If not, increase right child's data and then subsequently increment
	// right child's left children data
	public static void postorder(Node root) {
		
		if(root == null) {
			
			return;
		}
		
		postorder(root.leftNode);
		
		postorder(root.rightNode);
		
		int left, right;
		
		if(root.leftNode != null) {
			
			left = root.leftNode.data;
		}
		else {
			left = 0;
		}
		
		if(root.rightNode != null) {
			
			right = root.rightNode.data;
		}
		else {
			right = 0;
		}
		
		int sum = left + right;
		
		if(root.data < sum) {
			
			root.data = sum;
		}
		else if(root.data > sum){
			
			Node tempNode = root;
			
			int flag = 0;
			
			while(flag == 0) {
				
				while(tempNode.leftNode != null) {
					
					tempNode.leftNode.data = tempNode.leftNode.data + (root.data - sum);
					tempNode = tempNode.leftNode;
				}
				
				if(tempNode.rightNode == null) {
					
					flag = 1;
				}
				else {
					
					tempNode.rightNode.data = tempNode.rightNode.data + (root.data - sum);
					tempNode = tempNode.rightNode;
				}
			}
			
		}
	}
}
