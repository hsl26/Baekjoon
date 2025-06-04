import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

  static int N, M, K, A, B, C;
  static int[] parent;
  static boolean[] power;

  static PriorityQueue<int[]> line = new PriorityQueue<>((l1, l2) -> Integer.compare(l1[2], l2[2]));

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());

    parent = new int[N + 1];
    power = new boolean[N + 1];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < K; i++) {
      power[Integer.parseInt(st.nextToken())] = true;
    }

    for (int i = 1; i <= N; i++) {
      parent[i] = i;
    }

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());

      A = Integer.parseInt(st.nextToken());
      B = Integer.parseInt(st.nextToken());
      C = Integer.parseInt(st.nextToken());

      line.add(new int[] {A, B, C});

    }

    long sum = mst();

    System.out.println(sum);

  }

  private static long mst() {

    long sum = 0;
    int p1, p2;
    int[] arr;

    while (!line.isEmpty()) {

      arr = line.poll();

      p1 = find((int) arr[0]);
      p2 = find((int) arr[1]);

      if (p1 == p2)
        continue;

      if (power[p1] && power[p2])
        continue;


      union(p1, p2);
      sum += arr[2];

    }

    return sum;
  }

  private static void union(int a, int b) {
    if (power[a])
      parent[b] = a;
    else if (power[b])
      parent[a] = b;
    else if (a < b)
      parent[b] = a;
    else
      parent[a] = b;

  }

  private static int find(int n) {

    if (n == parent[n])
      return n;

    return parent[n] = find(parent[n]);

  }


}