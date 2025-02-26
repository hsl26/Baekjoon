import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

  static int answer = Integer.MAX_VALUE;

  static int[] price = new int[4];
  static int[] month = new int[12];

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());

    StringBuilder sb = new StringBuilder();
    StringTokenizer st;

    for (int t = 1; t <= T; t++) {
      sb.append("#").append(t).append(" ");
      answer = Integer.MAX_VALUE;

      st = new StringTokenizer(br.readLine());
      // 1일 이용권의 요금, 1달 이용권의 요금, 3달 이용권의 요금, 1년 이용권
      for (int i = 0; i < 4; i++) {
        price[i] = Integer.parseInt(st.nextToken());
      }

      st = new StringTokenizer(br.readLine());
      for (int i = 0; i < 12; i++) {
        month[i] = Integer.parseInt(st.nextToken());
      }

      bt(0, 0);

      sb.append(answer).append("\n");
    }

    System.out.println(sb);
  }

  private static void bt(int m, int sum) {

    if (m >= 12) {
      answer = Math.min(answer, sum);
      return;
    }

    for (int d = 0; d < 4; d++) {

      int nm = m;
      int ns = sum;

      switch (d) {
        case 0:
          nm += 1;
          ns += price[0] * month[m];
          break;
        case 1:
          nm += 1;
          ns += price[1];
          break;
        case 2:
          if (m + 3 > 12)
            continue;
          nm += 3;
          ns += price[2];
          break;
        case 3:
          if (m + 12 > 12)
            continue;
          nm += 12;
          ns += price[3];
          break;
        default:
          break;
      }


      bt(nm, ns);


    }

  }
}