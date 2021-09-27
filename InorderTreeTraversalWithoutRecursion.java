package package1;

import java.util.Stack;

public class InorderTreeTraversalWithoutRecursion {
	
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
        root.leftNode.leftNode = new Node(4);
        root.leftNode.rightNode = new Node(5);
        root.leftNode.leftNode.leftNode = new Node(10);
        
        
		inorder(root);
	}
	
	public static void inorder(Node root) {
		
		Stack<Node> stack = new Stack<>();
		
		stack.push(root);
				
		while(stack.empty() == false) {
			
			Node tempNode = stack.peek().leftNode;
			
			while(tempNode != null) {
				
				stack.push(tempNode);
				
				tempNode = tempNode.leftNode;
			}
			
			Node tempNode2 = stack.pop();
			
			System.out.print(tempNode2.data + " ");
			
			while(tempNode2.rightNode == null && stack.empty() == false) {
				
				tempNode2 = stack.pop();
				
				System.out.print(tempNode2.data + " ");
			}
			
				
				if(tempNode2.rightNode != null) {
					
					stack.push(tempNode2.rightNode);
				}
		}
	}

}
