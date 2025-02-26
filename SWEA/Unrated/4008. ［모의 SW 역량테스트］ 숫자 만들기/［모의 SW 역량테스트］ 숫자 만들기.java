import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

  static int min, max, N;

  static int[] cal = new int[4];
  static int[] nums;

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringBuilder sb = new StringBuilder();

    StringTokenizer st;

    int T = Integer.parseInt(br.readLine());

    for (int t = 1; t <= T; t++) {
      sb.append("#").append(t).append(" ");

      min = Integer.MAX_VALUE;
      max = Integer.MIN_VALUE;

      N = Integer.parseInt(br.readLine());
      nums = new int[N];

      st = new StringTokenizer(br.readLine());
      for (int i = 0; i < 4; i++) {
        cal[i] = Integer.parseInt(st.nextToken());
      }

      st = new StringTokenizer(br.readLine());
      for (int i = 0; i < N; i++) {
        nums[i] = Integer.parseInt(st.nextToken());
      }

      bt(1, nums[0]);

      sb.append(max - min).append("\n");

    }

    System.out.println(sb);

  }

  private static void bt(int n, int sum) {

    if (n == N) {
      min = Math.min(min, sum);
      max = Math.max(max, sum);

      return;
    }

    for (int d = 0; d < 4; d++) {
      if (cal[d] == 0)
        continue;

      cal[d]--;

      // '+', '-', '*', '/'
      switch (d) {
        case 0:
          bt(n + 1, sum + nums[n]);
          break;
        case 1:
          bt(n + 1, sum - nums[n]);
          break;
        case 2:
          bt(n + 1, sum * nums[n]);
          break;
        case 3:
          bt(n + 1, sum / nums[n]);
          break;
        default:
          break;
      }

      cal[d]++;

    }

  }
}