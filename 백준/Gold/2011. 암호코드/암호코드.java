import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  static String[] num;
  static int[] n;

  static int[] dp;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    num = br.readLine().split("");
    n = new int[num.length];

    for (int i = 0; i < num.length; i++) {
      n[i] = Integer.parseInt(num[i]);
    }

    if (n[0] == 0) {
      System.out.println(0);
      return;
    }

    dp = new int[n.length];

    dp[0] = 1;

    if (n.length > 1)
      if (n[1] != 0 && isTwo(n[0], n[1])) {
        dp[1] = 2;
      } else if (n[1] == 0 && (n[0] > 2 || n[0] == 0)) {
        System.out.println(0);
        return;
      } else {
        dp[1] = 1;
      }


    for (int i = 2; i < n.length; i++) {
      if (isTwo(n[i - 1], n[i])) {
        if (n[i] != 0)
          dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000;
        else
          dp[i] = dp[i - 2];
      }

      else if (n[i] != 0) {
        dp[i] = dp[i - 1];
      }

    }

    System.out.println(dp[n.length - 1]);

  }

  private static boolean isTwo(int a, int b) {

    int n = a * 10 + b;

    if (n >= 10 && n <= 26)
      return true;

    return false;
  }

}