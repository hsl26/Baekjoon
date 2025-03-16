import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

  static int N, answer;

  static int[] arr;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    StringTokenizer st;

    int T = Integer.parseInt(br.readLine());

    for (int t = 1; t <= T; t++) {
      sb.append("#").append(t).append(" ");

      N = Integer.parseInt(br.readLine());

      arr = new int[N];
      answer = 0;

      st = new StringTokenizer(br.readLine());
      for (int i = 0; i < N; i++) {
        arr[i] = Integer.parseInt(st.nextToken());
      }

      for (int i = 1; i < N - 1; i++) {
        if (arr[i - 1] <= arr[i] && arr[i + 1] <= arr[i])
          continue;
        if (arr[i - 1] >= arr[i] && arr[i + 1] >= arr[i])
          continue;

        answer++;
      }

      sb.append(answer).append("\n");

    }

    System.out.println(sb);

  }

}
