import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

  static int N;

  static int[] DP;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());
    DP = new int[N + 1];

    Arrays.fill(DP, 1000001);


    DP[1] = 0;

    for (int i = 1; i <= N; i++) {

      if (i + 1 <= N && DP[i + 1] > DP[i] + 1)
        DP[i + 1] = DP[i] + 1;

      if (i * 2 <= N && DP[i * 2] > DP[i] + 1)
        DP[i * 2] = DP[i] + 1;

      if (i * 3 <= N && DP[i * 3] > DP[i] + 1)
        DP[i * 3] = DP[i] + 1;

    }

    System.out.println(DP[N]);


    StringBuilder sb = new StringBuilder();
    Queue<Integer> q = new LinkedList<>();

    q.add(N);

    while (!q.isEmpty()) {
      int n = q.poll();
      sb.append(n).append(" ");

      if (DP[n] - 1 == DP[n - 1]) {
        q.add(n - 1);
      } else if (n % 2 == 0 && DP[n] - 1 == DP[n / 2]) {
        q.add(n / 2);
      } else if (n % 3 == 0 && DP[n] - 1 == DP[n / 3]) {
        q.add(n / 3);
      }
    }

    System.out.println(sb);

  }
}