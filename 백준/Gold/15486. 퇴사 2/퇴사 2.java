import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  static int N;

  static int[] T, P, dp;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    N = Integer.parseInt(br.readLine());

    T = new int[N + 1];
    P = new int[N + 1];
    dp = new int[N + 1];

    for (int i = 1; i <= N; i++) {
      st = new StringTokenizer(br.readLine());

      T[i] = Integer.parseInt(st.nextToken());
      P[i] = Integer.parseInt(st.nextToken());
    }

    int max = 0;
    for (int i = 1; i <= N; i++) {
      max = Math.max(max, dp[i - 1]);

      if (i + T[i] - 1 <= N) {
        dp[i + T[i] - 1] = Math.max(dp[i + T[i] - 1], max + P[i]);
      }

    }

    int ans = 0;
    for (int i = 1; i <= N; i++) {
      ans = Math.max(ans, dp[i]);
    }

    System.out.println(ans);

  }

}