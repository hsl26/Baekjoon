import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

  static String[] A, B;
  static int[][] DP;

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    A = br.readLine().split("");
    B = br.readLine().split("");

    int n = A.length;
    int m = B.length;

    DP = new int[n + 1][m + 1];

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= m; j++) {
        if (A[i - 1].equals(B[j - 1])) {
          DP[i][j] = DP[i - 1][j - 1] + 1;
        } else {
          DP[i][j] = Math.max(DP[i - 1][j], DP[i][j - 1]);
        }
      }
    }

    System.out.println(DP[n][m]);

    if (DP[n][m] > 0) {
      StringBuilder sb = new StringBuilder();
      int i = n, j = m;
      while (i > 0 && j > 0) {
        if (A[i - 1].equals(B[j - 1])) {
          sb.append(A[i - 1]);
          i--;
          j--;
        } else if (DP[i - 1][j] >= DP[i][j - 1]) {
          i--;
        } else {
          j--;
        }
      }
      System.out.println(sb.reverse().toString());
    }
  }
}