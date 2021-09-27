package package1;

import package1.ConstructTree.Node;

public class LowestCommonAncestor {
	
	static Node resultNode = null;
	
	public static void LCA(Node root, int a, int b) {
		
		if(root == null) {
			
			return;
		}
		
		if(root.data < a && root.data < b) {
			
			LCA(root.right, a, b);
		}
		else if(root.data > a && root.data > b) {
			
			LCA(root.left, a, b);
		}
		else {
			
			resultNode = root;
		}
	}
	
	
	public static void main(String[] args) {
		
		Node root = new Node(20);

        root.left = new Node(8);
        root.right = new Node(22);
        root.left.left = new Node(4);
        root.left.right = new Node(12);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);
        
        
		LCA(root, 10, 22);
		
		if(resultNode == null) {
			
			System.out.println("No LCA");
		}
		else {
			
			System.out.println("LCA = " + resultNode.data);
		}
		
		
	}

}
