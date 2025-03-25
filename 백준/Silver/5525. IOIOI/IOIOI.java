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
    int i = 0, j = 0;

    while (i < n) {
      if (S.charAt(i) == P.charAt(j)) {
        i += 1;
        j += 1;
        if (j == m) {
          answer++;
          i = i - j + 1;
          j = 0;
        }
      } else if (j == 0)
        i += 1;
      else {
        j = pi[j];
      }
    }

  }

  private static void piTable(String p) {

    int m = p.length();
    pi = new int[m];
    int i = 1, j = 0;

    while (i < m - 1) {
      if (p.charAt(i) == p.charAt(j)) {
        i++;
        j++;
        pi[i] = j;
      } else if (j == 0) {
        i += 1;
        pi[i] = j;
      } else {
        j = pi[j];
      }
    }

  }

}