import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution {

  static int V, E, s, e;

  static int[] degreeCnt;

  static Map<Integer, List<Integer>> adj;

  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st;

    for (int t = 1; t <= 10; t++) {
      sb.append("#").append(t).append(" ");

      st = new StringTokenizer(br.readLine());
      V = Integer.parseInt(st.nextToken());
      E = Integer.parseInt(st.nextToken());

      adj = new HashMap<>();
      degreeCnt = new int[V + 1];

      for (int v = 1; v <= V; v++)
        adj.put(v, new ArrayList<>());

      st = new StringTokenizer(br.readLine());
      for (int i = 0; i < E; i++) {

        s = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        adj.get(s).add(e);

        degreeCnt[e]++;

      }


      kahn();
      sb.append("\n");
    }

    System.out.println(sb);
  }

  private static void kahn() {

    Stack<Integer> s = new Stack<>();

    for (int v = 1; v <= V; v++) {
      if (degreeCnt[v] == 0) {
        degreeCnt[v] -= 1;
        s.add(v);
      }
    }

    while (!s.isEmpty()) {
      int u = s.pop();
      sb.append(u).append(" ");

      for (int a : adj.get(u)) {
        degreeCnt[a] -= 1;

        if (degreeCnt[a] == 0) {
          s.add(a);
          degreeCnt[a] -= 1;
        }

      }

    }

  }
}