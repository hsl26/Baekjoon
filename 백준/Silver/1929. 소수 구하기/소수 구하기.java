import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

  public static boolean isPrime(int n) {

    if (n == 2) {
      return true;
    }

    for (int i = 2; i < Math.sqrt(n * 1.0) + 1; i++) {
      if (n % i == 0) {
        return false;
      }
    }

    return true;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String[] arr = br.readLine().split(" ");
    int M = Integer.parseInt(arr[0]), N = Integer.parseInt(arr[1]);

    for (int i = Math.max(2, M); i <= N; i++) {
      if (isPrime(i)) {
        bw.write(i + "\n");
      }
    }

    bw.flush();
    bw.close();

  }
}
