package package1;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Vector;

public class ArrangeToFormGreatest {
	
	
	public static void printLargest(Vector<String> arr) {
		
		Collections.sort(arr, new Comparator<String>() {
			
			@Override
			public int compare(String X, String Y) {
				
				String XY = X + Y;
				String YX = Y + X;
				
				if(XY.compareTo(YX) > 0) {
					
					return -1;
				}
				else {
					
					return 1;
				}
			}
		});
	}
	
	public static void main(String[] args) {
		
		Vector<String> arr = new Vector<>();
		
		arr.add("54");
        arr.add("546");
        arr.add("548");
        arr.add("60");
        printLargest(arr);	
        
        Iterator<String> iterator = arr.iterator();
        
        while(iterator.hasNext()) {
        	
        	System.out.print(iterator.next());
        }
		
	}


}
