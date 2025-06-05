import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

  static int T, N, K;

  static int[] building;

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();

    T = 10;

    for (int t = 1; t <= T; t++) {
      sb.append("#").append(t).append(" ");

      N = Integer.parseInt(br.readLine());
      building = new int[N];

      st = new StringTokenizer(br.readLine());

      for (int i = 0; i < N; i++) {
        building[i] = Integer.parseInt(st.nextToken());
      }

      int sum = 0, max;

      for (int i = 2; i < N - 2; i++) {
        max = Math.max(Math.max(building[i - 2], building[i - 1]),
            Math.max(building[i + 2], building[i + 1]));

        sum += Math.max(building[i] - max, 0);
      }

      sb.append(sum).append("\n");
    }

    System.out.println(sb);
  }


}