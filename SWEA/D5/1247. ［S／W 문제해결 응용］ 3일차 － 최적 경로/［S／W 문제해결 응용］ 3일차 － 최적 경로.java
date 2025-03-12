import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

  static int N, answer;

  static int[] home = new int[2];
  static int[] company = new int[2];
  static int[] visited;

  static int[][] cust;
  static int[][] visit;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();

    int T = Integer.parseInt(br.readLine());

    for (int t = 1; t <= T; t++) {
      sb.append("#").append(t).append(" ");

      N = Integer.parseInt(br.readLine());
      cust = new int[N][2];
      visit = new int[N][2];
      visited = new int[N];

      st = new StringTokenizer(br.readLine());

      home[0] = Integer.parseInt(st.nextToken());
      home[1] = Integer.parseInt(st.nextToken());
      company[0] = Integer.parseInt(st.nextToken());
      company[1] = Integer.parseInt(st.nextToken());

      for (int i = 0; i < N; i++) {
        cust[i][0] = Integer.parseInt(st.nextToken());
        cust[i][1] = Integer.parseInt(st.nextToken());
      }

      answer = Integer.MAX_VALUE;
      bt(0);

      sb.append(answer).append("\n");

    }

    System.out.println(sb);

  }

  private static void bt(int d) {
    if (d == N) {

      int sum = Math.abs(home[0] - visit[0][0]) + Math.abs(home[1] - visit[0][1])
          + Math.abs(company[0] - visit[N - 1][0]) + Math.abs(company[1] - visit[N - 1][1]);

      for (int i = 0; i < N - 1; i++) {
        sum += Math.abs(visit[i][0] - visit[i + 1][0]) + Math.abs(visit[i][1] - visit[i + 1][1]);
      }

      answer = Math.min(answer, sum);

      return;
    }

    for (int i = 0; i < N; i++) {
      if (visited[i] == 0) {
        visited[i] = 1;
        visit[d] = cust[i];
        bt(d + 1);
        visited[i] = 0;
      }
    }
  }
}