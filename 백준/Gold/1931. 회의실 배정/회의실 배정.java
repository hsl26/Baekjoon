import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

  static int N, s, e;
  static List<int[]> time = new LinkedList<>();

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    N = Integer.parseInt(br.readLine());

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      s = Integer.parseInt(st.nextToken());
      e = Integer.parseInt(st.nextToken());

      time.add(new int[] {s, e});

    }

    Collections.sort(time, (t1, t2) -> {
      if (t1[1] == t2[1])
        return t1[0] - t2[0];
      return t1[1] - t2[1];
    });

    e = 0;
    int ans = 0;

    for (int[] arr : time) {
      if (e <= arr[0]) {
        e = arr[1];
        ans++;
      }
    }

    System.out.println(ans);

  }

}