import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {

  static final int INF = 987654321;

  static int N, M, a, b;

  static int[] parent;

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();

    int T = Integer.parseInt(br.readLine());

    for (int t = 1; t <= T; t++) {
      sb.append("#").append(t).append(" ");
      st = new StringTokenizer(br.readLine());

      N = Integer.parseInt(st.nextToken());
      M = Integer.parseInt(st.nextToken());

      parent = new int[N + 1];

      for (int i = 1; i <= N; i++)
        parent[i] = i;

      for (int i = 0; i < M; i++) {
        st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        union(a, b);
      }

      for (int i = 1; i <= N; i++) {
        find_set(i);
      }

      Set<Integer> set = new HashSet<>();

      for (int i = 1; i <= N; i++) {
        set.add(parent[i]);
      }
      sb.append(set.size()).append("\n");

    }
    System.out.println(sb);

  }

  private static void union(int a, int b) {

    int p1 = find_set(a);
    int p2 = find_set(b);

    if (p1 < p2) {
      parent[p2] = p1;
    } else {
      parent[p1] = p2;
    }

  }

  private static int find_set(int n) {

    if (n == parent[n])
      return n;

    parent[n] = find_set(parent[n]);

    return parent[n];
  }
}