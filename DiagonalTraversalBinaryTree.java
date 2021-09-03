package package1;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class DiagonalTraversalBinaryTree {
	
	
	public static void main(String[] args) {
		
		HashMap<Integer, LinkedList<Node>> hm = new HashMap<>();
		
		System.out.println("Hello");
		
		Node root = new Node(8);
        root.left = new Node(3);
        root.right = new Node(10);
        root.left.left = new Node(1);
        root.left.right = new Node(6);
        root.right.right = new Node(14);
        root.right.right.left = new Node(13);
        root.left.right.left = new Node(4);
        root.left.right.right = new Node(7);
        
        System.out.println("Hello");
        
        traverse(root, 0, hm);
        
        System.out.println(hm.size());
        
        for(HashMap.Entry<Integer, LinkedList<Node>> e : hm.entrySet()) {
        	
        	LinkedList<Node> ll = e.getValue();
        	
        	System.out.print("Level = " + e.getKey() + " Elements = ");
        	
        	for (int i = 0; i < ll.size(); i++) { 
        	    
                System.out.print(ll.get(i).data + " "); 
            } 
        	        	
//        	while(itrIterator.hasNext()) {
//        		
//        		System.out.print(itrIterator + " ");
//        	}
        	
        	System.out.println();
        	System.out.println();
        }
	}
	
	
	public static class Node {
		
		int data;
		Node left;
		Node right;
		
		Node(int data){
			
			this.data = data;
			this.left = null;
			this.right = null;
		}
		
	}
	
	
	public static void traverse(Node root, int level, HashMap<Integer, LinkedList<Node>> hm) {
		
		if(root == null) {
			
			return;
		}
		
		if(hm.containsKey(level)) {
			
			hm.get(level).add(root);
		}
		else {
			
			hm.put(level, new LinkedList<>());
			hm.get(level).add(root);
		}
		
		traverse(root.left, level+1, hm);
		
		traverse(root.right, level, hm);
	}

}
