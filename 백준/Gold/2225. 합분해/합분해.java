import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  static int N, K;

  static int[][] dp;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());

    dp = new int[N + 1][K];

    for (int i = 0; i <= N; i++) {
      dp[i][0] = 1;
    }

    for (int r = 1; r < K; r++) {
      for (int i = 0; i <= N; i++) {
        for (int j = 0; j <= N; j++) {
          if (i + j <= N)
            dp[j + i][r] = (dp[j + i][r] + dp[i][r - 1]) % 1000000000;
        }
      }
    }

    System.out.println(dp[N][K - 1] % 1000000000);

  }

}