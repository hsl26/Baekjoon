import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  static int N, n;
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());

    prime(2);
    prime(3);
    prime(5);
    prime(7);

    System.out.println(sb);
  }

  private static void prime(int num) {

    if (num >= Math.pow(10, N - 1) && num < Math.pow(10, N)) {
      sb.append(num).append("\n");
      return;
    }

    for (int i = 0; i < 10; i++) {
      n = num * 10 + i;
      if (isPrime(n)) {
        prime(n);
      }
    }
  }

  private static boolean isPrime(int num) {

    for (int i = 2; i <= Math.sqrt(num); i++) {
      if (num % i == 0)
        return false;
    }
    return true;
  }


}