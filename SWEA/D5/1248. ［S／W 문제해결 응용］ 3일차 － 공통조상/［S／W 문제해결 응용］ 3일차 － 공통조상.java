import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

  static int V, E;

  static Map<Integer, List<Integer>> TM;

  static int[] parent;
  static int[] level;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int T = Integer.parseInt(br.readLine());

    for (int t = 1; t <= T; t++) {
      sb.append("#").append(t).append(" ");

      StringTokenizer st = new StringTokenizer(br.readLine());

      V = Integer.parseInt(st.nextToken());
      E = Integer.parseInt(st.nextToken());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      parent = new int[V + 1];
      level = new int[V + 1];
      TM = new HashMap<>();

      parent[1] = 1;
      level[1] = 1;

      for (int v = 1; v <= V; v++) {
        TM.put(v, new ArrayList<>());
      }

      st = new StringTokenizer(br.readLine());
      for (int i = 0; i < E; i++) {
        int p = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        TM.get(p).add(c);
      }

      setTree(1, 0);

      int lca = LCA(a, b);
      int size = subtreeSize(lca);

      sb.append(lca).append(" ").append(size).append("\n");
    }

    System.out.println(sb);
  }

  private static int subtreeSize(int lca) {
    int cnt = 1;

    Queue<Integer> q = new LinkedList<>();
    int[] visited = new int[V + 1];

    q.add(lca);
    visited[lca] = 1;

    while (!q.isEmpty()) {
      int n = q.remove();
      cnt += TM.get(n).size();

      for (int i = 0; i < TM.get(n).size(); i++) {
        int nn = TM.get(n).get(i);
        if (visited[nn] == 0)
          q.add(nn);
      }
    }

    return cnt;
  }

  private static int LCA(int a, int b) {
    // 깊이를 일치시킴
    while (level[a] > level[b])
      a = parent[a];
    while (level[a] < level[b])
      b = parent[b];

    // 부모가 같아질 때까지 거슬러 올라감
    while (a != b) {
      a = parent[a];
      b = parent[b];
    }

    return a;
  }

  private static void setTree(int c, int p) {

    parent[c] = p;
    level[c] = level[p] + 1;

    for (int i = 0; i < TM.get(c).size(); i++) {
      if (c == TM.get(c).get(i))
        continue;

      setTree(TM.get(c).get(i), c);
    }

  }
}