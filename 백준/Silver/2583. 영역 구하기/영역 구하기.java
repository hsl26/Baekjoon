import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int R, C, K, cnt;

	static int[] dr = { 0, 0, 1, -1 };
	static int[] dc = { 1, -1, 0, 0 };

	static int[][] board, visited;

	static ArrayList<Integer> area = new ArrayList<>();

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		board = new int[R][C];
		visited = new int[R][C];

		for (int i = 0; i < K; i++) {
			int c1, r1, c2, r2;
			st = new StringTokenizer(br.readLine());

			c1 = Integer.parseInt(st.nextToken());
			r1 = Integer.parseInt(st.nextToken());
			c2 = Integer.parseInt(st.nextToken());
			r2 = Integer.parseInt(st.nextToken());

			for (int r = r1; r < r2; r++) {
				for (int c = c1; c < c2; c++) {
					board[r][c] = 1;
				}
			}
		}

		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if (board[r][c] == 0 && visited[r][c] == 0) {
					cnt = 0;
					bfs(r, c);
					area.add(cnt);
				}
			}
		}

		Collections.sort(area);
		System.out.println(area.size());
		for(int i=0;i<area.size();i++) {
			sb.append(area.get(i)).append(" ");
		}
		System.out.println(sb);
	}

	private static void bfs(int r, int c) {

		Queue<int[]> q = new LinkedList<>();

		q.add(new int[] { r, c });
		visited[r][c] = 1;

		while (!q.isEmpty()) {
			int[] cur = q.remove();
			r = cur[0];
			c = cur[1];
			cnt++;

			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];

				if (canGo(nr, nc)) {
					q.add(new int[] { nr, nc });
					visited[nr][nc] = 1;
				}
			}
		}
	}

	private static boolean canGo(int r, int c) {
		if (r < 0 || r >= R || c < 0 || c >= C)
			return false;
		if (visited[r][c] == 1 || board[r][c] == 1)
			return false;
		return true;
	}

}