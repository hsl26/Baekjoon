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
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < N; i++) {
			nums.push(Integer.parseInt(strNum[i]));
			if (map.get(Integer.parseInt(strNum[i])) == null) {
				map.put(Integer.parseInt(strNum[i]), 1);
			} else {
				map.put(Integer.parseInt(strNum[i]), map.get(Integer.parseInt(strNum[i])) + 1);
			}
		}

		Stack<Integer> stk = new Stack<>();
		Stack<Integer> ans = new Stack<>();
		for (int i = 0; i < N; i++) {
			num = nums.pop();

			while (!stk.isEmpty()) {
				if (map.get(num) >= map.get(stk.peek())) {
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
