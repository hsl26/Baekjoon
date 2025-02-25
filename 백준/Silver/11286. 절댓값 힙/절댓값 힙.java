import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    Queue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {

      @Override
      public int compare(Integer o1, Integer o2) {
        if (Math.abs(o1) == Math.abs(o2))
          return o1 - o2;

        return Math.abs(o1) - Math.abs(o2);
      }

    });


    int N = Integer.parseInt(br.readLine());

    int x;
    for (int i = 0; i < N; i++) {
      x = Integer.parseInt(br.readLine());

      if (x != 0) {
        queue.offer(x);
      } else {
        if (queue.isEmpty())
          System.out.println(0);
        else
          System.out.println(queue.poll());
      }

    }

  }

}