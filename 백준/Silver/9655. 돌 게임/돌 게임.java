import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

  static int N;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());

    if (N % 2 == 1)
      System.out.println("SK");
    else
      System.out.println("CY");

  }

}