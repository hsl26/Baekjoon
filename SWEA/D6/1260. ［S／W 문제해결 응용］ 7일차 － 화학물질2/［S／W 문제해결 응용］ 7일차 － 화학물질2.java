import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

  static int N, answer;

  static int[] dr = {0, 0, 1, -1};
  static int[] dc = {1, -1, 0, 0};

  static int[][] board, visited;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();

    int T = Integer.parseInt(br.readLine());

    for (int t = 1; t <= T; t++) {
      sb.append("#").append(t).append(" ");

      N = Integer.parseInt(br.readLine());
      board = new int[N][N];
      visited = new int[N][N];

      for (int r = 0; r < N; r++) {
        st = new StringTokenizer(br.readLine());
        for (int c = 0; c < N; c++) {
          board[r][c] = Integer.parseInt(st.nextToken());
        }
      }


      // 행렬 찾기
      Map<Integer, Integer> map = new HashMap<>();
      List<Integer> list = new ArrayList<>();
      int cnt = 0;

      for (int r = 0; r < N; r++) {
        for (int c = 0; c < N; c++) {
          if (board[r][c] != 0 && visited[r][c] == 0) {
            int[] arr = cal(r, c);

            bfs(r, c);

            cnt++;

            map.put(arr[0], arr[1]);
            list.add(arr[0]);
          }
        }
      }

      // 곱셈 순서 정하기
      int start = 0;
      for (int a : list) {
        if (!map.containsValue(a)) {
          start = a;
        }
      }

      int[][] matrix = new int[cnt][2];

      for (int i = 0; i < cnt; i++) {
        matrix[i][0] = start;
        matrix[i][1] = map.get(start);

        start = map.get(start);
      }


      // 연쇄 행렬 최소 곱셈 알고리즘
      int[][] DP = new int[cnt][cnt];
      int a, b, k;

      for (int i = 0; i < cnt; i++) {
        for (int j = 0; j < cnt - i; j++) {
          a = j;
          b = j + i;

          if (a == b)
            DP[a][b] = 0;

          else {
            DP[a][b] = Integer.MAX_VALUE;
            for (k = a; k < b; k++) {
              DP[a][b] = Math.min(DP[a][b],
                  DP[a][k] + DP[k + 1][b] + (matrix[a][0] * matrix[k][1] * matrix[b][1]));
            }
          }

        }
      }

      sb.append(DP[0][cnt - 1]).append("\n");
    }

    System.out.println(sb);
  }

  private static void bfs(int r, int c) {
    int nr, nc;

    Queue<int[]> q = new LinkedList<>();
    visited[r][c] = 1;
    q.add(new int[] {r, c});

    while (!q.isEmpty()) {
      int[] arr = q.remove();

      r = arr[0];
      c = arr[1];

      for (int d = 0; d < 4; d++) {
        nr = r + dr[d];
        nc = c + dc[d];
        if (canGo(nr, nc)) {
          visited[nr][nc] = 1;
          q.add(new int[] {nr, nc});
        }
      }
    }
  }

  private static boolean canGo(int r, int c) {
    if (r < 0 || r >= N || c < 0 || c >= N)
      return false;
    if (visited[r][c] == 1 || board[r][c] == 0)
      return false;
    return true;
  }

  private static int[] cal(int sr, int sc) {
    int[] arr = {0, 0};

    for (int r = sr; r < N; r++) {
      if (board[r][sc] > 0)
        arr[0]++;
      else
        break;
    }

    for (int c = sc; c < N; c++) {
      if (board[sr][c] > 0)
        arr[1]++;
      else
        break;
    }

    return arr;
  }
}