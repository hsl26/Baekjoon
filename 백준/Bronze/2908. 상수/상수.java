import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringBuilder sb = new StringBuilder();

    StringTokenizer st = new StringTokenizer(br.readLine());

    int A = Integer.parseInt(st.nextToken());
    int B = Integer.parseInt(st.nextToken());

    int o = A / 100;
    int t = A % 10;

    A = A - o * 100 + o - t + t * 100;

    o = B / 100;
    t = B % 10;

    B = B - o * 100 + o - t + t * 100;

    System.out.println(Math.max(A, B));
  }

}