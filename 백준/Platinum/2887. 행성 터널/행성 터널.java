import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

  static int N, dir;

  static int[] parent;

  static class Edge implements Comparable<Edge> {
    int from, to, cost;

    Edge(int from, int to, int cost) {
      this.from = from;
      this.to = to;
      this.cost = cost;
    }

    public int compareTo(Edge e) {
      return this.cost - e.cost;
    }
  }

  static class Planet {
    int num, x, y, z;

    Planet(int num, int x, int y, int z) {
      this.num = num;
      this.x = x;
      this.y = y;
      this.z = z;
    }
  }


  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    N = Integer.parseInt(br.readLine());
    parent = new int[N];

    Planet[] planets = new Planet[N];
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());
      int z = Integer.parseInt(st.nextToken());
      planets[i] = new Planet(i, x, y, z);
      parent[i] = i;
    }

    List<Edge> edges = new ArrayList<>();


    // x 기준 정렬
    Arrays.sort(planets, Comparator.comparingInt(p -> p.x));
    for (int i = 1; i < N; i++) {
      int cost = Math.abs(planets[i].x - planets[i - 1].x);
      edges.add(new Edge(planets[i].num, planets[i - 1].num, cost));
    }

    // y 기준 정렬
    Arrays.sort(planets, Comparator.comparingInt(p -> p.y));
    for (int i = 1; i < N; i++) {
      int cost = Math.abs(planets[i].y - planets[i - 1].y);
      edges.add(new Edge(planets[i].num, planets[i - 1].num, cost));
    }

    // z 기준 정렬
    Arrays.sort(planets, Comparator.comparingInt(p -> p.z));
    for (int i = 1; i < N; i++) {
      int cost = Math.abs(planets[i].z - planets[i - 1].z);
      edges.add(new Edge(planets[i].num, planets[i - 1].num, cost));
    }

    Collections.sort(edges);

    long result = 0;
    int cnt = 0;

    for (Edge e : edges) {
      if (union(e.from, e.to)) {
        result += e.cost;
        cnt++;
        if (cnt == N - 1)
          break;
      }
    }

    System.out.println(result);

  }


  static int find(int x) {
    if (parent[x] == x)
      return x;
    return parent[x] = find(parent[x]);
  }

  static boolean union(int a, int b) {
    a = find(a);
    b = find(b);
    if (a == b)
      return false;
    parent[b] = a;
    return true;
  }


}