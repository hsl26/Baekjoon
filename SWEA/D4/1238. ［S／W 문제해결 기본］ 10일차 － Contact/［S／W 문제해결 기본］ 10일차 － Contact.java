import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

  static int len, V;

  static Map<Integer, ArrayList<Integer>> map = new HashMap<>();

  static int[] visited;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    for (int t = 1; t <= 10; t++) {
      sb.append("#").append(t).append(" ");

      for (int i = 1; i <= 100; i++) {
        map.put(i, new ArrayList<Integer>());
      }

      StringTokenizer st = new StringTokenizer(br.readLine());

      len = Integer.parseInt(st.nextToken());
      V = Integer.parseInt(st.nextToken());

      st = new StringTokenizer(br.readLine());

      while (st.hasMoreTokens()) {
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        if (!map.get(a).contains(b)) {
          map.get(a).add(b);
        }
      }

      bfs();

      int value = -1;
      int e = V;

      for (int i = 100; i > 0; i--) {
        if (value < visited[i]) {
          e = i;
          value = visited[i];
        }
      }

      sb.append(e).append("\n");
    }

    System.out.println(sb);
  }

  private static void bfs() {
    Queue<Integer> q = new LinkedList<>();
    visited = new int[101];

    Arrays.fill(visited, -1);

    visited[V] = 0;
    q.add(V);

    while (!q.isEmpty()) {
      int cur = q.remove();

      for (int n : map.get(cur)) {
        if (n < 0 || n > 100)
          continue;
        if (visited[n] < 0) {
          visited[n] = visited[cur] + 1;
          q.add(n);
        }
      }
    }

  }
}