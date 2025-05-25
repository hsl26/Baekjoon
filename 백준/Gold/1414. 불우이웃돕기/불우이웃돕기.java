import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

  static int N;
  static int[] parent;
  static PriorityQueue<int[]> line = new PriorityQueue<>((l1, l2) -> {
    return l1[2] - l2[2];
  });

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // StringTokenizer st;

    N = Integer.parseInt(br.readLine());

    parent = new int[N + 1];

    for (int i = 1; i <= N; i++) {
      parent[i] = i;
    }

    long total = 0;
    for (int r = 1; r <= N; r++) {
      String str = br.readLine();
      for (int c = 1; c <= N; c++) {
        char ch = str.charAt(c - 1);
        if (ch >= 'a' && ch <= 'z') {
          line.add(new int[] {r, c, ch - 'a' + 1});
          total += ch - 'a' + 1;
        } else if (ch >= 'A' && ch <= 'Z') {
          line.add(new int[] {r, c, ch - 'A' + 27});
          total += ch - 'A' + 27;
        }
      }
    }



    int cnt = 0;
    long sum = 0;
    while (!line.isEmpty()) {

      if (cnt == N - 1)
        break;

      // 제일 가치 작은거 골라
      int[] cur = line.poll();

      int p1 = find(cur[0]);
      int p2 = find(cur[1]);

      // 사이클 안생기면 가치 더하기 & union 해줘
      if (p1 != p2) {
        union(p1, p2);
        cnt++;
        sum += cur[2];
      }

    }

    if (cnt != N - 1) {
      System.out.println(-1);
    } else

      System.out.println(total - sum);
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