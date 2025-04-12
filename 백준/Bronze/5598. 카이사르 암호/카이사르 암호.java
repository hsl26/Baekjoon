import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

  static int N;
  static List<Integer> arr = new ArrayList<>();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String str = br.readLine();
    int A = (int) ('A');

    for (int i = 0; i < str.length(); i++) {
      int c = (int) str.charAt(i) - A;
      c = (c + 26 - 3) % 26;
      System.out.print((char) (c + A));
    }

  }

}