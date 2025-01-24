import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  static int GCD(int a, int b) {
    int tmp = 0;
    while (b != 0) {
      tmp = a;
      a = b;
      b = tmp % b;
    }
    return a;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int t = Integer.parseInt(br.readLine());
    for (int T = 0; T < t; T++) {
      String[] nums = br.readLine().split(" ");
      long ans = 0L;

      for (int i = 1; i < nums.length; i++) {
        for (int j = i + 1; j < nums.length; j++) {
          int a = Integer.parseInt(nums[i]), b = Integer.parseInt(nums[j]);
          long gcd = GCD(Math.max(a, b), Math.min(a, b));
          ans += gcd;
        }
      }

      System.out.println(ans);
    }

  }
}
