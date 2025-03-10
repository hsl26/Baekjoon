import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

  static int N, M, chickenLen = Integer.MAX_VALUE;

  static int[][] board, distance;

  static int[] choose;

  static ArrayList<int[]> chicken = new ArrayList<>();
  static ArrayList<int[]> house = new ArrayList<>();

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    board = new int[N][N];
    choose = new int[M];

    for (int r = 0; r < N; r++) {
      st = new StringTokenizer(br.readLine());

      for (int c = 0; c < N; c++) {
        board[r][c] = Integer.parseInt(st.nextToken());
        if (board[r][c] == 2)
          chicken.add(new int[] {r, c});

        else if (board[r][c] == 1)
          house.add(new int[] {r, c});
      }
    }

    int hSize = house.size();
    int cSize = chicken.size();
    distance = new int[hSize][cSize];

    for (int h = 0; h < hSize; h++) {
      for (int c = 0; c < cSize; c++) {
        distance[h][c] = Math.abs(house.get(h)[0] - chicken.get(c)[0])
            + Math.abs(house.get(h)[1] - chicken.get(c)[1]);
      }
    }

    comb(0, 0);

    System.out.println(chickenLen);
  }

  private static void comb(int c, int d) {

    if (d == M) {
      chickenLen = Math.min(chickenLen, cal());
      return;
    }

    for (int i = c; i < chicken.size(); i++) {
      choose[d] = i;
      comb(i + 1, d + 1);
    }

  }

  private static int cal() {

    int total = 0;

    for (int h = 0; h < house.size(); h++) {
      int len = Integer.MAX_VALUE;

      for (int c = 0; c < M; c++) {

        len = Math.min(len, distance[h][choose[c]]);
      }

      total += len;

      if (total > chickenLen)
        break;
    }

    return total;
  }
}