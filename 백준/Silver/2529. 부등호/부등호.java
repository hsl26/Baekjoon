import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

  static int k;
  static boolean[] visited;
  static String[] arr, r;

  static ArrayList<String> res;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    k = Integer.parseInt(br.readLine());
    arr = br.readLine().split(" ");
    visited = new boolean[10];
    res = new ArrayList<>();

    r = new String[k + 1];

    for (int i = 0; i < 10; i++) {
      visited[i] = true;
      r[0] = String.valueOf(i);
      bt(0, i);
      visited[i] = false;
    }

    Collections.sort(res);

    System.out.println(res.get(res.size() - 1));
    System.out.println(res.get(0));
  }

  private static void bt(int d, int n) {
    if (d == k) {
      res.add(String.join("", r));
      return;
    }

    if (arr[d].equals("<")) {
      for (int i = n + 1; i < 10; i++) {
        if (!visited[i]) {
          visited[i] = true;
          r[d + 1] = String.valueOf(i);
          bt(d + 1, i);
          visited[i] = false;
        }
      }
    } else {
      for (int i = n - 1; i >= 0; i--) {
        if (!visited[i]) {
          visited[i] = true;
          r[d + 1] = String.valueOf(i);
          bt(d + 1, i);
          visited[i] = false;
        }
      }
    }
  }

}