import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    for (int t = 1; t <= 10; t++) {
      sb.append("#").append(t);
      br.readLine();

      Queue<Integer> q = new LinkedList<>();

      StringTokenizer st = new StringTokenizer(br.readLine());

      while (st.hasMoreTokens()) {
        q.add(Integer.parseInt(st.nextToken()));
      }

      int m = 0;

      while (true) {
        int tmp = q.remove();

        tmp -= m % 5 + 1;
        m++;

        if (tmp <= 0) {
          q.add(0);
          break;
        }

        q.add(tmp);
      }

      while (!q.isEmpty()) {
        sb.append(" ").append(q.remove());
      }
      sb.append("\n");

    }

    System.out.println(sb);
  }

}