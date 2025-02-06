import java.util.*;
import java.io.*;

public class Main {

	static int n;
	static List<Integer>[] graph;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());

		String[] people = br.readLine().split(" ");
		int person1 = Integer.parseInt(people[0]), person2 = Integer.parseInt(people[1]);

		if (person1 == person2) {
			System.out.println(0);
			return;
		}

		int m = Integer.parseInt(br.readLine());

		graph = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) {
			graph[i] = new ArrayList<>();
		}
		visited = new boolean[n + 1];

		for (int i = 0; i < m; i++) {
			String[] tmp = br.readLine().split(" ");
			int a = Integer.parseInt(tmp[0]);
			int b = Integer.parseInt(tmp[1]);

			graph[a].add(b);
			graph[b].add(a);
		}

		int ans = bfs(person1, person2);
		System.out.println(ans);
	}

	private static int bfs(int start, int target) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { start, 0 }); // 시작 노드와 촌수(깊이)를 함께 저장
		visited[start] = true;

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int person = cur[0];
			int depth = cur[1];

			if (person == target) {
				return depth;
			}

			for (int next : graph[person]) {
				if (!visited[next]) {
					visited[next] = true;
					q.add(new int[] { next, depth + 1 });
				}
			}
		}

		return -1;
	}
}
