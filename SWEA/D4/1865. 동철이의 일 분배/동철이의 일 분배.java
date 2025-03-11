import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

  static int N;

  static double answer;

  static int[] visited;

  static int[][] P;

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st;

    int T = Integer.parseInt(br.readLine());

    for (int t = 1; t <= T; t++) {
      sb.append("#").append(t).append(" ");

      N = Integer.parseInt(br.readLine());

      visited = new int[N];
      P = new int[N][N];

      for (int r = 0; r < N; r++) {
        st = new StringTokenizer(br.readLine());

        for (int c = 0; c < N; c++) {
          P[r][c] = Integer.parseInt(st.nextToken());
        }
      }

      answer = Double.MIN_VALUE;
      dfs(0, 1.0);

      sb.append(String.format("%.6f", answer)).append("\n");

    }
    System.out.println(sb);
  }

  private static void dfs(int d, double p) {

    if (p * 100 < answer)
      return;

    if (d == N) {

      p *= 100.0;;

      answer = Math.max(answer, p);

      return;
    }

    for (int i = 0; i < N; i++) {

      if (visited[i] == 1 || P[d][i] == 0)
        continue;

      visited[i] = 1;
      dfs(d + 1, p * P[d][i] / 100.0);
      visited[i] = 0;
    }

  }

}