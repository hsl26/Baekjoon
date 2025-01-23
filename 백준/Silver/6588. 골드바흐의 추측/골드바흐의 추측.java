import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

  final static int MAX = 1000001;
  static boolean[] prime = new boolean[MAX];

  static void makePrimeArray() {

    Arrays.fill(prime, true);

    prime[0] = false;
    prime[1] = false;
    for (int i = 2; i * i < MAX; i++) {
      if (prime[i]) {
        for (int j = i + i; j < MAX; j += i) {
          prime[j] = false;
        }
      }
    }

  }

  static {
    makePrimeArray();
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    while (true) {
      int n = Integer.parseInt(br.readLine());

      if (n == 0) {
        break;
      }


      int p1 = -1, p2 = -1;

      for (int i = 2; i < n / 2 + 1; i++) {

        if (prime[i] && prime[n - i]) {
          p1 = i;
          p2 = n - i;
          break;
        }
      }

      if (p1 != -1 && p2 != -1) {
        bw.write(n + " = " + p1 + " + " + p2 + "\n");
      } else {
        bw.write("Goldbach's conjecture is wrong.\n");
      }

    }

    bw.flush();
    bw.close();

  }
}
