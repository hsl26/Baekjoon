import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  static int N, K;

  static int[] num, dp;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());

    num = new int[N + 1];
    dp = new int[K + 1];
    dp[0] = 1;

    for (int i = 1; i <= N; i++) {
      num[i] = Integer.parseInt(br.readLine());
      for (int j = num[i]; j <= K; j++) {
        dp[j] += dp[j - num[i]];
      }
    }

    System.out.println(dp[K]);
  }

}