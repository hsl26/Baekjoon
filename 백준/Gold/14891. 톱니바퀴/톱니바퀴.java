import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

  static Deque<Integer>[][] saw = new Deque[4][2];

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    for (int i = 0; i < 4; i++) {
      String[] arr = br.readLine().split("");
      saw[i][0] = new ArrayDeque<>(); 
      saw[i][1] = new ArrayDeque<>(); 

      for (int u = 0; u < 8; u++) {
        saw[i][0].addLast(Integer.parseInt(arr[u]));
      }

      saw[i][0].addFirst(saw[i][0].removeLast());
      saw[i][0].addFirst(saw[i][0].removeLast());

      for (int d = 0; d < 4; d++) {
        saw[i][1].addLast(saw[i][0].removeLast());
      }
    }

    int K = Integer.parseInt(br.readLine());

    for (int i = 0; i < K; i++) {
      st = new StringTokenizer(br.readLine());
      int num = Integer.parseInt(st.nextToken()) - 1;
      int dir = Integer.parseInt(st.nextToken());

      move(num, dir);
    }

    int score = 0;
    for (int i = 0; i < 4; i++) {
      saw[i][0].removeLast(); 
      score += saw[i][0].peekLast() * Math.pow(2, i);
    }

    System.out.println(score);
  }

  private static void move(int n, int r) {
    int[] dirs = new int[4]; 
    dirs[n] = r;

    // 왼쪽으로 
    for (int i = n - 1; i >= 0; i--) {
      if (saw[i][1].peekLast() != saw[i + 1][0].peekFirst()) {
        dirs[i] = -dirs[i + 1];
      } else {
        break;
      }
    }

    // 오른쪽으로 
    for (int i = n + 1; i < 4; i++) {
      if (saw[i - 1][1].peekLast() != saw[i][0].peekFirst()) {
        dirs[i] = -dirs[i - 1];
      } else {
        break;
      }
    }

    for (int i = 0; i < 4; i++) {
      if (dirs[i] == 1)
        right(i);
      else if (dirs[i] == -1)
        wrong(i);
    }
  }

  private static void wrong(int n) {
    // 반시계 방향 회전
    saw[n][1].addFirst(saw[n][0].pollFirst());
    saw[n][0].addLast(saw[n][1].pollLast());
  }

  private static void right(int n) {
    // 시계 방향 회전
    saw[n][1].addLast(saw[n][0].pollLast());
    saw[n][0].addFirst(saw[n][1].pollFirst());
  }

}