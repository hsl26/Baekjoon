import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  static int N;

  static int[][] dp, tree;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    N = Integer.parseInt(br.readLine());

    dp = new int[N][N];
    tree = new int[N][N];

    for (int r = 0; r < N; r++) {
      st = new StringTokenizer(br.readLine());
      for (int c = 0; c < r + 1; c++) {
        tree[r][c] = Integer.parseInt(st.nextToken());
      }
    }

    dp[0][0] = tree[0][0];

    for (int r = 1; r < N; r++) {
      for (int c = 0; c < r + 1 && c < N; c++) {
        if (c == 0) {
          dp[r][c] = dp[r - 1][0] + tree[r][c];
        } else if (c == r) {
          dp[r][c] = dp[r - 1][r - 1] + tree[r][c];
        } else {
          dp[r][c] = Math.max(dp[r - 1][c - 1] + tree[r][c], dp[r - 1][c] + tree[r][c]);
        }
      }
    }

    int ans = 0;

    for (int i = 0; i < N; i++) {
      ans = Math.max(ans, dp[N - 1][i]);
    }

    System.out.println(ans);

  }

}