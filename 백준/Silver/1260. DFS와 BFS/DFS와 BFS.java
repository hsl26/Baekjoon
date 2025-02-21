import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  static int N, M, V;

  static ArrayList<Integer> BFS = new ArrayList<>();
  static ArrayList<Integer> DFS = new ArrayList<>();

  static Map<Integer, List<Integer>> map = new HashMap<>();

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    V = Integer.parseInt(st.nextToken());

    for (int i = 1; i <= N; i++) {
      map.put(i, new ArrayList<>());
    }

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());

      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      map.get(a).add(b);
      map.get(b).add(a);
    }

    for (int i = 1; i <= N; i++) {
      Collections.sort(map.get(i));
    }


    bfs();


    int[] visited = new int[N + 1];
    visited[V] = 1;
    DFS.add(V);
    dfs(V, visited);

    for (int n : DFS) {
      sb.append(n).append(" ");
    }
    sb.append("\n");
    for (int n : BFS) {
      sb.append(n).append(" ");
    }

    System.out.println(sb);
  }

  private static void dfs(int v, int[] visited) {
    if (DFS.size() == N) {
      return;
    }

    for (int n : map.get(DFS.get(DFS.size() - 1))) {
      if (visited[n] == 0) {
        visited[n] = 1;
        DFS.add(n);
        dfs(n, visited);
      }
    }

  }

  private static void bfs() {
    Queue<Integer> q = new LinkedList<>();
    int[] visited = new int[N + 1];

    q.add(V);
    visited[V] = 1;

    while (!q.isEmpty()) {
      int cur = q.remove();
      BFS.add(cur);

      for (int n : map.get(cur)) {
        if (visited[n] == 0) {
          q.add(n);
          visited[n] = 1;
        }
      }
    }

  }
}