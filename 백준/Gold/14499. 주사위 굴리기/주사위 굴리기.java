import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  static int N, M, x, y, K;
  static int[][] board;
  static int[] dice = new int[6]; // 0: top, 1: bottom, 2: left, 3: right, 4: front, 5: back


  static int[] dx = {0, 0, -1, 1};
  static int[] dy = {1, -1, 0, 0};

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    x = Integer.parseInt(st.nextToken());
    y = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());

    board = new int[N][M];

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; j++) {
        board[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < K; i++) {
      int dir = Integer.parseInt(st.nextToken()) - 1;
      int nx = x + dx[dir];
      int ny = y + dy[dir];

      if (nx < 0 || ny < 0 || nx >= N || ny >= M)
        continue;

      roll(dir); // 주사위 회전
      x = nx;
      y = ny;

      if (board[x][y] == 0) {
        board[x][y] = dice[1]; // 바닥값 복사
      } else {
        dice[1] = board[x][y]; // 주사위에 복사
        board[x][y] = 0;
      }

      System.out.println(dice[0]); // 윗면 출력
    }
  }

  static void roll(int dir) {
    int temp;
    switch (dir) {
      case 0: // 동쪽
        temp = dice[0];
        dice[0] = dice[2];
        dice[2] = dice[1];
        dice[1] = dice[3];
        dice[3] = temp;
        break;
      case 1: // 서쪽
        temp = dice[0];
        dice[0] = dice[3];
        dice[3] = dice[1];
        dice[1] = dice[2];
        dice[2] = temp;
        break;
      case 2: // 북쪽
        temp = dice[0];
        dice[0] = dice[4];
        dice[4] = dice[1];
        dice[1] = dice[5];
        dice[5] = temp;
        break;
      case 3: // 남쪽
        temp = dice[0];
        dice[0] = dice[5];
        dice[5] = dice[1];
        dice[1] = dice[4];
        dice[4] = temp;
        break;
    }
  }
}