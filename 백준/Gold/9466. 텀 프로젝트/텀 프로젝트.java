import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  static int[] student;
  static boolean[] visited;
  static boolean[] finished;
  static int count;

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());

    for (int t = 0; t < T; t++) {
      int n = Integer.parseInt(br.readLine());

      student = new int[n + 1];
      visited = new boolean[n + 1];
      finished = new boolean[n + 1];
      count = 0;

      StringTokenizer st = new StringTokenizer(br.readLine());

      for (int i = 1; i <= n; i++) {
        student[i] = Integer.parseInt(st.nextToken());
      }

      for (int i = 1; i <= n; i++) {
        if (!visited[i]) {
          dfs(i);
        }
      }

      System.out.println(n - count);
    }
  }

  static void dfs(int n) {
    visited[n] = true;
    int next = student[n];

    if (!visited[next]) {
      dfs(next);
    } else if (!finished[next]) {

      int temp = next;
      count++;

      while (temp != n) {
        temp = student[temp];
        count++;
      }
    }

    finished[n] = true;
  }
}