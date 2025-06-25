import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());

    int a = 1, b = 1, sum = 0, cnt = 0;
    while (a <= N) {
      sum = (b - a + 1) * (a + b) / 2;

      if (sum == N) {
        cnt++;
        a++;
      } else if (sum < N) {
        b++;
      } else {
        a++;
      }
    }

    System.out.println(cnt);

  }

}