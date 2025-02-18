import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());

    int[] arr = new int[n];

    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(br.readLine());
    }

    int[] dp = new int[n];

    dp[0] = arr[0];
    if (n > 1)
      dp[1] = arr[0] + arr[1];

    if (n > 2) {
      dp[2] = Math.max(dp[1], Math.max(arr[0] + arr[2], arr[1] + arr[2]));
    }

    for (int i = 3; i < n; i++) {
      dp[i] = Math.max(Math.max(dp[i - 2] + arr[i], dp[i - 1]), dp[i - 3] + arr[i - 1] + arr[i]);
    }


    int answer = -1;

    for (int i = 0; i < dp.length; i++) {
      answer = Math.max(answer, dp[i]);
    }

    System.out.println(answer);
  }
}