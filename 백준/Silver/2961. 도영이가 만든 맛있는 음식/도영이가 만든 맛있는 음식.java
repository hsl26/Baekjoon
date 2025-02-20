import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

  static int N;

  static int[] sour;
  static int[] bitter;

  static ArrayList<Integer> S = new ArrayList<>();
  static ArrayList<Integer> B = new ArrayList<>();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());

    sour = new int[N];
    bitter = new int[N];

    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      sour[i] = Integer.parseInt(st.nextToken());
      bitter[i] = Integer.parseInt(st.nextToken());
    }

    cal(1, 0, 0);

    int answer = Integer.MAX_VALUE;
    for (int i = 0; i < S.size(); i++) {
      answer = Math.min(answer, Math.abs(S.get(i) - B.get(i)));
    }

    System.out.println(answer);
  }

  private static void cal(int sumS, int sumB, int idx) {

    if (idx >= N) {
      return;
    }

    S.add(sumS * sour[idx]);
    B.add(sumB + bitter[idx]);
    cal(sumS * sour[idx], sumB + bitter[idx], idx + 1);
    cal(sumS, sumB, idx + 1);

  }

}