import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  static int N, M;
  static int[] board, distance;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    distance = new int[101];
    board = new int[101];
    for (int i = 1; i <= 100; i++) {
      board[i] = i;
    }

    int a, b;
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      a = Integer.parseInt(st.nextToken());
      b = Integer.parseInt(st.nextToken());

      board[a] = b;
    }

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      a = Integer.parseInt(st.nextToken());
      b = Integer.parseInt(st.nextToken());

      board[a] = b;
    }

    bfs();

    System.out.println(distance[100]);
  }

  private static void bfs() {
    int cur, next;

    Queue<Integer> q = new LinkedList<>();
    q.add(1);
    distance[1] = 0;

    while (!q.isEmpty()) {
      cur = q.remove();

      for (int i = 1; i <= 6; i++) {
        if (cur + i > 100)
          continue;

        next = board[cur + i];

        if (distance[next] == 0 || distance[next] > distance[cur] + 1) {
          distance[next] = distance[cur] + 1;
          q.add(next);
        }
      }
    }

  }
}
