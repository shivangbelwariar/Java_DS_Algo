package package1;

import java.util.Arrays;

public class InorderToBST {

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
		
		int pre[] = new int[] { 10, 5, 1, 7, 40, 50 };
		
		Arrays.sort(pre);
		
		Node rootNode = constructTree(pre, 0, pre.length-1);
		
		preorder(rootNode);
	}
	
	public static void inorder(Node root) {
		
		if(root == null) {
			
			return;
		}
		
		inorder(root.leftNode);
		
		System.out.print(root.data + " ");
		
		inorder(root.rightNode);
	}
	
	public static void preorder(Node root) {
		
		if(root == null) {
			
			return;
		}
		
		System.out.print(root.data + " ");
		
		inorder(root.leftNode);
		
		inorder(root.rightNode);
	}
	
	public static Node constructTree(int arr[], int start, int end) {
		
		if(start > end) {
			
			return null;
		}
		
		int mid = (start + end)/2;
		
		Node rootNode = new Node(arr[mid]);
		
		rootNode.leftNode = constructTree(arr, start, mid-1);
		
		rootNode.rightNode = constructTree(arr, mid+1, end);
		
		return rootNode;
	}
}
