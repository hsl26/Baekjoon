import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  static int N, ans = Integer.MAX_VALUE;

  static int[] nums;

  static int[][] board;


  private static void init() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());

    board = new int[N][N];

    for (int r = 0; r < N; r++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int c = 0; c < N; c++) {
        board[r][c] = Integer.parseInt(st.nextToken());
      }
    }

  }

  private static void comb(int cnt, int start) {
    if (cnt == N / 2) {

      int power1 = 0, power2 = 0;

      for (int i = 0; i < N / 2; i++) {
        for (int j = 0; j < N / 2; j++) {
          power1 += board[nums[i]][nums[j]];
        }
      }

      int[] other = new int[N / 2];
      int idx = 0, cur = 0;
      for (int i = 0; i < N; i++) {
        if (idx < N / 2 && i == nums[idx]) {
          idx++;
        } else {
          other[cur++] = i;
        }
      }

      for (int i = 0; i < N / 2; i++) {
        for (int j = 0; j < N / 2; j++) {
          power2 += board[other[i]][other[j]];
        }
      }

      ans = Math.min(ans, Math.abs(power2 - power1));
      return;
    }

    for (int i = start; i < N; i++) {
      nums[cnt] = i;
      comb(cnt + 1, i + 1);
    }

  }


  public static void main(String[] args) throws Exception {

    init();

    nums = new int[N / 2];

    comb(0, 0);

    System.out.println(ans);

  }

}