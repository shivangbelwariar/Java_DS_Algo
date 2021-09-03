package package1;

public class DiameterHeightTree {
	
	static class Node{
		
		int data;
		Node right;
		Node left;
		
		public Node(int data) {
			
			this.data = data;
			this.right = null;
			this.left = null;
		}
	}
	
	public static void main(String[] args) {
		
		Node node1 = new Node(1);
        node1.left = new Node(2);
        node1.right = new Node(3);
        node1.left.left = new Node(4);
        node1.left.right = new Node(5);
        
        DiameterHeightTree diameterHeightTree
        = new DiameterHeightTree();
        
        System.out.println("Diameter = " +diameterHeightTree.diameter(node1));
	}
	
	public int diameter(Node root) {
		
		if(root == null) {
			
			return 0;
		}
		
		int ldiameter = diameter(root.left);
		int rdiameter = diameter(root.right);
		
		
		return Math.max(Math.max(ldiameter, rdiameter), (1+ height(root.left) + height(root.right)));
	}
	
	public int height(Node root) {
		
		if(root == null) {
			
			return 0;
		}
		
		int lheight = 1+height(root.left);
		int rheight = 1+height(root.right);
		
		return Math.max(lheight, rheight);
	}

}
