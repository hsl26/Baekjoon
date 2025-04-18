import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

  static int N, n;
  static double ans = 0;
  static ArrayList<double[]> coordinate = new ArrayList<>();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());

    for (int i = 0; i < N; i++) {
      String[] arr = br.readLine().split(" ");

      coordinate.add(new double[] {Double.parseDouble(arr[0]), Double.parseDouble(arr[1])});
    }


    double x1, x2, x3, y1, y2, y3;
    double area = 0;
    for (int i = 1; i < N - 1; i++) {
      x1 = coordinate.get(0)[0];
      x2 = coordinate.get(i)[0];
      x3 = coordinate.get(i + 1)[0];

      y1 = coordinate.get(0)[1];
      y2 = coordinate.get(i)[1];
      y3 = coordinate.get(i + 1)[1];

      double n = x1 * y2 + x2 * y3 + x3 * y1 - y1 * x2 - y2 * x3 - y3 * x1;

      area += 0.5 * n;
    }

    System.out.printf("%.1f\n", Math.abs(area));
  }

}