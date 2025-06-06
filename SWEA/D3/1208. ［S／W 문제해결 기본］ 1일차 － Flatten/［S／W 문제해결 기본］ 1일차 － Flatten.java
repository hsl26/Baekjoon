import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

  static int T, N, ans;

  static int[] box;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();

    T = 10;

    for (int t = 1; t <= 10; t++) {
      sb.append("#").append(t).append(" ");

      N = Integer.parseInt(br.readLine());

      box = new int[100];

      st = new StringTokenizer(br.readLine());
      for (int i = 0; i < 100; i++) {
        box[i] = Integer.parseInt(st.nextToken());
      }

      for (int i = 0; i < N; i++) {
        Arrays.sort(box);

        box[0]++;
        box[99]--;
      }

      Arrays.sort(box);
      ans = box[99] - box[0];

      sb.append(ans).append("\n");
    }

    System.out.println(sb);

  }


}