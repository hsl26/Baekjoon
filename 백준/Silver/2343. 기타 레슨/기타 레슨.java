import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  static int N, M, sum = 0, max = 0;

  static int[] guitar;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    guitar = new int[N];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      guitar[i] = Integer.parseInt(st.nextToken());
      sum += guitar[i];
      max = Math.max(max, guitar[i]);
    }

    // 이분탐색
    int left = max, right = sum, mid, cnt, s;
    while (left < right) {
      mid = (left + right) / 2;

      s = 0;
      cnt = 0;
      for (int i = 0; i < N; i++) {
        if (s + guitar[i] > mid) {
          cnt++;
          s = 0;
        }
        s += guitar[i];
      }

      if (cnt >= M) {
        left = mid + 1;
      } else {
        right = mid;
      }

    }

    System.out.println(left);

  }

}