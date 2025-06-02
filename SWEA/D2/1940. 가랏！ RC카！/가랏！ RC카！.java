import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

  static int T, N;

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();

    T = Integer.parseInt(br.readLine());

    for (int t = 1; t <= T; t++) {
      sb.append("#").append(t).append(' ');

      N = Integer.parseInt(br.readLine());

      int dis = 0;
      int a = 0;

      for (int i = 0; i < N; i++) {
        st = new StringTokenizer(br.readLine());

        int c = Integer.parseInt(st.nextToken());

        if (c == 1) { // 가속
          int tmp = Integer.parseInt(st.nextToken());
          a += tmp;
        } else if (c == 2) { // 감
          int tmp = Integer.parseInt(st.nextToken());
          if (a < tmp)
            a = 0;
          else
            a -= tmp;
        }

        dis += a;

      }

      sb.append(dis).append("\n");

    }

    System.out.println(sb);
  }

}