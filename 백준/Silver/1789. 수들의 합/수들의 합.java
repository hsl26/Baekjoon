import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    long S = Long.parseLong(br.readLine());

    long sum = 0;
    int cnt = 0;
    for (long i = 1; i <= S; i++) {

      if (sum > S)
        break;

      sum += i;
      cnt++;
    }

    if (S == 1 || S == 2)
      cnt = 2;

    System.out.println(cnt - 1);

  }

}