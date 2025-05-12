import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
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
    StringTokenizer st;

    N = Integer.parseInt(br.readLine());

    M = Integer.parseInt(br.readLine());

    parent = new int[N + 1];

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

    int sum = 0;
    List<int[]> mst = new ArrayList<>();
    for (int i = 0; i < M; i++) {
      if (mst.size() == N - 1)
        break;

      // 제일 가치 작은거 골라
      int[] cur = line.poll();

      int p1 = find(cur[0]);
      int p2 = find(cur[1]);

      // find해서 사이클 생기면 패스
      if (p1 == p2)
        continue;

      // 사이클 안생기면 가치 더하기 & union 해줘
      else {
        union(p1, p2);
        sum += cur[2];
        mst.add(cur);
      }
    }

    System.out.println(sum);
  }

  private static int find(int i) {

    if (i == parent[i])
      return i;

    return parent[i] = find(parent[i]);
  }

  private static void union(int a, int b) {

    if (a < b) {
      parent[b] = a;
    } else {
      parent[a] = b;
    }

  }
}
