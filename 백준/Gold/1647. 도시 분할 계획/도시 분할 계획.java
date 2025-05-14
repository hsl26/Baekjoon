import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

  static int N, M, A, B, C;
  static int[] parent;
  static PriorityQueue<int[]> line = new PriorityQueue<>((l1, l2) -> {
    return l1[2] - l2[2];
  });

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    parent = new int[N + 1];

    clearParent();

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      A = Integer.parseInt(st.nextToken());
      B = Integer.parseInt(st.nextToken());
      C = Integer.parseInt(st.nextToken());

      line.add(new int[] {A, B, C});

    }

    int sum = Integer.MAX_VALUE;

    clearParent();

    sum = mst();


    System.out.println(sum);
  }

  private static void clearParent() {
    for (int i = 1; i <= N; i++) {
      parent[i] = i;
    }
  }

  private static int mst() {
    int sum = 0, cnt = 0;

    for (int i = 0; i < M; i++) {
      if (cnt == N - 2)
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
