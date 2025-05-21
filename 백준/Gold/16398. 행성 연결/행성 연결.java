import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

  static int N, C;
  static int[] parent;

  static PriorityQueue<int[]> line = new PriorityQueue<>((l1, l2) -> {
    return l1[2] - l2[2];
  });

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;


    N = Integer.parseInt(br.readLine());

    parent = new int[N + 1];

    for (int i = 1; i <= N; i++) {
      parent[i] = i;
    }

    for (int r = 0; r < N; r++) {
      st = new StringTokenizer(br.readLine());
      for (int c = 0; c < N; c++) {
        C = Integer.parseInt(st.nextToken());

        line.add(new int[] {r, c, C});
      }
    }

    long sum = mst();
    System.out.println(sum);

  }


  private static long mst() {
    long sum = 0, cnt = 0;

    int n = line.size();

    for (int i = 0; i < n; i++) {
      if (cnt == N - 1)
        break;

      int[] arr = line.poll();

      int p1 = find(arr[0]);
      int p2 = find(arr[1]);

      if (p1 == p2) {
        continue;
      } else {
        union(p1, p2);
        cnt++;
        sum += arr[2];
      }

    }

    return sum;
  }

  private static void union(int a, int b) {

    if (a < b)
      parent[b] = a;
    else
      parent[a] = b;

  }

  private static int find(int n) {

    if (parent[n] == n)
      return n;

    return parent[n] = find(parent[n]);
  }


}
