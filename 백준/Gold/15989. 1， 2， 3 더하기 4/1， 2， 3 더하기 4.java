import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

  static int T;
  static int[] dp;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    T = Integer.parseInt(br.readLine());

    for (int t = 0; t < T; t++) {
      int n = Integer.parseInt(br.readLine());

      dp = new int[n + 1];
      dp[0] = 1;

      for (int i = 1; i <= 3; i++) {
        for (int j = i; j <= n; j++) {
          dp[j] += dp[j - i];
        }
      }

      sb.append(dp[n]).append("\n");
    }


    System.out.println(sb);
  }

}