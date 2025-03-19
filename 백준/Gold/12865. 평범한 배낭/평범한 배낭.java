import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    int[] W = new int[N + 1];
    int[] V = new int[N + 1];
    int[][] DP = new int[N + 1][K + 1];

    for (int i = 1; i <= N; i++) {
      st = new StringTokenizer(br.readLine());
      W[i] = Integer.parseInt(st.nextToken());
      V[i] = Integer.parseInt(st.nextToken());
    }

    for (int i = 1; i <= N; i++) {
      for (int w = 0; w <= K; w++) {
        if (w >= W[i])
          DP[i][w] = Math.max(DP[i - 1][w], DP[i - 1][w - W[i]] + V[i]);
        else
          DP[i][w] = DP[i - 1][w];
      }
    }

    System.out.println(DP[N][K]);

  }
}