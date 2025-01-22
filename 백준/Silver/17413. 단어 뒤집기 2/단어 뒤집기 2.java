import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	
    	Stack<String> rev = new Stack<>();
    	Queue<String> ans = new LinkedList<>();
    	    	
    	String S = sc.nextLine();
    	String[] strArr = S.split("");
    	
    	boolean tag = false;
    	
    	for (int i=0; i<strArr.length; i++) {
    		
    		
    		if (strArr[i].equals("<")) {
    			tag = true;
    			while (!rev.isEmpty()) {
    				ans.add(rev.pop());
    			}
    			ans.add(strArr[i]);
    			continue;
    		}
    		
    		if (strArr[i].equals(">")) {
    			tag = false;
    			ans.add(strArr[i]);
    			continue;
    		}
    		
    		if (tag) {
    			ans.add(strArr[i]);
    			continue;
    		}
    		
    		if (strArr[i].equals(" ")) {
    			while (!rev.isEmpty()) {
    				ans.add(rev.pop());
    			}
    			ans.add(strArr[i]);
    			continue;
    		}
    		
    		rev.push(strArr[i]);
    		
    	}

		while (!rev.isEmpty()) {
			ans.add(rev.pop());
		}
    	
    	
    	for (int i=0; i<S.length(); i++) {
    		System.out.print(ans.remove());
    	}
    	
    }
}
