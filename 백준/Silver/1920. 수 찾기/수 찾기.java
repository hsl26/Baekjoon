import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		Map<Integer, Integer> nums = new HashMap<>();

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			nums.put(Integer.parseInt(st.nextToken()), 1);
		}

		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < M; i++) {
			int n = Integer.parseInt(st.nextToken());
			if (nums.containsKey(n))
				sb.append(nums.get(n));
			else
				sb.append(0);

			sb.append("\n");
		}

		System.out.println(sb);

	}
}