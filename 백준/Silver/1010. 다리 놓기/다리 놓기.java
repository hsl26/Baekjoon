import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int T = Integer.parseInt(br.readLine());

    for (int t = 0; t < T; t++) {
      StringTokenizer st = new StringTokenizer(br.readLine());

      int N, M;
      N = Integer.parseInt(st.nextToken());
      M = Integer.parseInt(st.nextToken());

      int max = Math.max(M - N, N);
      int min = Math.min(M - N, N);

      long answer = 1;

      for (int i = max + 1; i <= M; i++) {
        answer *= i;
      }

      for (int i = 1; i <= min; i++) {
        answer /= i;
      }

      System.out.println(answer);
    }
  }
}