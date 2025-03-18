import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

  static int K;

  static String[] str;

  static List<String> list;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int T = Integer.parseInt(br.readLine());

    for (int t = 1; t <= T; t++) {
      sb.append("#").append(t).append(" ");

      K = Integer.parseInt(br.readLine());
      str = br.readLine().split("");

      list = new ArrayList<>();

      for (int i = 0; i < str.length; i++) {
        String tmp = "";
        for (int j = i; j < str.length; j++) {
          tmp += str[j];

          list.add(tmp);
        }
      }

      Collections.sort(list);

      for (int i = 0; i < list.size() - 1; i++) {
        if (list.get(i).equals(list.get(i + 1))) {
          list.remove(i);
          i--;
        }
      }

      if (list.size() < K) {
        sb.append("none\n");
        continue;
      }

      sb.append(list.get(K - 1)).append("\n");

    }
    System.out.println(sb);
  }

}