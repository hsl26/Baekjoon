import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int L = Integer.parseInt(st.nextToken());

    Queue<Integer> q = new PriorityQueue<>((n1, n2) -> n1 - n2);

    st = new StringTokenizer(br.readLine());

    for (int i = 0; i < N; i++)
      q.add(Integer.parseInt(st.nextToken()));


    while (!q.isEmpty() && q.peek() <= L) {
      L += 1;
      q.remove();
    }

    System.out.println(L);

  }
}