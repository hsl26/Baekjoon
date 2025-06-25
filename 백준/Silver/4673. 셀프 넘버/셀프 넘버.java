import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int[] arr = new int[10001];

    for (int i = 1; i <= 10000; i++) {

      int n = i;
      int tmp = n;
      while (n != 0) {
        tmp += n % 10;
        n /= 10;
      }

      if (tmp <= 10000) {
        arr[tmp] = 1;
      }
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 1; i <= 10000; i++) {
      if (arr[i] == 0) {
        sb.append(i).append("\n");
      }
    }

    System.out.println(sb);

  }

}