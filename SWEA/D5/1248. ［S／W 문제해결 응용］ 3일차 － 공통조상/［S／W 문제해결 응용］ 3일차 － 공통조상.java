import java.util.*;
import java.io.*;

public class Solution {

	static int[] parent;
	static boolean[] visited;
	static int cnt;

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			sb.append("#" + t + " ");

			String[] arr = br.readLine().split(" ");
			int V = Integer.parseInt(arr[0]);
			int E = Integer.parseInt(arr[1]);
			int v1 = Integer.parseInt(arr[2]);
			int v2 = Integer.parseInt(arr[3]);

			parent = new int[V + 1];
			visited = new boolean[V + 1];

			String[] vs = br.readLine().split(" ");

			for (int i = 0; i < E; i++) {
				parent[Integer.parseInt(vs[2 * i + 1])] = Integer.parseInt(vs[2 * i]);
			}
			
//			공통 조상 찾기  
			Set<Integer> ancestors = new HashSet<>();
			while (v1 != 0) {  
			    ancestors.add(v1);
			    v1 = parent[v1];
			}
			while (v2 != 0) { 
			    if (ancestors.contains(v2)) break;
			    v2 = parent[v2];
			}
			sb.append(v2 + " ");

//			자식 개수 찾기 
			cnt = 0;
			subs(v2);
			sb.append(cnt);

			sb.append("\n");
		}
		System.out.println(sb);
	}

	private static void subs(int sp) {
		Queue<Integer> q = new LinkedList<>();
		visited[sp] = true;
		q.add(sp);
		while (!q.isEmpty()) {
			int cur = q.remove();
			cnt++;

			for (int p = 1; p < parent.length; p++) {
				if (parent[p] == cur) {
					q.add(p);
				}
			}
		}

	}

}
