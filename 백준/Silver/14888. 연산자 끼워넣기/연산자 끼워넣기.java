import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  static int N;
  static int answerMin = Integer.MAX_VALUE;
  static int answerMax = Integer.MIN_VALUE;

  static int[] A;
  static int[] cal = new int[4];

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());

    StringTokenizer st = new StringTokenizer(br.readLine());

    A = new int[N];

    for (int i = 0; i < N; i++) {
      A[i] = Integer.parseInt(st.nextToken());
    }

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < 4; i++) {
      cal[i] = Integer.parseInt(st.nextToken());
    }

    bt(A[0], 1);

    System.out.println(answerMax);
    System.out.println(answerMin);
  }

  private static void bt(int sum, int idx) {
    if (idx == N) {
      answerMax = Math.max(answerMax, sum);
      answerMin = Math.min(answerMin, sum);
      return;
    }

    for (int d = 0; d < 4; d++) {
      if (cal[d] == 0)
        continue;

      cal[d]--;

      if (d == 0) {
        bt(sum + A[idx], idx + 1);
      } else if (d == 1) {
        bt(sum - A[idx], idx + 1);
      } else if (d == 2) {
        bt(sum * A[idx], idx + 1);
      } else {
        bt(sum / A[idx], idx + 1);
      }

      cal[d]++;

    }
  }

}