import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

  static int N, X, answer;
  static int[][] board;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();

    int T = Integer.parseInt(br.readLine());

    for (int t = 1; t <= T; t++) {
      sb.append("#").append(t).append(" ");

      st = new StringTokenizer(br.readLine());
      N = Integer.parseInt(st.nextToken());
      X = Integer.parseInt(st.nextToken());

      board = new int[N][N];
      for (int r = 0; r < N; r++) {
        st = new StringTokenizer(br.readLine());
        for (int c = 0; c < N; c++) {
          board[r][c] = Integer.parseInt(st.nextToken());
        }
      }

      answer = 0;

      // 가로
      boolean can = true;
      int v = 0, cnt = 0;
      for (int r = 0; r < N; r++) {
        v = board[r][0];
        cnt = 1;
        can = true;

        for (int c = 1; c < N; c++) {
          if (v == board[r][c])
            cnt++;
          else if (v + 1 == board[r][c]) {
            if (cnt >= X) {
              v = v + 1;
              cnt = 1;
            } else {
              can = false;
            }
          } else if (v - 1 == board[r][c]) {
            if (c + X > N) {
              can = false;
              break;
            }
            for (int i = c; i < c + X; i++) {
              if (board[r][i] != v - 1) {
                can = false;
                break;
              }
            }

            c = c + X - 1;
            v = v - 1;
            cnt = 0;
          } else {
            can = false;
          }

          if (!can)
            break;
        }

        if (can)
          answer++;
      }


      // ㅔ로
      can = true;
      v = 0;
      cnt = 0;
      for (int c = 0; c < N; c++) {
        v = board[0][c];
        cnt = 1;
        can = true;

        for (int r = 1; r < N; r++) {
          if (v == board[r][c])
            cnt++;
          else if (v + 1 == board[r][c]) {
            if (cnt >= X) {
              v = v + 1;
              cnt = 1;
            } else {
              can = false;
            }
          } else if (v - 1 == board[r][c]) {
            if (r + X > N) {
              can = false;
              break;
            }
            for (int i = r; i < r + X; i++) {
              if (board[i][c] != v - 1) {
                can = false;
                break;
              }
            }

            r = r + X - 1;
            v = v - 1;
            cnt = 0;
          } else {
            can = false;
          }

          if (!can)
            break;
        }

        if (can)
          answer++;
      }


      sb.append(answer).append("\n");
    }
    System.out.println(sb);
  }
}