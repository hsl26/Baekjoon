import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

  static String[] A, B;
  static int[][] DP;

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    A = br.readLine().split("");
    B = br.readLine().split("");

    DP = new int[A.length][B.length];

    if (A[0].equals(B[0]))
      DP[0][0] = 1;

    initialize();

    for (int a = 1; a < A.length; a++) {
      for (int b = 1; b < B.length; b++) {
        if (A[a].equals(B[b]))
          DP[a][b] = DP[a - 1][b - 1] + 1;
        else
          DP[a][b] = Math.max(DP[a - 1][b], DP[a][b - 1]);
      }
    }

    System.out.println(DP[A.length - 1][B.length - 1]);
  }

  private static void initialize() {

    for (int a = 1; a < A.length; a++) {
      DP[a][0] = DP[a - 1][0];
      if (A[a].equals(B[0]))
        DP[a][0] = 1;
    }

    for (int b = 1; b < B.length; b++) {
      DP[0][b] = DP[0][b - 1];
      if (A[0].equals(B[b]))
        DP[0][b] = 1;
    }

  }

}