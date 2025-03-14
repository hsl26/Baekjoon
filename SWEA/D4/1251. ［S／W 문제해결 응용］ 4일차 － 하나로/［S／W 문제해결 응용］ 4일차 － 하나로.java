import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution {

  static class Node implements Comparable<Node> {
    int from;
    int to;
    double cost;

    public Node(int from, int to, double cost) {
      super();
      this.from = from;
      this.to = to;
      this.cost = cost;
    }

    @Override
    public int compareTo(Node o) {
      return (int) (this.cost - o.cost);
    }
  }

  static int N;
  static long[] X, Y;
  static int[] parent;
  static double E, answer;
  static ArrayList<Node> distance;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();

    int T = Integer.parseInt(br.readLine());

    for (int t = 1; t <= T; t++) {
      sb.append("#").append(t).append(" ");

      N = Integer.parseInt(br.readLine());

      X = new long[N];
      Y = new long[N];
      parent = new int[N];
      distance = new ArrayList<>();

      st = new StringTokenizer(br.readLine());
      for (int i = 0; i < N; i++) {
        X[i] = Integer.parseInt(st.nextToken());
      }

      st = new StringTokenizer(br.readLine());
      for (int i = 0; i < N; i++) {
        Y[i] = Integer.parseInt(st.nextToken());
      }

      E = Double.parseDouble(br.readLine());

      // 거리 계산 table
      for (int i = 0; i < N; i++) {
        for (int j = i + 1; j < N; j++) {
          Node n = new Node(i, j, Math.pow((X[i] - X[j]), 2) + Math.pow((Y[i] - Y[j]), 2));
          distance.add(n);
        }
      }

      Collections.sort(distance);

      for (int i = 0; i < N; i++) {
        parent[i] = i;
      }

      double answer = 0;
      int cnt = 0, idx = 0;

      while (cnt < N - 1 && idx < N * (N - 1)) {
        Node n = distance.get(idx);

        idx++;

        int p1 = find(n.from);
        int p2 = find(n.to);

        if (p1 == p2)
          continue;

        union(p1, p2);
        answer += n.cost;

        cnt++;
      }

      answer *= E;

      sb.append(String.format("%.0f", answer)).append("\n");
    }

    System.out.println(sb);
  }

  private static void union(int p1, int p2) {

    if (p1 < p2)
      parent[p2] = p1;
    else
      parent[p1] = p2;

  }

  private static int find(int n) {

    if (n == parent[n])
      return n;

    return parent[n] = find(parent[n]);

  }

}