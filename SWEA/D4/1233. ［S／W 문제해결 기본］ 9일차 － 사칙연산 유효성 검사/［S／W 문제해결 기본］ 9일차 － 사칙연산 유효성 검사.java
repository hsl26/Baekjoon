import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

  static int N;
  static int answer = 1;
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

        if (tmp.length > 3)
          tree[Integer.parseInt(tmp[0])] =
              new Node(tmp[1], Integer.parseInt(tmp[2]), Integer.parseInt(tmp[3]));
        else if (tmp.length > 2)
          tree[Integer.parseInt(tmp[0])] = new Node(tmp[1], Integer.parseInt(tmp[2]), -1);
        else {
          tree[Integer.parseInt(tmp[0])] = new Node(tmp[1], -1, -1);
        }

      }

      answer = 1;
      postOrder(1);

      sb.append(answer).append("\n");

    }

    System.out.println(sb);
  }

  private static void postOrder(int i) {

    if (i == -1)
      return;


    Node node = tree[i];

    postOrder(node.left);
    postOrder(node.right);

    if (node.left == -1 || node.right == -1) {
      if (tree[i].value.equals("+") || tree[i].value.equals("-") || tree[i].value.equals("*")
          || tree[i].value.equals("/")) {
        answer *= 0;
        return;
      }
    }

    return;
  }
}