import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stack<Integer> stack = new Stack<>();
				
		int N = sc.nextInt();
		sc.nextLine();
		
		for (int i=0; i<N; i++) {
			String str = sc.nextLine();
			
			if (str.equals("pop")) {
				if (stack.isEmpty()) {
					System.out.println(-1);
				} else {
					System.out.println(stack.pop());
				}
			} else if (str.equals("size")) {
				System.out.println(stack.size());
			} else if (str.equals("empty")) {
				if (stack.isEmpty()) {
					System.out.println(1);
				} else {
					System.out.println(0);
				}
			} else if (str.equals("top")) {
				if (stack.isEmpty()) {
					System.out.println(-1);
				} else {
					System.out.println(stack.peek());
				}
			} else {
				String num = str.substring(5);
				stack.push(Integer.valueOf(num));
			}
		}
		
	}
}
