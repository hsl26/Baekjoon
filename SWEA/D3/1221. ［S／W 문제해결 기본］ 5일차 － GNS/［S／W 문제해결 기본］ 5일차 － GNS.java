import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Solution {

  static int len;

  static int[] board;

  static String[] nums = {"ZRO", "ONE", "TWO", "THR", "FOR", "FIV", "SIX", "SVN", "EGT", "NIN"};

  static Map<String, Integer> map = new HashMap<>();;

  public static void main(String[] args) throws Exception {

    for (int i = 0; i < 10; i++) {
      map.put(nums[i], i);
    }

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();

    int T = Integer.parseInt(br.readLine());

    for (int t = 1; t <= T; t++) {
      sb.append("#").append(t).append("\n");

      st = new StringTokenizer(br.readLine());

      st.nextToken();
      len = Integer.parseInt(st.nextToken());

      board = new int[len];

      st = new StringTokenizer(br.readLine());

      for (int i = 0; i < len; i++) {
        board[i] = map.get(st.nextToken());
      }

      Arrays.sort(board);

      for (int i = 0; i < len; i++) {
        sb.append(nums[board[i]]).append(" ");
      }

      sb.append("\n");

    }

    System.out.println(sb);
  }
}