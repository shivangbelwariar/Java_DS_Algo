package package1;

import package1.ConstructTree.Node;

class KdistanceFromRoot {
	
	int k;
	Node root;
	
	public KdistanceFromRoot(Node root, int k) {
		// TODO Auto-generated constructor stub
		
		this.k = k;
		this.root = root;
	}
	
	void findNodes(Node root, int i) {
		
		if(root == null) {
			return;
		}
		
		findNodes(root.left, i+1);
		
		if(i == k) {
			
			System.out.print(root.data + " ");
		}
		
		findNodes(root.right, i+1);
	}

}
