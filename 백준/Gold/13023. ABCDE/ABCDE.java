import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

  static int N, M, answer = 0;

  static boolean[] visited;

  static Map<Integer, List<Integer>> tree = new HashMap<>();

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    visited = new boolean[N + 1];

    for (int i = 0; i < N; i++) {
      tree.put(i, new ArrayList<>());
    }

    int a, b;
    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      a = Integer.parseInt(st.nextToken());
      b = Integer.parseInt(st.nextToken());

      tree.get(a).add(b);
      tree.get(b).add(a);
    }

    for (int i = 0; i < N; i++) {
      visited[i] = true;
      bt(0, i);
      visited[i] = false;

      if (answer > 0)
        break;
    }

    if (answer > 0)
      answer = 1;

    System.out.println(answer);
  }

  private static void bt(int d, int f) {

    if (d == 4) {
      answer++;
      return;
    }

    for (int i = 0; i < tree.get(f).size(); i++) {
      if (visited[tree.get(f).get(i)] == true)
        continue;

      visited[tree.get(f).get(i)] = true;
      bt(d + 1, tree.get(f).get(i));
      visited[tree.get(f).get(i)] = false;

      if (answer > 0)
        return;
    }
  }

}