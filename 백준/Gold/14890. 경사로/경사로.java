import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  static int N, L, cnt, cur;

  static int[][] board;

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    L = Integer.parseInt(st.nextToken());

    board = new int[N][N];

    for (int r = 0; r < N; r++) {
      st = new StringTokenizer(br.readLine());
      for (int c = 0; c < N; c++) {
        board[r][c] = Integer.parseInt(st.nextToken());
      }
    }

    int answer = 0;

    for (int r = 0; r < N; r++) {
      cnt = 1;
      cur = board[r][0];

      for (int c = 1; c < N; c++) {

        if (board[r][c] - 1 == cur) {
          if (cnt >= L) {
            cur = board[r][c];
            cnt = 1;
          } else {
            answer -= 1;
            break;
          }
        }

        else if (board[r][c] + 1 == cur) {
          int tmp = 0;
          for (int i = c; i < N; i++) {
            if (board[r][c] == board[r][i])
              tmp++;
            else
              break;
          }
          if (tmp >= L) {
            cur = board[r][c];
            cnt = 0;
            c += L - 1;
          } else {
            answer -= 1;
            break;
          }
        }

        else if (cur == board[r][c]) {
          cnt++;
        } else {
          answer -= 1;
          break;
        }
      }

      answer++;
    }

    for (int c = 0; c < N; c++) {
      cnt = 1;
      cur = board[0][c];

      for (int r = 1; r < N; r++) {

        if (board[r][c] - 1 == cur) {
          if (cnt >= L) {
            cur = board[r][c];
            cnt = 1;
          } else {
            answer -= 1;
            break;
          }
        }

        else if (board[r][c] + 1 == cur) {
          int tmp = 0;
          for (int i = r; i < N; i++) {
            if (board[r][c] == board[i][c])
              tmp++;
            else
              break;
          }
          if (tmp >= L) {
            cur = board[r][c];
            cnt = 0;
            r += L - 1;
          } else {
            answer -= 1;
            break;
          }
        }

        else if (cur == board[r][c]) {
          cnt++;
        } else {
          answer -= 1;
          break;
        }
      }

      answer++;
    }

    System.out.println(answer);

  }
}