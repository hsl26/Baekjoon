import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  static int N, K;
  static int[] board;
  static boolean[] visited;


  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());

    visited = new boolean[200000 + 1];
    board = new int[200000 + 1];

    bfs();

    System.out.println(board[K]);
  }

  private static void bfs() {
    int cur;
    Queue<Integer> q = new LinkedList<>();
    q.add(N);
    visited[N] = true;

    while (!q.isEmpty()) {

      cur = q.remove();

      if (2 * cur < board.length && !visited[2 * cur]) {
        board[2 * cur] = board[cur];
        q.add(2 * cur);
        visited[2 * cur] = true;
      }

      if (cur - 1 >= 0 && !visited[cur - 1]) {
        board[cur - 1] = board[cur] + 1;
        q.add(cur - 1);
        visited[cur - 1] = true;
      }

      if (cur + 1 < board.length && !visited[cur + 1]) {
        board[cur + 1] = board[cur] + 1;
        q.add(cur + 1);
        visited[cur + 1] = true;
      }



    }

  }


}