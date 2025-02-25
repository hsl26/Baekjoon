import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  static int n, answer;

  static int[][] sticker;

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st;

    int T = Integer.parseInt(br.readLine());

    for (int t = 0; t < T; t++) {
      answer = Integer.MIN_VALUE;

      n = Integer.parseInt(br.readLine());

      sticker = new int[2][n];

      for (int r = 0; r < 2; r++) {
        st = new StringTokenizer(br.readLine());

        for (int c = 0; c < n; c++) {
          sticker[r][c] = Integer.parseInt(st.nextToken());
        }
      }

      int[][] dp = new int[2][n];

      dp[0][0] = sticker[0][0];
      dp[1][0] = sticker[1][0];

      if (n != 1) {
        dp[0][1] = Math.max(sticker[0][1], dp[1][0] + sticker[0][1]);
        dp[1][1] = Math.max(sticker[1][1], dp[0][0] + sticker[1][1]);
      }

      for (int c = 2; c < n; c++) {
        dp[0][c] = Math.max(dp[1][c - 1] + sticker[0][c],
            Math.max(dp[0][c - 2] + sticker[0][c], dp[1][c - 2] + sticker[0][c]));

        dp[1][c] = Math.max(dp[0][c - 1] + sticker[1][c],
            Math.max(dp[0][c - 2] + sticker[1][c], dp[1][c - 2] + sticker[1][c]));
      }

      System.out.println(Math.max(dp[0][n - 1], dp[1][n - 1]));

    }

  }

}