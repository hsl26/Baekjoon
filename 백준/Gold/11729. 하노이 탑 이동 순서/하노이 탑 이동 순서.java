import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  static int K, cnt = 0;

  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    K = Integer.parseInt(st.nextToken());

    Hanoi(K, 1, 3, 2);

    System.out.println(cnt);
    System.out.println(sb);

  }

  private static void Hanoi(int n, int start, int end, int sub) {

    if (n > 0) {
      Hanoi(n - 1, start, sub, end);
      sb.append(start).append(" ").append(end).append("\n");
      cnt++;
      Hanoi(n - 1, sub, end, start);
    }

  }
}