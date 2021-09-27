package package1;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class DeletionInBinaryTree {
	
	// Approach: 
	// Find the last node and it's parent's node
	// Find the node which needs to be deleted
	// If exists -> If these both are same ?
	// If not -> then check if its left or right node of parent node
	// Accordingly make the child node null and put its value in the node 
	// Which is going to be deleted

	
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
	
	public static void inorder(Node root) {
		
		if(root == null) {
			return;
		}
		
		inorder(root.leftNode);
		
		System.out.print(root.data + " ");
		
		inorder(root.rightNode);
	}
	
	public static void main(String[] args) {
		
		Node root = new Node(10); 

	    root.leftNode = new Node(11); 

	    root.leftNode.leftNode = new Node(7);

	    root.leftNode.rightNode = new Node(12);

	    root.rightNode = new Node(9); 

	    root.rightNode.leftNode = new Node(15); 

	    root.rightNode.rightNode = new Node(8);
	    
	    inorder(root);
	    
	    deleteNode(root, 11);
	    
	    System.out.println();
	    
	    inorder(root);
	}
	
	public static void deleteNode(Node root, int data) {
		
		int flag = 0;
		
		Queue<Node> queue = new LinkedList<>();
		
		queue.add(root);
		
		int size = 0;
		
		HashMap<Node, Node> hashMap = new HashMap<>();
		
		Node lastNode = null;
		Node deleteNode = null;
		
		while(queue.isEmpty() == false) {
			
			size = queue.size();
			
			while(size > 0) {
				
				Node tempNode = queue.peek();
				queue.remove();
				
				if(tempNode.data == data) {
					
					flag = 1;
					deleteNode = tempNode;
				}
				
				// System.out.print(tempNode.data + " ");
				
				if(tempNode.leftNode != null) {
					
					queue.add(tempNode.leftNode);
					hashMap.put(tempNode.leftNode, tempNode);
				}
				
				if(tempNode.rightNode != null) {
					
					queue.add(tempNode.rightNode);
					hashMap.put(tempNode.rightNode, tempNode);
				}
				
				size--;
				
				lastNode = tempNode;
			}
			
			// System.out.println();
		}
		
		if(flag == 1) {
			
			Node parentNode = hashMap.get(lastNode);
			
			if(parentNode.rightNode == lastNode) {
				
				deleteNode.data = lastNode.data;
				parentNode.rightNode = null;
			}
			else {
				
				deleteNode.data = lastNode.data;
				parentNode.leftNode = null;
			}
		}
		
	}
}
