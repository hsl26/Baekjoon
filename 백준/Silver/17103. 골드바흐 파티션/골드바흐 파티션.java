import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

  static int MAX_INT = 1000001;
  static boolean[] num = new boolean[MAX_INT];

  static {
    Arrays.fill(num, true);
    num[0] = num[1] = false;
    for (int i = 2; i < MAX_INT; i++) {
      if (num[i]) {
        for (int j = i + i; j < MAX_INT; j += i) {
          num[j] = false;
        }
      }
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int T = Integer.parseInt(br.readLine());

    for (int i = 0; i < T; i++) {
      int N = Integer.parseInt(br.readLine()), cnt = 0;
      for (int n = 1; n < N / 2 + 1; n++) {
        if (num[n] && num[N - n]) {
          cnt++;
        }
      }
      System.out.println(cnt);
    }

  }
}
