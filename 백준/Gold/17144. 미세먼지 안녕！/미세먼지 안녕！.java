import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

  static int R, C, T;
  static int[][] board, tmpBoard;

  static int[] drs = {0, 0, 1, -1}, dcs = {1, -1, 0, 0};

  static List<Integer> machine = new ArrayList<>();
  static List<int[]> dust = new ArrayList<>(), newDust = new ArrayList<>();
  static List<int[]> topCoor, bottomCoor;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    R = Integer.parseInt(st.nextToken());
    C = Integer.parseInt(st.nextToken());
    T = Integer.parseInt(st.nextToken());
    board = new int[R][C];

    for (int r = 0; r < R; r++) {
      st = new StringTokenizer(br.readLine());
      for (int c = 0; c < C; c++) {
        board[r][c] = Integer.parseInt(st.nextToken());

        if (board[r][c] == -1) {
          machine.add(r);
        } else if (board[r][c] > 0) {
          dust.add(new int[] {r, c});
        }
      }
    }

    initMachine();

    int r, c, nc, nr, cnt;
    for (int t = 0; t < T; t++) {

      // 먼지 확산
      tmpBoard = new int[R][C];

      for (int[] arr : dust) {
        r = arr[0];
        c = arr[1];
        cnt = 0;

        for (int d = 0; d < 4; d++) {
          nr = r + drs[d];
          nc = c + dcs[d];

          if (canGo(nr, nc)) {
            tmpBoard[nr][nc] += board[r][c] / 5;
            cnt++;
          }
        }
        tmpBoard[r][c] += board[r][c] - cnt * (board[r][c] / 5);
      }

      // 바람 순환

      top();
      bottom();

      dust.clear();
      for (r = 0; r < R; r++) {
        for (c = 0; c < C; c++) {
          board[r][c] = tmpBoard[r][c];
          if (board[r][c] > 0) {
            dust.add(new int[] {r, c});
          }
        }
      }

      board[machine.get(0)][0] = -1;
      board[machine.get(1)][0] = -1;
    }

    int ans = 0;
    for (r = 0; r < R; r++) {
      for (c = 0; c < C; c++) {
        ans += board[r][c];
      }
    }

    System.out.println(ans + 2);

  }


  private static void top() {

    List<Integer> tDust = new ArrayList<>();

    for (int[] arr : topCoor) {
      tDust.add(tmpBoard[arr[0]][arr[1]]);
    }

    tmpBoard[topCoor.get(0)[0]][topCoor.get(0)[1]] = 0;
    for (int i = 1; i < topCoor.size(); i++) {
      tmpBoard[topCoor.get(i)[0]][topCoor.get(i)[1]] = tDust.get(i - 1);
    }
  }


  private static void bottom() {

    List<Integer> bDust = new ArrayList<>();

    for (int[] arr : bottomCoor) {
      bDust.add(tmpBoard[arr[0]][arr[1]]);
    }

    tmpBoard[bottomCoor.get(0)[0]][bottomCoor.get(0)[1]] = 0;
    for (int i = 1; i < bottomCoor.size(); i++) {
      tmpBoard[bottomCoor.get(i)[0]][bottomCoor.get(i)[1]] = bDust.get(i - 1);
    }

  }


  private static void initMachine() {
    int tr = machine.get(0);

    topCoor = new ArrayList<>();

    // ->
    for (int c = 1; c < C; c++) {
      topCoor.add(new int[] {tr, c});
    }

    // up
    for (int r = tr - 1; r >= 0; r--) {
      topCoor.add(new int[] {r, C - 1});
    }


    // <-
    for (int c = C - 2; c >= 0; c--) {
      topCoor.add(new int[] {0, c});
    }


    // down
    for (int r = 1; r < tr; r++) {
      topCoor.add(new int[] {r, 0});
    }

    // ////////

    int br = machine.get(1);

    bottomCoor = new ArrayList<>();

    // ->
    for (int c = 1; c < C; c++) {
      bottomCoor.add(new int[] {br, c});
    }

    // down
    for (int r = br + 1; r < R; r++) {
      bottomCoor.add(new int[] {r, C - 1});
    }

    // <-
    for (int c = C - 2; c >= 0; c--) {
      bottomCoor.add(new int[] {R - 1, c});
    }

    // up
    for (int r = R - 2; r > br; r--) {
      bottomCoor.add(new int[] {r, 0});
    }
  }

  private static boolean canGo(int r, int c) {

    if (r < 0 || r >= R || c < 0 || c >= C)
      return false;

    if (board[r][c] == -1)
      return false;

    return true;
  }


}