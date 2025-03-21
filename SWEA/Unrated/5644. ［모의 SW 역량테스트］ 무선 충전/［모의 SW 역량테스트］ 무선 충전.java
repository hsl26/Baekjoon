import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

  static int M, A, r, c, w, cost, answer;

  static int[] loadA, loadB;

  static int[] dr = {0, -1, 0, 1, 0};
  static int[] dc = {0, 0, 1, 0, -1};

  static boolean[][] visited;

  static ArrayList<Integer>[][] board;

  static Map<Integer, Integer> BC;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();

    int T = Integer.parseInt(br.readLine());

    for (int t = 1; t <= T; t++) {
      sb.append("#").append(t).append(" ");

      st = new StringTokenizer(br.readLine());
      M = Integer.parseInt(st.nextToken());
      A = Integer.parseInt(st.nextToken());

      loadA = new int[M + 1];
      loadB = new int[M + 1];

      st = new StringTokenizer(br.readLine());
      for (int i = 1; i <= M; i++)
        loadA[i] = Integer.parseInt(st.nextToken());

      st = new StringTokenizer(br.readLine());
      for (int i = 1; i <= M; i++)
        loadB[i] = Integer.parseInt(st.nextToken());

      BC = new HashMap<>();
      visited = new boolean[11][11];

      board = new ArrayList[11][11];

      for (int i = 1; i <= 10; i++) {
        for (int j = 1; j <= 10; j++) {
          board[i][j] = new ArrayList<>();
        }
      }

      for (int i = 0; i < A; i++) {
        st = new StringTokenizer(br.readLine());
        c = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        cost = Integer.parseInt(st.nextToken());

        board[r][c].add(i + 1);

        BC.put(i + 1, cost);
        bfs(i + 1, r, c);

      }

      answer = 0;

      int Ar = 1, Ac = 1;
      int Br = 10, Bc = 10;
      for (int i = 0; i <= M; i++) {
        Ar += dr[loadA[i]];
        Ac += dc[loadA[i]];
        Br += dr[loadB[i]];
        Bc += dc[loadB[i]];

        ArrayList<Integer> A = board[Ar][Ac];
        ArrayList<Integer> B = board[Br][Bc];

        int sum = 0;

        for (int a = 0; a < A.size(); a++) {
          for (int b = 0; b < B.size(); b++) {

            if (A.get(a) == B.get(b))
              sum = Math.max(BC.get(A.get(a)), sum);
            else
              sum = Math.max(BC.get(A.get(a)) + BC.get(B.get(b)), sum);
          }
        }

        for (int a = 0; a < A.size(); a++) {
          sum = Math.max(BC.get(A.get(a)), sum);
        }

        for (int b = 0; b < B.size(); b++) {
          sum = Math.max(BC.get(B.get(b)), sum);
        }

        answer += sum;

      }

      sb.append(answer).append("\n");
    }
    System.out.println(sb);

  }


  private static void bfs(int idx, int r, int c) {

    int nr, nc, cnt;

    for (int i = 1; i <= 10; i++) {
      for (int j = 1; j <= 10; j++) {
        visited[i][j] = false;
      }
    }

    Queue<int[]> q = new LinkedList<>();

    visited[r][c] = true;
    q.add(new int[] {r, c, 0});

    while (!q.isEmpty()) {
      r = q.peek()[0];
      c = q.peek()[1];
      cnt = q.peek()[2];

      q.remove();

      for (int d = 1; d <= 4; d++) {
        nr = r + dr[d];
        nc = c + dc[d];

        if (nr <= 0 || nr > 10 || nc <= 0 || nc > 10)
          continue;

        if (visited[nr][nc])
          continue;

        if (cnt >= w)
          continue;

        visited[nr][nc] = true;
        board[nr][nc].add(idx);
        q.add(new int[] {nr, nc, cnt + 1});
      }

    }
  }
}