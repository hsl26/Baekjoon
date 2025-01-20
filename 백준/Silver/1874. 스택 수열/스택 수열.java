import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		Stack<Integer> stk = new Stack<>();
		stk.push(0);
		int i = 1;
		int idx = 0;
		
		StringBuilder ans = new StringBuilder();

		while (idx < n) {
			if (stk.peek() == arr[idx]) {
				stk.pop();
				ans.append("-\n");
				idx++;
				continue;
			}
			
			if (i <= arr[idx]) {
				stk.push(i);
				ans.append("+\n");
				i++;
			} else {
				ans.setLength(0); // 결과 초기화
                ans.append("NO");
				break;
			}
		}
		
		System.out.print(ans.toString());
	}
}