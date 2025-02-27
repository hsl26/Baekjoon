import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
  private static class Node {

    public int vertex;
    public int weight;
    public Node link;

    public Node(int vertex, int weight, Node link) {
      super();
      this.vertex = vertex;
      this.weight = weight;
      this.link = link;
    }

  }

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st;

    int T = Integer.parseInt(br.readLine());

    for (int t = 1; t <= T; t++) {
      sb.append("#").append(t).append(" ");

      st = new StringTokenizer(br.readLine(), " ");
      int N = Integer.parseInt(st.nextToken()); // 정점 수
      int M = Integer.parseInt(st.nextToken()); // 간선 수

      Node[] adjList = new Node[N + 1];

      for (int i = 0; i < M; i++) {
        st = new StringTokenizer(br.readLine(), " ");
        int from = Integer.parseInt(st.nextToken());
        int to = Integer.parseInt(st.nextToken());
        int weight = Integer.parseInt(st.nextToken());

        adjList[from] = new Node(to, weight, adjList[from]);
        adjList[to] = new Node(from, weight, adjList[to]);
      }

      int[] minEdge = new int[N + 1]; // 다른정점에서 자신으로 연결하는 MST를 구성하는 간선비용 중 최소비용
      boolean[] visited = new boolean[N + 1]; // 신장트리에 선택된 여부
      Arrays.fill(minEdge, Integer.MAX_VALUE);

      // 0단계: 첫 방문 정점의 최소비용을 0으로 설정
      int vertexCount = 0; // 선택된 정점의 개수
      long result = 0; // MST 비용 (구하고자 하는 값)
      minEdge[0] = 0; // 임의의 시작점을 0번 정점으로 설정

      PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

      // 시작 정점 선택 (1번 정점부터 시작)
      minEdge[1] = 0;
      pq.offer(new int[] {0, 1}); // 비용 0, 정점 1

      result = 0; // 최소 스패닝 트리 비용
      vertexCount = 0; // 선택된 정점 개수

      while (!pq.isEmpty() && vertexCount < N) {
        int[] current = pq.poll();
        int min = current[0];
        int vertex = current[1];

        if (visited[vertex])
          continue;

        // 정점 선택
        visited[vertex] = true;
        result += min;
        vertexCount++;

        // 인접 정점 갱신
        for (Node temp = adjList[vertex]; temp != null; temp = temp.link) {
          if (!visited[temp.vertex] && minEdge[temp.vertex] > temp.weight) {
            minEdge[temp.vertex] = temp.weight;
            pq.offer(new int[] {temp.weight, temp.vertex});
          }
        }
      }

      sb.append(result).append("\n");
    }
    System.out.println(sb);
  }

}