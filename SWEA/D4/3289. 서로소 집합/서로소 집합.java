import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

  static int n, m;

  static int[] command = new int[3];
  static int[] nums;

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();

    int T = Integer.parseInt(br.readLine());

    for (int t = 1; t <= T; t++) {
      sb.append("#").append(t).append(" ");

      st = new StringTokenizer(br.readLine());

      n = Integer.parseInt(st.nextToken());
      m = Integer.parseInt(st.nextToken());


      nums = new int[n + 1];

      for (int i = 1; i <= n; i++) {
        nums[i] = i;
      }

      for (int i = 0; i < m; i++) {
        st = new StringTokenizer(br.readLine());

        for (int c = 0; c < 3; c++) {
          command[c] = Integer.parseInt(st.nextToken());
        }

        int p1 = findParent(command[1]);
        int p2 = findParent(command[2]);

        if (command[0] == 0) {
          nums[p2] = p1;
        }

        else {
          if (p1 != p2)
            sb.append(0);
          else
            sb.append(1);
        }


      }

      sb.append("\n");
    }

    System.out.println(sb);
  }

  private static int findParent(int i) {

    if (nums[i] == i)
      return i;

    return nums[i] = findParent(nums[i]);
  }


}