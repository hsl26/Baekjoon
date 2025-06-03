import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

  static int N, M, p1, p2, cnt;
  static int[] parent;
  static long[][] coor;

  static PriorityQueue<double[]> line =
      new PriorityQueue<>((l1, l2) -> Double.compare(l1[2], l2[2]));

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    coor = new long[N + 1][2];
    parent = new int[N + 1];
    cnt = 0;

    for (int i = 1; i <= N; i++) {
      parent[i] = i;
    }

    for (int i = 1; i <= N; i++) {
      st = new StringTokenizer(br.readLine());

      coor[i][0] = Integer.parseInt(st.nextToken());
      coor[i][1] = Integer.parseInt(st.nextToken());
    }

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());

      p1 = find(Integer.parseInt(st.nextToken()));
      p2 = find(Integer.parseInt(st.nextToken()));

      if (p1 != p2) {
        union(p1, p2);
        cnt++;
      }
    }

    double dis = 0;
    for (int r = 1; r <= N; r++) {
      for (int c = r + 1; c <= N; c++) {
        dis = Math
            .sqrt(Math.pow((coor[r][0] - coor[c][0]), 2) + Math.pow((coor[r][1] - coor[c][1]), 2));

        line.add(new double[] {r, c, dis});
      }
    }

    double sum = mst();

    System.out.printf("%.2f", sum);

  }

  private static double mst() {

    double sum = 0;
    int e = line.size();
    double[] arr;

    for (int i = 0; i < e; i++) {
      if (cnt == N - 1)
        break;

      arr = line.poll();

      p1 = find((int) arr[0]);
      p2 = find((int) arr[1]);

      if (p1 != p2) {
        union(p1, p2);
        cnt++;
        sum += arr[2];
      }
    }

    return sum;
  }

  private static void union(int a, int b) {

    if (a < b) {
      parent[b] = a;
    } else {
      parent[a] = b;
    }

  }

  private static int find(int n) {

    if (n == parent[n])
      return n;

    return parent[n] = find(parent[n]);

  }


}