import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

  static ArrayList<String> hexPasswords;
  static String passwords[];
  static int sum[][];
  static ArrayList<String> sumResult;

  static char hex[] =
      {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

  static String hexToBin[] = {"0000", "0001", "0010", "0011", "0100", "0101", "0110", "0111",
      "1000", "1001", "1010", "1011", "1100", "1101", "1110", "1111"};

  static String codes[] =
      {"3211", "2221", "2122", "1411", "1132", "1231", "1114", "1312", "1213", "3112"};
  static int result;


  public static void Verification(int[] sum) {
    int n1 = 0, n2 = 0;

    for (int i = 1; i < sum.length; i++) {
      if (i % 2 == 1)
        n1 += sum[i];
      else if (i % 2 == 0)
        n2 += sum[i];
    }

    if (((n1 * 3) + n2) % 10 == 0)
      if (!sumResult.contains(Arrays.toString(sum).replaceAll("[^0-9]", "")))
        sumResult.add(Arrays.toString(sum).replaceAll("[^0-9]", ""));
  }

  public static int Encode() {
    int cur = 0;

    for (int k = 0; k < passwords.length; k++) {
      for (int i = passwords[k].length() - 1; i > 0; i--) {
        if (passwords[k].charAt(i) != '0') {
          passwords[k] = passwords[k].substring(0, i + 1);
          break;
        }
      }
    }

    for (int k = 0; k < passwords.length; k++) {
      int r1 = 0, r2 = 0, r3 = 0, r4 = 0;
      int idx = 8;

      for (int i = passwords[k].length() - 1; i > 0; i--) {
        char temp = passwords[k].charAt(i);

        if (temp == '1' && r3 == 0)
          r4++;
        else if (temp == '0' && r2 == 0) {
          if (r4 != 0)
            r3++;
          else
            passwords[k] = passwords[k].substring(0, i);
        } else if (temp == '1' && r1 == 0)
          r2++;
        else {
          int mul = Math.min(Math.min(r2, r3), r4);

          r1 = (mul * 7) - (r2 + r3 + r4);
          int rateSum = r1 + r2 + r3 + r4;

          r1 /= mul;
          r2 /= mul;
          r3 /= mul;
          r4 /= mul;

          String code = "";
          code += r1;
          code += r2;
          code += r3;
          code += r4;

          sum[cur][idx--] = Arrays.asList(codes).indexOf(code);

          if (idx == 0) {
            cur++;
            idx = 8;
          }

          r1 = 0;
          r2 = 0;
          r3 = 0;
          r4 = 0;

          if (passwords[k].length() - rateSum > 0)
            passwords[k] = passwords[k].substring(0, passwords[k].length() - rateSum);
          else
            break;

          i = passwords[k].length();
        }
      }
    }

    for (int i = 0; i < sum.length; i++)
      Verification(sum[i]);

    for (String sumStr : sumResult)
      for (int i = 0; i < 9; i++)
        result += sumStr.charAt(i) - '0';

    return result;
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int T = Integer.parseInt(br.readLine());
    for (int test_case = 1; test_case <= T; test_case++) {
      st = new StringTokenizer(br.readLine());
      int N = Integer.parseInt(st.nextToken());
      int M = Integer.parseInt(st.nextToken());

      hexPasswords = new ArrayList<>();
      sumResult = new ArrayList<>();
      result = 0;

      for (int i = 0; i < N; i++) {
        String str = br.readLine();

        if (hexPasswords.contains(str))
          continue;

        for (int k = 0; k < M; k++) {
          if (str.charAt(k) != '0') {
            hexPasswords.add(str);
            break;
          }
        }
      }

      sum = new int[10000][9];
      passwords = new String[hexPasswords.size()];

      for (int i = 0; i < passwords.length; i++)
        passwords[i] = "";

      for (int k = 0; k < hexPasswords.size(); k++) {
        for (int i = 0; i < hexPasswords.get(k).length(); i++) {
          for (int j = 0; j < hex.length; j++) {
            if (hexPasswords.get(k).charAt(i) == hex[j]) {
              passwords[k] += hexToBin[j];
            }
          }
        }
      }

      System.out.println("#" + test_case + " " + Encode());
    }
  }
}