import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
        List<List<Integer>> triangle = new ArrayList<>();

		for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            List<Integer> row = new ArrayList<>();
            while (st.hasMoreTokens()) {
                row.add(Integer.parseInt(st.nextToken()));
            }
            triangle.add(row);
        }

		long[][] dp = new long[N][N];
        dp[0][0] = triangle.get(0).get(0);

		for (int i = 1; i < N; i++) {
            for (int j = 0; j <= i; j++) {
                long curValue = triangle.get(i).get(j);
                if (j > 0) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + curValue);
                }
                if (j < i) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j] + curValue);
                }
            }
        }

		long maxValue = 0;
        for (int j = 0; j < N; j++) {
            maxValue = Math.max(maxValue, dp[N - 1][j]);
        }

		sb.append(maxValue);
		System.out.println(sb);
	}

}