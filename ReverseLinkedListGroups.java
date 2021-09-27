package package1;

public class ReverseLinkedListGroups {
	
	static class Node{
		
		int data;
		Node next;
		
		public Node(int data) {
			
			this.data = data;
			this.next = null;
		}
	}
	
	private static void reverseList(Node head, int k) {
		
		Node prevNode = null;
		Node nextNode = head;
		Node currNode = head;
		
		int count = 0;
		
		Node prevHeadNode = head;
		
		Node prevHeadNode2 = null;
		
		while(currNode != null && count < 3) {
			
			nextNode = currNode.next;
			
			currNode.next = prevNode;
			
			prevNode = currNode;
			currNode = nextNode;
			
			count++;
		}
		
		
		head = prevNode;
		
		if(count != 3) {
			
			return;
		}
		
		while(currNode != null) {
			
			count = 0;
			
			prevHeadNode2 = currNode;
			
			while(count < 3 && currNode != null) {
				
				nextNode = currNode.next;
				
				currNode.next = prevNode;
				
				prevNode = currNode;
				currNode = nextNode;
				
				count++;
			}
			
			prevHeadNode.next = prevNode;
			
			prevHeadNode = prevHeadNode2;
			
		}
	}
	
	
	public static void main(String[] args) {
		
		
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		head.next.next.next.next.next = new Node(6);
		head.next.next.next.next.next.next = new Node(7);
		head.next.next.next.next.next.next.next = new Node(8);
		head.next.next.next.next.next.next.next.next = new Node(9);
		head.next.next.next.next.next.next.next.next.next = null;
		
		
		// reverseList(head, 3);
		
		
		while(head != null){
			
			System.out.print(head.data + " ");
			
			head = head.next;
		}
		
	}

}
