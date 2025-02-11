import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {

	static int[] d;
	static ArrayList<Integer>[] tree = new ArrayList[100001];
	static int[][] par = new int[100001][20];
	static int N;
	static long ans = 0;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());

			d = new int[N + 1];
			for (int i = 1; i <= N; i++) {
				tree[i] = new ArrayList<>();
			}

			par[1][0] = 0;
			StringTokenizer st = new StringTokenizer(br.readLine().trim());

			for (int i = 2; i <= N; i++) {
				int k = Integer.parseInt(st.nextToken());
				tree[k].add(i);
				par[i][0] = k;
				d[i] = d[k] + 1;
			}
			

			for (int y = 1; y < 20; y++) {
				for (int x = 1; x <= N; x++) {
					par[x][y] = par[par[x][y - 1]][y - 1];
				}
			}

			ans = 0;
			bfs();
			
            System.out.println("#"+t+" "+ans);
		}
	}

	private static void bfs() {
		Queue<Integer> q = new LinkedList<>();
		boolean[] visited = new boolean[N + 1];

		q.add(1);
		visited[1] = true;
		int cur = 0, pre = 1;

		while (!q.isEmpty()) {
			int x = q.remove();

			for (int i = 0; i < tree[x].size(); i++) {
				int y = tree[x].get(i);
				if (visited[y])
					continue;
				
				q.add(y);
				cur = y;
				visited[y] = true;
				ans += LCA(pre, cur, 0);
				pre = cur;
			}
		}

	}

	private static int LCA(int x, int y, int cnt) {
		if (d[x] > d[y]) {
			int tmp = x;
			x = y;
			y = tmp;
		}
		if (par[y][0] == x) {
			return 1;
		}
		for (int i = 19; i >= 0; i--) {
			if (d[y] - d[x] >= (1 << i)) {
				y = par[y][i];
				cnt += (1 << i);
			}
		}
		if (par[y][0] != par[x][0]) {
			for (int i = 19; i >= 0; i--) {
				if (par[x][i] != par[y][i]) {
					cnt += 2 * (1 << i);
					x = par[x][i];
					y = par[y][i];
				}
			}
		}
		if (par[x][0] == par[y][0]) {
			return cnt + 2;
		}
		return 0;
	}

}
