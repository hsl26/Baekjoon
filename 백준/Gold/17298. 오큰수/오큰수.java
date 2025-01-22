import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int num;

		Stack<Integer> nums = new Stack<>();
		String str = br.readLine();
		String[] strNum = str.split(" ");
		for (int i = 0; i < N; i++) {
			nums.push(Integer.parseInt(strNum[i]));
		}

		Stack<Integer> stk = new Stack<>();
		Stack<Integer> ans = new Stack<>();
		for (int i = 0; i < N; i++) {
			num = nums.pop();

			while (!stk.isEmpty()) {
				if (num >= stk.peek()) {
					stk.pop();
				} else {
					break;
				}
			}

			if (stk.isEmpty()) {
				ans.push(-1);
			} else {
				ans.push(stk.peek());
			}

			stk.push(num);

		}

		while (!ans.isEmpty()) {
			bw.write(ans.pop() + " ");
		}

		bw.flush();
		bw.close();
	}
}
