import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    for (int t = 1; t <= 10; t++) {
      br.readLine();

      int[][] board = new int[100][100];

      for (int r = 0; r < 100; r++) {
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int c = 0; c < 100; c++) {
          board[r][c] = Integer.parseInt(st.nextToken());
        }
      }

      int answer = 0;
      for (int r = 0; r < 100; r++) {
        for (int c = 0; c < 100; c++) {
          if (board[r][c] == 1) {
            for (int i = r + 1; i < 100; i++) {
              if (board[i][c] == 2) {
                answer++;
                break;
              }
              if (board[i][c] == 1)
                break;
            }
            board[r][c] = 0;
          }
        }
      }

      sb.append("#").append(t).append(" ").append(answer).append("\n");

    }
    System.out.println(sb);
  }


}