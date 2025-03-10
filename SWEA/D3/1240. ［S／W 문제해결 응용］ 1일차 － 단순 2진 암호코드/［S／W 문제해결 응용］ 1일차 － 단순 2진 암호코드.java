import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Solution {

  static int N, M, startR, startC, answer;

  static Map<String, Integer> pw = new HashMap<>();;

  static String[] pws = {"0001101", "0011001", "0010011", "0111101", "0100011", "0110001",
      "0101111", "0111011", "0110111", "0001011"};

  static String[][] board;

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < 10; i++) {
      pw.put(pws[i], i);
    }

    int T = Integer.parseInt(br.readLine());

    for (int t = 1; t <= T; t++) {
      sb.append("#").append(t).append(" ");
      StringTokenizer st = new StringTokenizer(br.readLine());

      N = Integer.parseInt(st.nextToken());
      M = Integer.parseInt(st.nextToken());

      board = new String[N][M];

      for (int r = 0; r < N; r++) {
        String[] arr = br.readLine().split("");

        for (int c = 0; c < M; c++) {
          board[r][c] = arr[c];
        }
      }

      for (int r = 0; r < N; r++) {
        if (Arrays.asList(board[r]).contains("1")) {
          startR = r;
          break;
        }
      }

      for (int c = M - 1; c >= 0; c--) {
        if (board[startR][c].equals("1")) {
          startC = c - 56 + 1;
          break;
        }
      }

      answer = 0;
      isSpy();

      sb.append(answer).append("\n");

    }

    System.out.println(sb);
  }

  private static void isSpy() {
    int sum1 = 0, sum2 = 0;

    String[] password = Arrays.copyOfRange(board[startR], startC, startC + 56);

    for (int i = 0; i < 8; i++) {
      String[] arr = Arrays.copyOfRange(password, i * 7, (i + 1) * 7);

      if (i % 2 == 0) {
        sum1 += pw.get(String.join("", arr));
      } else {
        sum2 += pw.get(String.join("", arr));
      }

      if ((sum1 * 3 + sum2) % 10 == 0) {
        answer = sum1 + sum2;
      }
    }

  }

}