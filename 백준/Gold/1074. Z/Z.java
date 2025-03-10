import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  static int N, R, C;

  static long cnt = 0;

  static boolean find = false;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    R = Integer.parseInt(st.nextToken());
    C = Integer.parseInt(st.nextToken());

    findrc(N, 0, 0);

    System.out.println(cnt);
  }

  private static void findrc(int n, int nr, int nc) {

    if (find)
      return;

    int len = (int) Math.pow(2, n);


    if ((nr <= R && R < nr + len) && (nc <= C && C < nc + len)) {

      if (nr == R && nc == C)
        find = true;

      findrc(n - 1, nr, nc);
      findrc(n - 1, nr, nc + len / 2);
      findrc(n - 1, nr + (int) Math.pow(2, n - 1), nc);
      findrc(n - 1, nr + (int) Math.pow(2, n - 1), nc + (int) Math.pow(2, n - 1));

    } else {
      cnt += len * len;
    }

  }
}