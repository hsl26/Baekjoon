import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());

		Map<Integer, Integer> numCard = new HashMap<>();

		for (int i = 0; i < N; i++) {
			int n = Integer.parseInt(st.nextToken());
			if (numCard.containsKey(n)) {
				numCard.put(n, numCard.get(n) + 1);
			} else {
				numCard.put(n, 1);
			}
		}

		StringBuilder sb = new StringBuilder();

		int M = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < M; i++) {
			int n = Integer.parseInt(st.nextToken());

			int ans = numCard.get(n) != null ? numCard.get(n) : 0;
			
			sb.append(ans).append(" ");
		}
		
		System.out.println(sb);

	}
}