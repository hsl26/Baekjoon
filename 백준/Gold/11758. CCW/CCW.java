import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  static int[] A, B, C;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    A = new int[2];
    B = new int[2];
    C = new int[2];

    st = new StringTokenizer(br.readLine());
    A[0] = Integer.parseInt(st.nextToken());
    A[1] = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine());
    B[0] = Integer.parseInt(st.nextToken());
    B[1] = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine());
    C[0] = Integer.parseInt(st.nextToken());
    C[1] = Integer.parseInt(st.nextToken());

    int a1, a2;
    int ans;

    int a = A[0] * B[1] + B[0] * C[1] + C[0] * A[1];
    int b = A[1] * B[0] + B[1] * C[0] + C[1] * A[0];

    if (a == b) {
      ans = 0;
    } else if (a < b) {
      ans = -1;
    } else {
      ans = 1;
    }

    System.out.println(ans);

  }

}