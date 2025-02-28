import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

  static class Node implements Comparable<Node> {
    int vertex, cost;

    public Node(int vertex, int cost) {
      this.vertex = vertex;
      this.cost = cost;
    }

    @Override
    public int compareTo(Node other) {
      return Integer.compare(this.cost, other.cost);
    }
  }

  static int V, E, K;

  static final int INF = Integer.MAX_VALUE;
  static List<Node>[] graph;
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

      graph[u].add(new Node(v, w));

    }

    dijkstra();

    for (int i = 1; i <= V; i++) {
      if (distance[i] == INF) {
        System.out.println("INF");
      } else {
        System.out.println(distance[i]);
      }
    }

  }

  private static void dijkstra() {

    PriorityQueue<Node> pq = new PriorityQueue<>();
    pq.offer(new Node(K, 0));
    distance[K] = 0;

    while (!pq.isEmpty()) {
      Node current = pq.poll();
      int dist = current.cost;
      int now = current.vertex;

      if (distance[now] < dist)
        continue;

      for (Node neighbor : graph[now]) {
        int cost = dist + neighbor.cost;
        if (cost < distance[neighbor.vertex]) {
          distance[neighbor.vertex] = cost;
          pq.offer(new Node(neighbor.vertex, cost));
        }
      }
    }

  }


}