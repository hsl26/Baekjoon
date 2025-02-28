import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {

  static int N, answer;

  static ArrayList<Integer> A;

  static int[][] S;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    StringTokenizer st;

    int T = Integer.parseInt(br.readLine());

    for (int t = 1; t <= T; t++) {
      sb.append("#").append(t).append(" ");
      answer = Integer.MAX_VALUE;

      N = Integer.parseInt(br.readLine());

      S = new int[N][N];
      for (int r = 0; r < N; r++) {
        st = new StringTokenizer(br.readLine());
        for (int c = 0; c < N; c++) {
          S[r][c] = Integer.parseInt(st.nextToken());
        }
      }

      A = new ArrayList<>();

      comb(0);

      sb.append(answer).append("\n");

    }

    System.out.println(sb);

  }

  private static void comb(int d) {

    if (A.size() == N / 2) {
      calFood();
      return;
    }

    for (int i = d; i < N; i++) {
      A.add(i);
      comb(i + 1);
      A.remove(A.size() - 1);
    }
  }

  private static void calFood() {

    ArrayList<Integer> B = new ArrayList<>();

    int sumA = 0;
    int sumB = 0;

    for (int i = 0; i < N; i++) {
      if (!A.contains(i)) {
        B.add(i);
      }
    }

    for (int i = 0; i < A.size(); i++) {
      for (int j = 0; j < A.size(); j++) {
        sumA += S[A.get(i)][A.get(j)];
      }
    }

    for (int i = 0; i < B.size(); i++) {
      for (int j = 0; j < B.size(); j++) {
        sumB += S[B.get(i)][B.get(j)];
      }
    }

    answer = Math.min(Math.abs(sumA - sumB), answer);

  }
}