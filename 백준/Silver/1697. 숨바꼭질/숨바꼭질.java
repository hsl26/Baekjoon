import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

  static Queue<Integer> q;
  static int[] visit;
  static int[] cost;

  static int N, K;

  public static void main(String[] args)  {

    Scanner sc = new Scanner(System.in);

    N = sc.nextInt();
    K = sc.nextInt();

    visit = new int[200000 + 1];
    cost = new int[200000 + 1];

    q = new LinkedList<>();

    q.add(N);
    visit[N] = 1; // 방문한게 1
    dfs();

    System.out.println(cost[K]);

  }

  private static void dfs() {

    while (!q.isEmpty()) {
      int a = q.remove();
      int n = a;

      for (int i = 0; i < 3; i++) {
        if (i == 0)
          n = a - 1;
        else if (i == 1)
          n = a + 1;
        else
          n = a * 2;

        if (can_go(n)) {
          q.add(n);
          visit[n] = 1;
          cost[n] = cost[a] + 1;
        }

      }
    }

  }

  private static boolean can_go(int n) {

    if (n < 0 || n > 200000)
      return false;
    if (visit[n] == 1)
      return false;

    return true;
  }
}
