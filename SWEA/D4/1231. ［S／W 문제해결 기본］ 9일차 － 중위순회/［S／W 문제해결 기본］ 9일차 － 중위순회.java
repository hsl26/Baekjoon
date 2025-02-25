import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

  static int n;

  static String[] tree;

  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    for (int t = 1; t <= 10; t++) {

      sb.append("#").append(t).append(" ");

      n = Integer.parseInt(br.readLine());

      tree = new String[n + 1];

      for (int i = 1; i <= n; i++) {
        String[] arr = br.readLine().split(" ");

        tree[i] = arr[1];
      }

      inOrder(1);

      sb.append("\n");

    }
    System.out.println(sb);
  }

  private static void inOrder(int i) {

    if (i > n)
      return;

    inOrder(2 * i);

    sb.append(tree[i]);

    inOrder(2 * i + 1);

  }
}