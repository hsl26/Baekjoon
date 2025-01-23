import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  static int cntFive(int n) {
    int cnt = 0;
    while (n % 5 == 0 && n > 1) {
      cnt++;
      n /= 5;
    }
    return cnt;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    int cnt = 0, tmp = 1;

    while (N >= 5) {
      if (N % 5 == 0) {
        cnt += cntFive(N);
      }
      N--;
    }

    System.out.println(cnt);

  }
}
