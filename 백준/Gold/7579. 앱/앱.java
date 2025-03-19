import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    int[] mArr = new int[N + 1];
    int[] cArr = new int[N + 1];

    st = new StringTokenizer(br.readLine());
    for (int i = 1; i <= N; i++) {
      mArr[i] = Integer.parseInt(st.nextToken());
    }

    int cSum = 0;
    st = new StringTokenizer(br.readLine());
    for (int i = 1; i <= N; i++) {
      cArr[i] = Integer.parseInt(st.nextToken());
      cSum += cArr[i];
    }

    int[][] DP = new int[N + 1][cSum + 1];
    int answer = cSum;

    for (int i = 1; i <= N; i++) {
      for (int c = 0; c <= cSum; c++) {

        if (c >= cArr[i])
          DP[i][c] = Math.max(DP[i - 1][c], DP[i - 1][c - cArr[i]] + mArr[i]);
        else
          DP[i][c] = DP[i - 1][c];

        if (DP[i][c] >= M)
          answer = Math.min(answer, c);


      }
    }

    System.out.println(answer);

  }
}