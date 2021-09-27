package package1;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

import package1.ConstructTree.Node;

public class BinaryTreeVerticalOrder {
	
	private static HashMap<Integer, LinkedList<Node>> hm = new HashMap<>();
	
	static int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
	
	public static void main(String[] args) {
		
		Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.left.right = new Node(8);
        root.right.right.right = new Node(9);
        
        printVertical(root, 0);
        
        for(int i=min; i<=max; i++) {
        	
        	LinkedList<Node> list = hm.get(i);
        	
        	if(list == null) {
        		
        		continue;
        	}
        	
        	Iterator<Node> iterator = list.iterator();
        	
        	while(iterator.hasNext()) {
        		
        		System.out.print(iterator.next().data + " ");
        	}
        	
        	System.out.println();
        }
	}
	
	public static void printVertical(Node root, int verticalLevel) {
		
		if(root == null) {
			
			return;
		}
		
		if(hm.get(verticalLevel) != null) {
			
			hm.get(verticalLevel).add(root);
		}
		else {
			
			hm.put(verticalLevel, new LinkedList<Node>());
			hm.get(verticalLevel).add(root);
		}
		
		if(verticalLevel < min) {
			
			min = verticalLevel;
		}
		
		if(verticalLevel > max) {
			
			max = verticalLevel;
		}
		
		printVertical(root.left, verticalLevel-1);
		
		printVertical(root.right, verticalLevel+1);
		
	}

}
