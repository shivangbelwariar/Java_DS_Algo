package package1;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;


// Approach: Find the root node with parent = -1
// Construct a hashmap with key as parent's data and values as child data's
// value will be a object with elements: leftchild & rightchild
// create a queue with element root(who has no parent)
// find its child nodes left and right and push them in queue
// while queue is not empty, keep creating nodes and putting the child value 
// and keep assigning it to parent nodes

	public class ConstructBinaryTreeFromParentArray {
		
	public static class Child{
		
		int ldata;
		int rdata;
		
		public Child() {
			
			ldata = -5;
			rdata = -5;
		}
		
		public void setLdata(int data) {
			
			ldata = data;
		}
		
		public void setRdata(int data) {
			
			rdata = data;
		}
	}
	
	public static HashMap<Integer, Child> hashMap = new HashMap<>();
		
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
		
		int parent[] = new int[]{-1, 0, 0, 1, 1, 3, 5};
		
		Node rootNode = constructTreeUtil(parent);
		
		inorder(rootNode);
	}
	
	
	// NOTE THE OUTPUT IS WRONG HERE. NEEDS DEBUGGING OR DIFFERENT APPROACH
	public static Node constructTreeUtil(int arr[]) {
		
		if(arr.length == 0) {
			
			return null;
		}
		
		int i;
		
		for(i=0; i< arr.length; i++) {
			
			if(arr[i] == -1) {
				
				break;
			}
		}
		
		Integer rootDataNode = i;
		
		for(i=0; i<arr.length; i++) {

			
			if(hashMap.containsKey(arr[i])) {
				
				hashMap.get(arr[i]).rdata = i;
			}
			else {
				
				Child child = new Child();
				
				child.setLdata(i);
				
				hashMap.put(arr[i], child);
			}
		}
		
		Queue<Integer> queue = new LinkedList<>();
		
		Node rootNode = new Node(rootDataNode);
		
		if(hashMap.containsKey(rootNode.data)) {
			
			if(hashMap.get(rootNode.data).ldata != -5) {
				
				rootNode.leftNode = new Node(hashMap.get(rootNode.data).ldata);
				
				queue.add(rootNode.leftNode.data);
				
			}
			
			if(hashMap.get(rootNode.data).rdata != -5) {
				
				rootNode.rightNode = new Node(hashMap.get(rootNode.data).rdata);
				
				queue.add(rootNode.rightNode.data);
			}
		}
		
		
		
		while(queue.size() > 0) {
			
			Node parentNode = new Node(queue.remove());
			
			if(hashMap.containsKey(parentNode.data)) {
				
				if(hashMap.get(parentNode.data).ldata != -5) {
					
					parentNode.leftNode = new Node(hashMap.get(parentNode.data).ldata);
					
					queue.add(parentNode.leftNode.data);
					
				}
				
				if(hashMap.get(parentNode.data).rdata != -5) {
					
					parentNode.rightNode = new Node(hashMap.get(parentNode.data).rdata);
					
					
				}
			
			}
		
		}
		
		return rootNode;
	}
		
		
}
