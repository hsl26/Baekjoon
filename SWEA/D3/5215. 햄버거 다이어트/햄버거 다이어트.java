import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

  static int N, L, answer;

  static int[] score, cal;

  static boolean[] isSel;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();


    int T = Integer.parseInt(br.readLine());

    for (int t = 1; t <= T; t++) {
      sb.append("#").append(t).append(" ");

      st = new StringTokenizer(br.readLine());
      N = Integer.parseInt(st.nextToken());
      L = Integer.parseInt(st.nextToken());

      score = new int[N];
      cal = new int[N];
      isSel = new boolean[N];

      for (int i = 0; i < N; i++) {
        st = new StringTokenizer(br.readLine());
        score[i] = Integer.parseInt(st.nextToken());
        cal[i] = Integer.parseInt(st.nextToken());
      }

      answer = 0;
      comb(0, 0, 0, 0);

      sb.append(answer).append("\n");

    }
    System.out.println(sb);
  }

  private static void comb(int d, int s, int c, int k) {

    if (d > N)
      return;

    answer = Math.max(answer, s);

    for (int i = k; i < N; i++) {
      if (isSel[i] || c + cal[i] > L)
        continue;

      isSel[i] = true;
      comb(d + 1, s + score[i], c + cal[i], i + 1);
      isSel[i] = false;
    }

  }
}