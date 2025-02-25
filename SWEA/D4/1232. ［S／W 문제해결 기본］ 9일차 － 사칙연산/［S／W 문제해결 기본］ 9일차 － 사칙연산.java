import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

  static int N;
  static Node[] tree;

  static class Node {
    String value;
    int left, right;

    Node(String value, int left, int right) {
      this.value = value;
      this.left = left;
      this.right = right;
    }
  }

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    for (int t = 1; t <= 10; t++) {
      sb.append("#").append(t).append(" ");

      N = Integer.parseInt(br.readLine());

      tree = new Node[N + 1];

      for (int i = 1; i <= N; i++) {
        String[] tmp = br.readLine().split(" ");

        if (tmp.length > 2)
          tree[Integer.parseInt(tmp[0])] =
              new Node(tmp[1], Integer.parseInt(tmp[2]), Integer.parseInt(tmp[3]));

        else {
          tree[Integer.parseInt(tmp[0])] = new Node(tmp[1], -1, -1);
        }

      }

      int result = (int) postOrder(1);

      sb.append(result).append("\n");

    }

    System.out.println(sb);
  }

  private static double postOrder(int i) {

    if (i == -1)
      return 0;


    Node node = tree[i];

    if (node.left == -1 && node.right == -1)
      return Double.parseDouble(node.value);

    double left = node.left != -1 ? postOrder(node.left) : 0;
    double right = node.right != -1 ? postOrder(node.right) : 0;

    switch (node.value) {
      case "+":
        return left + right;
      case "-":
        return left - right;
      case "*":
        return left * right;
      case "/":
        return left / right;
      default:
        return 0;
    }
  }
}

// #1 13
// #2 20
// #3 35
// #4 107
// #5 369
// #6 76
// #7 123
// #8 313
// #9 238
// #10 2