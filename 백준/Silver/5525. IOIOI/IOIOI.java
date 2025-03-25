import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

  static int N, M, answer = 0;
  static String s, p;
  static int[] pi;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());
    M = Integer.parseInt(br.readLine());

    s = br.readLine();

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < N; i++) {
      sb.append("IO");
    }
    sb.append("I");

    p = sb.toString();

    piTable(p);

    kmp(s, p);

    System.out.println(answer);

  }

  private static void kmp(String S, String P) {

    int n = S.length();
    int m = P.length();
    int j = 0;

    for (int i = 0; i < n; i++) {
      while (j > 0 && s.charAt(i) != p.charAt(j)) {
        j = pi[j - 1];
      }
      if (s.charAt(i) == p.charAt(j)) {
        if (j == m - 1) {
          answer++;
          j = pi[j];
        } else {
          j++;
        }
      }
    }

  }

  private static void piTable(String p) {

    int m = p.length();
    pi = new int[m];
    int j = 0;

    for (int i = 1; i < m; i++) {
      while (j > 0 && p.charAt(i) != p.charAt(j)) {
        j = pi[j - 1];
      }
      if (p.charAt(i) == p.charAt(j)) {
        pi[i] = ++j;
      }
    }

  }

}