import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
  static boolean[] visited;
  static ArrayList<Integer>[] link;
  static int[] count;

  public static void main(String[] args) throws IOException {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(in.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    link = new ArrayList[N + 1];

    for (int i = 1; i <= N; i++)
      link[i] = new ArrayList<>();

    int a, b;
    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(in.readLine());
      a = Integer.parseInt(st.nextToken());
      b = Integer.parseInt(st.nextToken());
      link[a].add(b);
    }

    count = new int[N + 1];
    for (int i = 1; i <= N; i++) {
      visited = new boolean[N + 1];
      dfs(i);
    }

    StringBuilder sb = new StringBuilder();
    int max = Arrays.stream(count).max().getAsInt();
    for (int i = 1; i <= N; i++) {
      if (count[i] == max)
        sb.append(i).append(' ');
    }
    System.out.println(sb);
  }

  public static void dfs(int now) {
    visited[now] = true;
    for (int next : link[now]) {
      if (visited[next])
        continue;
      visited[next] = true;
      count[next]++;
      dfs(next);
    }
  }

}