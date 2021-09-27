package package1;

public class SwapNodesLinkedList {
	
	public static class Node{
		
		int data;
		Node nextNode;
		
		public Node(int data) {
			
			this.data = data;
			nextNode = null;
			
		}
	}
	
	
	public static void main(String[] args) {
		
		
	}
	
	
	public static void swapNodes(int a, int b, Node head) {
		
		if(head == null || (a == b)) {
			
			return;
		}
		
		Node curr1 = head;
		Node curr2 = head;
		Node prev1 = null;
		Node prev2 = null;
		
		int i = 0;
		int j = 0;
		
		
		while(curr1 != null && curr1.data != a) {
			
			prev1 = curr1;
			curr1 = curr1.nextNode;
			i++;
		}
		
		while(curr2 != null && curr2.data != b) {
			
			prev2 = curr2;
			curr2 = curr2.nextNode;
			j++;
		}
		
		if(curr1 == null || curr2 == null) {
			
			return;
		}
		
		// 1->2->3->4->5->6->7->null
		
		
		if(i < j) {
			
			if(curr1 == head) {
				
				if(i == j-1) {
					
					
				}
			}
			else {
				
				
			}
			
		}
		else {
			
			if(curr2 == head) {
				
				if(j == i-1) {
					
				}
				else {
					
				}
			}
			else {
				
				
			}
		}
	}

}
