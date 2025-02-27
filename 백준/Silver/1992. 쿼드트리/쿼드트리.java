import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

  static int N;

  static int[][] board;

  static StringBuilder sb = new StringBuilder();;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());

    board = new int[N][N];

    for (int r = 0; r < N; r++) {
      String[] arr = br.readLine().split("");
      for (int c = 0; c < N; c++) {
        board[r][c] = Integer.parseInt(arr[c]);
      }
    }

    isSame(0, N, 0, N);

    System.out.println(sb);
  }

  private static void isSame(int sr, int er, int sc, int ec) {

    if (er - sr == 1 && ec - sc == 1) {
      sb.append(board[sr][sc]);
      return;
    }

    int n = board[sr][sc];
    int sum = 0;

    for (int r = sr; r < er; r++) {
      for (int c = sc; c < ec; c++) {
        sum += board[r][c];
      }
    }

    int midR = (sr + er) / 2;
    int midC = (sc + ec) / 2;

    if (sum != ((er - sr) * (ec - sc)) * n) {
      sb.append("(");


      isSame(sr, midR, sc, midC); // 1사분면
      isSame(sr, midR, midC, ec); // 2사분면
      isSame(midR, er, sc, midC); // 3사분면
      isSame(midR, er, midC, ec); // 4사분면

      sb.append(")");
    } else {
      sb.append(n + "");
    }

  }

}