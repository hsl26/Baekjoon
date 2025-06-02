import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

  static int N;
  static int[] parent;
  static double[][] coor;

  static PriorityQueue<double[]> line = new PriorityQueue<>((l1, l2) -> {
    return (int) (l1[2] - l2[2]);
  });

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    parent = new int[N + 1];
    coor = new double[N + 1][2];

    for (int i = 1; i <= N; i++) {
      parent[i] = i;
    }

    for (int i = 1; i <= N; i++) {
      st = new StringTokenizer(br.readLine());
      coor[i][0] = Double.parseDouble(st.nextToken());
      coor[i][1] = Double.parseDouble(st.nextToken());
    }

    for (int r = 1; r <= N; r++) {
      for (int c = 1; c <= N; c++) {
        if (r >= c)
          continue;

        double dis = Math.sqrt(Math.abs(coor[r][0] - coor[c][0]) * Math.abs(coor[r][0] - coor[c][0])
            + Math.abs(coor[r][1] - coor[c][1]) * Math.abs(coor[r][1] - coor[c][1]));

        line.add(new double[] {r, c, dis});

      }
    }

    double sum = mst();

    System.out.printf("%.2f", sum);
  }


  private static double mst() {
    double sum = 0;
    int cnt = 0;

    int n = line.size();

    for (int i = 0; i < n; i++) {
      if (cnt == N - 1)
        break;

      double[] arr = line.poll();

      int p1 = find((int) arr[0]);
      int p2 = find((int) arr[1]);

      if (p1 == p2) {
        continue;
      } else {
        union(p1, p2);
        cnt++;
        sum += arr[2];
      }

    }

    if (cnt != N - 1)
      sum = -1;

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