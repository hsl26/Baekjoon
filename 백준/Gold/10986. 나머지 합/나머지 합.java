import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  static int N, M;

  static long[] A, Mod, sum;

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    A = new long[N + 1];
    sum = new long[N + 1];
    Mod = new long[M];

    st = new StringTokenizer(br.readLine());

    for (int i = 1; i <= N; i++) {
      A[i] = Integer.parseInt(st.nextToken()) % M;

      sum[i] = (sum[i - 1] + A[i]) % M;
    }

    long cnt = 0;

    for (int i = 0; i <= N; i++) {
      Mod[(int) sum[i]]++;
    }

    for (int i = 0; i < M; i++) {
      cnt += (Mod[i] * (Mod[i] - 1)) / 2;
    }

    System.out.println(cnt);

  }
}