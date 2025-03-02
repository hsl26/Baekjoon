import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringBuilder sb = new StringBuilder();

    int T = Integer.parseInt(br.readLine());

    for (int t = 0; t < T; t++) {
      String[] arr = br.readLine().split("");

      int sum = 0;
      int cnt = 0;
      for (int i = 0; i < arr.length; i++) {
        if (arr[i].equals("O")) {
          cnt++;
        } else {
          sum += cnt * (1 + cnt) / 2;
          cnt = 0;
        }
      }

      if (cnt != 0) {
        sum += cnt * (1 + cnt) / 2;
      }

      sb.append(sum).append("\n");
    }
    System.out.println(sb);
  }

}