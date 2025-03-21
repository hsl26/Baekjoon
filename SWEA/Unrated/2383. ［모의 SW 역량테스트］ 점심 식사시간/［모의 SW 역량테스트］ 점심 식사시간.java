import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Solution {

  static int PSIZE;

  static int N, answer;

  static int[][] board, dist, state;

  static List<int[]> people;
  static Map<Integer, int[]> stairs;

  static Deque<Integer> s0 = new ArrayDeque<>(), s1 = new ArrayDeque<>();

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();

    int T = Integer.parseInt(br.readLine());

    for (int t = 1; t <= T; t++) {
      sb.append("#").append(t).append(" ");

      N = Integer.parseInt(br.readLine());

      board = new int[N][N];
      people = new ArrayList<>();
      stairs = new HashMap<>();

      int idx = 0;
      for (int r = 0; r < N; r++) {
        st = new StringTokenizer(br.readLine());
        for (int c = 0; c < N; c++) {
          board[r][c] = Integer.parseInt(st.nextToken());
          if (board[r][c] == 1) {
            people.add(new int[] {r, c});
          } else if (board[r][c] > 1) {
            stairs.put(idx++, new int[] {r, c, board[r][c]});
          }
        }
      }

      PSIZE = people.size();

      dist = new int[PSIZE][2];
      idx = 0;
      for (int[] p : people) {
        dist[idx][0] = Math.abs(stairs.get(0)[0] - p[0]) + Math.abs(stairs.get(0)[1] - p[1]);
        dist[idx++][1] = Math.abs(stairs.get(1)[0] - p[0]) + Math.abs(stairs.get(1)[1] - p[1]);
      }

      answer = Integer.MAX_VALUE;
      state = new int[PSIZE][2];
      for (int i = 0; i < PSIZE; i++)
        state[i][1] = dist[i][0];

      bt(0);

      sb.append(answer).append("\n");
    }

    System.out.println(sb);

  }

  private static void bt(int d) {

    if (d > PSIZE)
      return;

    // 시간 계산
    s0.clear();
    s1.clear();

    int t = 0, s = 0;
    while (t < 100) {

      if (t > answer)
        break;

      if (s == PSIZE && s0.isEmpty() && s1.isEmpty()) {
        answer = Math.min(answer, t);
        break;
      }


      int ss = s0.size();
      for (int i = 0; i < ss; i++) {
        if (i < 3 && s0.peek() == 1)
          s0.remove();
        else if (i < 3)
          s0.add(s0.remove() - 1);
        else
          s0.add(s0.remove());
      }

      ss = s1.size();
      for (int i = 0; i < ss; i++) {
        if (i < 3 && s1.peek() == 1)
          s1.remove();
        else if (i < 3)
          s1.add(s1.remove() - 1);
        else
          s1.add(s1.remove());
      }

      for (int i = 0; i < PSIZE; i++) {

        if (state[i][1] - t == 0) {
          s++;
          if (state[i][0] == 0) {
            s0.add(stairs.get(0)[2]);
          } else {
            s1.add(stairs.get(1)[2]);
          }
        }
      }

      t++;

    }

    // 1번 계단으로 갈 사람 고르기
    for (int i = 0; i < PSIZE; i++) {
      if (state[i][0] == 0) {
        state[i][0] = 1;
        state[i][1] = dist[i][1];

        bt(d + 1);

        state[i][0] = 0;
        state[i][1] = dist[i][0];
      }
    }
  }
}