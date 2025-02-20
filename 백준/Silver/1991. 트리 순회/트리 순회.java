import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

  static String[] arr;

  static StringBuilder fsb = new StringBuilder();
  static StringBuilder msb = new StringBuilder();
  static StringBuilder bsb = new StringBuilder();

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());

    arr = new String[(int) (Math.pow(2, N))];
    arr[1] = "A";

    for (int i = 0; i < N; i++) {
      String[] tmp = br.readLine().split(" ");
      int idx = Arrays.asList(arr).indexOf(tmp[0]);

      if (!tmp[1].equals("."))
        arr[2 * idx] = tmp[1];

      if (!tmp[2].equals("."))
        arr[2 * idx + 1] = tmp[2];
    }

    front(1);
    middle(1);
    back(1);

    System.out.println(fsb);
    System.out.println(msb);
    System.out.println(bsb);
  }

  private static void back(int i) {

    if (i >= arr.length || arr[i] == null)
      return;

    back(2 * i);
    back(2 * i + 1);
    bsb.append(arr[i]);

  }

  private static void middle(int i) {

    if (i >= arr.length || arr[i] == null)
      return;

    middle(2 * i);
    msb.append(arr[i]);
    middle(2 * i + 1);

  }

  private static void front(int i) {

    if (i >= arr.length || arr[i] == null)
      return;

    fsb.append(arr[i]);
    front(2 * i);
    front(2 * i + 1);

  }


}