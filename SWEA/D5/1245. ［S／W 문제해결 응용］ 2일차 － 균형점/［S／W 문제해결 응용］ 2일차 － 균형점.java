import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

  static int N;

  static int[] coor, m;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();

    int T = Integer.parseInt(br.readLine());

    for (int t = 1; t <= T; t++) {
      sb.append("#").append(t).append(" ");


      // 입력
      N = Integer.parseInt(br.readLine());

      coor = new int[N];
      m = new int[N];

      st = new StringTokenizer(br.readLine());

      for (int i = 0; i < N; i++)
        coor[i] = Integer.parseInt(st.nextToken());

      for (int i = 0; i < N; i++)
        m[i] = Integer.parseInt(st.nextToken());

      // 각 균형점 계산
      for (int i = 0; i < N - 1; i++) {

        double s = coor[i], e = coor[i + 1];

        double x = (s + e) / 2.0;
        int cnt = 0;
        // 이진 탐색
        while (true) {

          if (cnt == 100)
            break;

          x = (s + e) / 2.0;

          double left = 0, right = 0;

          for (int l = 0; l <= i; l++) {
            left += m[l] / Math.pow(coor[l] - x, 2);
          }

          for (int r = i + 1; r < N; r++) {
            right += m[r] / Math.pow(coor[r] - x, 2);
          }

          if (left == right) {
            break;
          } else if (left < right) {
            e = x;
          } else {
            s = x;
          }

          cnt++;
        }


        sb.append(String.format("%.10f", x)).append(" ");
      }

      sb.append("\n");

    }
    System.out.println(sb);
  }
}