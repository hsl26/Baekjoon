import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringBuilder sb = new StringBuilder();

    int[] arr = new int[10];


    int A, B, C;
    A = Integer.parseInt(br.readLine());
    B = Integer.parseInt(br.readLine());
    C = Integer.parseInt(br.readLine());

    A *= B * C;

    while (A > 0) {
      arr[A % 10] += 1;
      A /= 10;
    }

    for (int i = 0; i < 10; i++) {
      sb.append(arr[i]).append("\n");
    }

    System.out.println(sb);
  }

}