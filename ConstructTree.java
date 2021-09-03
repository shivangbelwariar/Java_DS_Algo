package package1;

public class ConstructTree {
	
	static int preIndex = 0;
	
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
	
	public static int findInIndex(char inorder[], char preorder[]) {
		
		char temp = preorder[preIndex];
		
		int i;
		
		for(i=0; i<inorder.length; i++) {
			
			if(inorder[i] == temp) {
				
				return i;
			}
		}
		
		return -1;
	}
	
	public static Node fromInorderPreorder(char inorder[], char preorder[], int start, int end) {
		
		
		if(start > end) {
			
			return null;
		}
		
		int inIndex = findInIndex(inorder, preorder);
		
		Node root = new Node(preorder[preIndex++]);
				
		root.left = fromInorderPreorder(inorder, preorder, start, inIndex-1);
		root.right = fromInorderPreorder(inorder, preorder, inIndex+1, end);
		
		
		return root;
	}
	
	public static void inorder(Node root) {
		
		if(root == null) {
			
			return;
		}
		
		inorder(root.left);
		
		System.out.print(root.data + " ");
		
		inorder(root.right);
	}
	
	public static void main(String[] args) {
		
		char inorder[] = new char[] { 'D', 'B', 'E', 'A', 'F', 'C' };
        char preorder[] = new char[] { 'A', 'B', 'D', 'E', 'C', 'F' };
        
//		Node root = fromInorderPreorder(inorder, preorder, 0, inorder.length-1);
//		
//		inorder(root);
        
        Node root;
        
        root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(8);
          
        KdistanceFromRoot kdistanceFromRoot = new KdistanceFromRoot(root, 2);
        
        kdistanceFromRoot.findNodes(root, preIndex);
		
	}

}
