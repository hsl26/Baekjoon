import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

  static int N, sum;
  static int[] arr;
  static PriorityQueue<Integer> pq = new PriorityQueue<>();

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());
    arr = new int[N];

    for (int i = 0; i < N; i++) {
      pq.add(Integer.parseInt(br.readLine()));
    }


    int ans = 0;
    while (pq.size() > 1) {
      sum = pq.poll() + pq.poll();
      ans += sum;
      pq.add(sum);
    }

    System.out.println(ans);

  }

}