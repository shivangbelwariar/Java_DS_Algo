package package1;

import java.util.LinkedList;
import java.util.Queue;

import package1.ConstructTree.Node;

public class PrintLeftView {
	
	public static void leftView(Node root) {
		
		if(root == null) {
			
			return;
		}
		
		Queue<Node> queue = new LinkedList<>();
		
		queue.add(root);
		
		int flag = 0;
		
		while(!queue.isEmpty()) {
			
			int size = queue.size();
			
			flag = 1;
			
			while(size > 0) {
				
				Node tempNode = queue.remove();
				
				if(flag == 1) {
					
					System.out.print(tempNode.data +" ");
				}
				
				size--;
				
				if(tempNode.left != null) {
					
					queue.add(tempNode.left);
				}
				
				if(tempNode.right != null) {
					
					queue.add(tempNode.right);
				}
			
				flag = 0;
			}
			
			System.out.println();
		}
		
	}
	
	public static void main(String[] args) {
		
		Node root = new Node(10);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(7);
        root.left.right = new Node(8);
        root.right.right = new Node(15);
        root.right.left = new Node(12);
        root.right.right.left = new Node(14);
        
        leftView(root);
	}

}
