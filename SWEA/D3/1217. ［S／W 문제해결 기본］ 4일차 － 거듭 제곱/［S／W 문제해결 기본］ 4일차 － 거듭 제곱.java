import java.util.Scanner;

public class Solution {

  static int T, ans, N, M;


  public static void main(String[] args) throws Exception {

    T = 10;
    Scanner sc = new Scanner(System.in);


    for (int t = 1; t <= T; t++) {

      t = sc.nextInt();

      N = sc.nextInt();
      M = sc.nextInt();

      ans = cal(1, 0);

      System.out.println("#" + t + " " + ans);

    }

  }

  private static int cal(int n, int m) {

    if (m == M)
      return n;

    return cal(n * N, m + 1);
  }

}