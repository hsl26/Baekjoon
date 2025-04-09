import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

  static int N;
  static List<Integer> arr = new ArrayList<>();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    N = Integer.parseInt(br.readLine());

    st = new StringTokenizer(br.readLine());

    for (int i = 0; i < N; i++) {
      arr.add(Integer.parseInt(st.nextToken()));
    }

    Collections.sort(arr);

    int s = 0, e = N - 1;

    int a = s, b = e, dif = Integer.MAX_VALUE, cur;

    while (s < e) {

      cur = arr.get(e) + arr.get(s);

      if (dif > Math.abs(cur)) {
        dif = Math.abs(cur);
        a = s;
        b = e;
      }

      if (cur == 0)
        break;

      if (cur < 0) {
        s += 1;
      } else {
        e -= 1;
      }

    }

    System.out.println(arr.get(a) + " " + arr.get(b));

  }

}