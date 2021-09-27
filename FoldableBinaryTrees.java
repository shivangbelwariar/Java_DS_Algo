package package1;

public class FoldableBinaryTrees {
	
	// Approach: Making flag = 0 when a node is found that is null but its opposite 
	// node is not null. 
	// in the isFoldable() function, I have wrote the logic before
	// writing the base / return statement
	
	static int flag = 1;

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
		
		Node root = new Node(1);
        root.leftNode = new Node(2);
        root.rightNode = new Node(3);
        root.rightNode.leftNode = new Node(4);
        root.leftNode.rightNode = new Node(5);
        root.leftNode.rightNode.leftNode = new Node(5);
        
		isFoldable(root.leftNode, root.rightNode);
		
		System.out.println("Flag = " + flag);
	}
	
	static void isFoldable(Node root1, Node root2) {
		
		if((root1 == null && root2 != null) || (root1 != null && root2 == null)) {
			
			flag = 0;
		}
		
		if(root1 == null || root2 == null) {
			
			return;
		}
		
		isFoldable(root1.leftNode, root2.rightNode);
		
		isFoldable(root1.rightNode, root2.leftNode);
	}
}
