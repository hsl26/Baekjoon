import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

  static int N;

  static int[] tree;
  static int[][] cnt;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int T = Integer.parseInt(br.readLine());

    for (int t = 1; t <= T; t++) {
      sb.append("#").append(t).append(" ");

      N = Integer.parseInt(br.readLine());
      tree = new int[N];
      cnt = new int[N][2];

      StringTokenizer st = new StringTokenizer(br.readLine());

      for (int i = 0; i < N; i++) {
        tree[i] = Integer.parseInt(st.nextToken());
      }

      Arrays.sort(tree);

      int max = tree[tree.length - 1];
      int g1 = 0;
      int g2 = 0;

      for (int i = 0; i < N - 1; i++) {
        int grow = max - tree[i];

        cnt[i][0] = grow % 2;
        cnt[i][1] = grow / 2;

        g1 += cnt[i][0];
        g2 += cnt[i][1];
      }

      if (g1 > g2)
        sb.append(2 * g1 - 1).append("\n");
      else {
        int min = 2 * g2;
        while (true) {
          g1 += 2;
          g2 -= 1;



          if (g1 > g2) {
            if (min < 2 * g1 - 1)
              break;
            else
              min = 2 * g1 - 1;
          } else {

            if (min < 2 * g2)
              break;
            else
              min = 2 * g2;

          }

        }
        sb.append(min).append("\n");
      }

    }
    System.out.println(sb);
  }

}