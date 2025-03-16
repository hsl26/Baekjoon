import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

  static int N;

  static String answer;

  static int[] arr, num;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    StringTokenizer st;

    int T = Integer.parseInt(br.readLine());

    for (int t = 1; t <= T; t++) {
      sb.append("#").append(t).append(" ");
      answer = "Yes";

      N = Integer.parseInt(br.readLine());

      arr = new int[N];
      num = new int[N + 1];

      st = new StringTokenizer(br.readLine());
      for (int i = 0; i < N; i++) {
        arr[i] = Integer.parseInt(st.nextToken());
        num[arr[i]]++;
      }

      for (int i = 1; i <= N; i++) {
        if (num[i] != 1 || arr[i - 1] == 0)
          answer = "No";
      }

      if (t != T)
        sb.append(answer).append("\n");
      else
        sb.append(answer);

    }

    System.out.println(sb);

  }

}
