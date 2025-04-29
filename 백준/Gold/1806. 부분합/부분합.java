import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  static int N, S;
  static int[] arr;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    S = Integer.parseInt(st.nextToken());
    arr = new int[N];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    int s = 0, e = 0, sum = arr[0], ans = Integer.MAX_VALUE;
    while (s <= e && s < N) {
      if (sum >= S) {
        ans = Math.min(ans, e - s + 1);
        sum -= arr[s];
        s++;
      } else if (e + 1 < N) {
        e++;
        sum += arr[e];
      } else
        break;
    }

    if (ans == Integer.MAX_VALUE)
      ans = 0;

    System.out.println(ans);

  }

}