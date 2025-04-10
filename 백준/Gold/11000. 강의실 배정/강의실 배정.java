import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

  static int N, s, e, idx;

  static PriorityQueue<int[]> course;
  static PriorityQueue<Integer> room;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st;

    N = Integer.parseInt(br.readLine());

    course = new PriorityQueue<>((c1, c2) -> c1[0] - c2[0]);
    room = new PriorityQueue<>();

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      s = Integer.parseInt(st.nextToken());
      e = Integer.parseInt(st.nextToken());

      course.add(new int[] {s, e});
    }

    while (!course.isEmpty()) {
      s = course.peek()[0];
      e = course.peek()[1];
      course.poll();

      if (!room.isEmpty() && room.peek() <= s) {
        room.poll();
      }

      room.add(e);
    }

    System.out.println(room.size());
  }

}