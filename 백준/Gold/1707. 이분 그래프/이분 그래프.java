import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  static int K, V, E, u, v;
  static ArrayList<Integer>[] al;
  static int[] visited;

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    K = Integer.parseInt(br.readLine());

    for (int t = 0; t < K; t++) {
      st = new StringTokenizer(br.readLine());
      V = Integer.parseInt(st.nextToken());
      E = Integer.parseInt(st.nextToken());

      visited = new int[V + 1];
      al = new ArrayList[V + 1];

      for (int i = 0; i <= V; i++) {
        al[i] = new ArrayList<Integer>();
      }

      for (int e = 0; e < E; e++) {
        st = new StringTokenizer(br.readLine());
        u = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());

        al[u].add(v);
        al[v].add(u);

      }

      bfs();

    }

  }

  private static void bfs() {
    Queue<Integer> q = new LinkedList<>();

    for (int i = 1; i <= u; i++) {
      if (visited[i] == 0) {
        q.add(i);
        visited[i] = 1;
      }

      while (!q.isEmpty()) {
        int now = q.poll();

        for (int j = 0; j < al[now].size(); j++) {
          if (visited[al[now].get(j)] == 0) {
            q.add(al[now].get(j));
          }

          if (visited[al[now].get(j)] == visited[now]) {
            System.out.println("NO");
            return;
          }

          if (visited[now] == 1 && visited[al[now].get(j)] == 0) {
            visited[al[now].get(j)] = 2;
          } else if (visited[now] == 2 && visited[al[now].get(j)] == 0) {
            visited[al[now].get(j)] = 1;
          }
        }
      }

    }

    System.out.println("YES");
  }

}