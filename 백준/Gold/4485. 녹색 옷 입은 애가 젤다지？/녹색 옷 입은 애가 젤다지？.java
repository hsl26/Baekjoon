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

  static final int INF = 125 * 125 * 9 + 1;
  static List<Pair>[] graph;
  static int[] distance;

  static int[][] board;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();
    int t = 1;

    while (true) {
      int N = Integer.parseInt(br.readLine());

      if (N == 0) {
        System.out.println(sb);
        return;
      }
      sb.append("Problem ").append(t).append(": ");
      t++;

      board = new int[N][N];
      graph = new ArrayList[N * N + 1];
      distance = new int[N * N + 1];
      Arrays.fill(distance, INF);

      for (int i = 1; i <= N * N; i++) {
        graph[i] = new ArrayList<>();
      }

      for (int r = 0; r < N; r++) {
        st = new StringTokenizer(br.readLine());
        for (int c = 0; c < N; c++) {
          board[r][c] = Integer.parseInt(st.nextToken());
        }
      }

      int now = 0;

      for (int r = 0; r < N; r++) {
        for (int c = 0; c < N; c++) {

          now += 1;

          if (r != 0)
            graph[now].add(new Pair(now - N, board[r - 1][c]));
          if (r != N - 1)
            graph[now].add(new Pair(now + N, board[r + 1][c]));
          if (c != 0)
            graph[now].add(new Pair(now - 1, board[r][c - 1]));
          if (c != N - 1)
            graph[now].add(new Pair(now + 1, board[r][c + 1]));

        }
      }


      dijkstra();

      sb.append(distance[N * N]).append("\n");
    }
  }

  private static void dijkstra() {

    PriorityQueue<Pair> pq = new PriorityQueue<>();

    distance[1] = board[0][0];
    pq.add(new Pair(1, board[0][0]));

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