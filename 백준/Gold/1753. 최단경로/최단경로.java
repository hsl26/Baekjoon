import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

  static class Pair implements Comparable<Pair> {
    int p, weight;

    public Pair(int next, int w) {
      p = next;
      weight = w;
    }

    @Override
    public int compareTo(Pair other) {
      return this.weight - other.weight;
    }
  }

  static int V, E, K;

  static final int INF = Integer.MAX_VALUE;
  static List<Pair>[] graph;
  static int[] distance;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    V = Integer.parseInt(st.nextToken());
    E = Integer.parseInt(st.nextToken());

    K = Integer.parseInt(br.readLine());

    graph = new ArrayList[V + 1];
    distance = new int[V + 1];
    Arrays.fill(distance, INF);

    for (int i = 1; i <= V; i++) {
      graph[i] = new ArrayList<>();
    }

    for (int i = 0; i < E; i++) {
      st = new StringTokenizer(br.readLine());
      int u = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());
      int w = Integer.parseInt(st.nextToken());

      graph[u].add(new Pair(v, w));

    }

    dijkstra();

    StringBuilder sb = new StringBuilder();
    for (int i = 1; i <= V; i++)
      sb.append(distance[i] == Integer.MAX_VALUE ? "INF" : distance[i]).append("\n");
    System.out.println(sb);

  }

  private static void dijkstra() {
    PriorityQueue<Pair> pq = new PriorityQueue<>();
    Arrays.fill(distance, Integer.MAX_VALUE);
    distance[K] = 0;
    pq.add(new Pair(K, 0));

    while (!pq.isEmpty()) {
      Pair curr = pq.poll();
      if (distance[curr.p] < curr.weight)
        continue;
      for (Pair next : graph[curr.p]) {
        int nextWeight = curr.weight + next.weight;
        if (distance[next.p] > nextWeight) {
          distance[next.p] = nextWeight;
          pq.add(new Pair(next.p, nextWeight));
        }
      }
    }

  }


}