import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  static int answer = Integer.MAX_VALUE;
  static int N, curSize;

  static int[] people;

  static ArrayList<Integer> A = new ArrayList<>();

  static Map<Integer, List<Integer>> map = new HashMap<>();


  private static void init() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    N = Integer.parseInt(br.readLine());

    people = new int[N + 1];
    for (int i = 1; i <= N; i++) {
      map.put(i, new ArrayList<>());
    }

    st = new StringTokenizer(br.readLine());
    for (int i = 1; i <= N; i++) {
      people[i] = Integer.parseInt(st.nextToken());
    }

    for (int i = 1; i <= N; i++) {
      st = new StringTokenizer(br.readLine());
      int cnt = Integer.parseInt(st.nextToken());
      for (int c = 0; c < cnt; c++) {
        map.get(i).add(Integer.parseInt(st.nextToken()));
      }
    }

  }


  private static void comb(int d) {
    if (A.size() == curSize) {

      // A구역은 1, B 구역은 0
      int[] section = new int[N + 1];
      section[0] = -1;

      for (int i = 0; i < A.size(); i++) {
        section[A.get(i)] = 1;
      }

      // 인구 차 계산
      int sumA = 0;
      int sumB = 0;

      int b = 0; // B에 속하는 선거구 중 하나
      int bsize = 0;

      for (int i = 1; i <= N; i++) {
        if (section[i] == 1)
          sumA += people[i];

        if (section[i] == 0) {
          b = i;
          bsize++;
          sumB += people[i];
        }
      }

      // A 구역 연결돼있는지
      int[] visited = new int[N + 1];
      Queue<Integer> q = new LinkedList<>();
      int cnt = 0;

      q.add(A.get(0));
      visited[A.get(0)] = 1;

      while (!q.isEmpty()) {
        int n = q.remove();
        cnt++;
        for (int i = 0; i < map.get(n).size(); i++) {
          if (section[map.get(n).get(i)] == 1 && visited[map.get(n).get(i)] == 0) {
            q.add(map.get(n).get(i));
            visited[map.get(n).get(i)] = 1;
          }
        }
      }

      if (cnt != A.size())
        return;

      // B 구역 연결돼있는지
      visited = new int[N + 1];
      q = new LinkedList<>();
      cnt = 0;

      q.add(b);
      visited[b] = 1;

      while (!q.isEmpty()) {
        int n = q.remove();
        cnt++;
        for (int i = 0; i < map.get(n).size(); i++) {
          if (section[map.get(n).get(i)] == 0 && visited[map.get(n).get(i)] == 0) {
            q.add(map.get(n).get(i));
            visited[map.get(n).get(i)] = 1;
          }
        }
      }

      if (cnt != bsize)
        return;

      answer = Math.min(answer, Math.abs(sumA - sumB));

      return;
    }

    for (int i = d; i < N; i++) {
      A.add(i);

      comb(i + 1);

      A.remove(A.size() - 1);

    }
  }

  public static void main(String[] args) throws Exception {

    init();

    // A구역 몇 개 연결할건지 -> i
    for (int i = 1; i < N; i++) {
      curSize = i;
      comb(1);
    }

    if (answer == Integer.MAX_VALUE)
      answer = -1;

    System.out.println(answer);
  }

}