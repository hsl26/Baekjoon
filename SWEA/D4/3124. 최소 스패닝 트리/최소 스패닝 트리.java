import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution {

  static int V, E;

  static int[] nums;

  static ArrayList<int[]> arr;

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st;

    int T = Integer.parseInt(br.readLine());

    for (int t = 1; t <= T; t++) {
      sb.append("#").append(t).append(" ");

      arr = new ArrayList<>();

      st = new StringTokenizer(br.readLine());

      V = Integer.parseInt(st.nextToken());
      E = Integer.parseInt(st.nextToken());

      nums = new int[V + 1];
      for (int i = 1; i <= V; i++) {
        nums[i] = i;
      }

      for (int i = 0; i < E; i++) {
        st = new StringTokenizer(br.readLine());

        int[] tmp = new int[3];

        for (int c = 0; c < 3; c++) {
          tmp[c] = Integer.parseInt(st.nextToken());
        }

        arr.add(tmp);
      }

      Collections.sort(arr, (a1, a2) -> {
        return a1[2] - a2[2];
      });


      int cnt = 0;
      long sum = 0;
      for (int i = 0; i < E; i++) {
        if (cnt == V - 1)
          break;

        int p1 = findSet(arr.get(i)[0]);
        int p2 = findSet(arr.get(i)[1]);

        if (p1 != p2) {
          sum += arr.get(i)[2];
          nums[p2] = p1;
        }
      }

      sb.append(sum).append("\n");

    }

    System.out.println(sb);

  }

  private static int findSet(int i) {
    if (nums[i] == i)
      return i;

    return nums[i] = findSet(nums[i]);
  }
}