import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

  static int N, K, L, time = 0, dir = 0;

  static int[] drs = {0, 1, 0, -1}, dcs = {1, 0, -1, 0};

  static int[][] board;

  static Queue<int[]> cmd = new LinkedList<>();

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());
    board = new int[N][N];

    K = Integer.parseInt(br.readLine());

    int a, b;
    for (int i = 0; i < K; i++) {
      String[] arr = br.readLine().split(" ");
      a = Integer.parseInt(arr[0]) - 1;
      b = Integer.parseInt(arr[1]) - 1;
      board[a][b] = -1; // 사과
    }

    L = Integer.parseInt(br.readLine());

    for (int i = 0; i < L; i++) {
      String[] arr = br.readLine().split(" ");
      if (arr[1].equals("D"))
        cmd.add(new int[] {Integer.parseInt(arr[0]), 1});
      else
        cmd.add(new int[] {Integer.parseInt(arr[0]), -1});
    }
    cmd.add(new int[] {10001, 0});

    game();

    System.out.println(time);
  }

  private static void game() {
    int r, c, nr, nc;
    Deque<int[]> snake = new LinkedList<>();

    r = c = 0;
    board[r][c] = 1;
    snake.add(new int[] {r, c});
    dir = 0;

    while (true) {

      if (time == cmd.peek()[0]) {
        dir += cmd.peek()[1] + 4;
        dir %= 4;
        cmd.remove();
      }

      time++;

      int[] head = snake.peekLast();
      r = head[0];
      c = head[1];

      nr = r + drs[dir];
      nc = c + dcs[dir];

      if (canGo(nr, nc)) {

        // 사과 O
        if (board[nr][nc] == -1) {
        }

        // 사과 X
        else {
          int[] tail = snake.removeFirst();
          board[tail[0]][tail[1]] = 0;
        }

        board[nr][nc] = 1;
        snake.addLast(new int[] {nr, nc});

      } else {
        return;
      }
    }

  }

  private static boolean canGo(int r, int c) {

    if (r < 0 || r >= N || c < 0 || c >= N)
      return false;

    if (board[r][c] == 1)
      return false;

    return true;
  }


}