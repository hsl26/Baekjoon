import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

  static int N, K;

  static int[] load, visited;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] arr = br.readLine().split(" ");
    N = Integer.parseInt(arr[0]);
    K = Integer.parseInt(arr[1]);

    load = new int[2 * Math.max(N, K) + 1];
    Arrays.fill(load, -1);
    visited = new int[2 * Math.max(N, K) + 1];

    bfs();

    System.out.println(load[K]);

  }

  private static void bfs() {

    Queue<Integer> q = new LinkedList<>();

    q.add(N);
    load[N] = 0;

    while (!q.isEmpty()) {
      int n = q.remove();


      for (int d = 0; d < 3; d++) {
        int nn;
        if (d == 0) {
          nn = n - 1;
          if (nn < 0 || nn >= load.length || load[nn] >= 0)
            continue;
        } else if (d == 1) {
          nn = n + 1;
          if (nn < 0 || nn >= load.length || load[nn] >= 0)
            continue;
        } else {
          nn = n * 2;
          if (nn < 0 || nn >= load.length || load[nn] >= 0)
            continue;
        }

        load[nn] = load[n] + 1;
        q.add(nn);
      }
    }

  }
}