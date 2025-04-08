import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

  static int N;

  static boolean[] nums;

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());

    nums = new boolean[N + 2];

    Arrays.fill(nums, true);

    nums[0] = false;
    nums[1] = false;
    nums[N + 1] = false;

    for (int i = 2; i <= N; i++) {
      if (nums[i]) {
        for (int j = 2 * i; j <= N; j += i) {
          nums[j] = false;
        }
      }
    }

    int s = 2;
    int e = 2;

    int sum = 2, cnt = 0;
    while (s <= N && e <= N) {

      // System.out.println(s + " " + e + " " + sum);

      if (sum == N) {
        cnt++;
        s++;
        while (!nums[s] && s <= N) {
          s++;
        }
        e = s;
        sum = s;
      } else if (sum < N) {
        e++;

        while (!nums[e] && e <= N) {
          e++;
        }

        sum += e;
      } else {
        sum -= s;
        s++;
        while (!nums[s] && s <= N) {
          s++;
        }
      }

      // System.out.println("-> " + s + " " + e + " " + sum + "\n");
    }

    System.out.println(cnt);

  }

}