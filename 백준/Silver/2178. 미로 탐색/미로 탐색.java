import java.io.*;
import java.util.*;

public class Main {
	static int N, M, answer = 0;

	static int[][] board;
	static int[][] visited;

	static int[] dr = { 0, 0, 1, -1 };
	static int[] dc = { 1, -1, 0, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String[] NM = br.readLine().split(" ");
		N = Integer.parseInt(NM[0]);
		M = Integer.parseInt(NM[1]);

		board = new int[N][M];
		visited = new int[N][M];

		for (int i = 0; i < N; i++) {
			String[] arr = br.readLine().split("");
			for (int j = 0; j <M; j++) {
				board[i][j] = Integer.parseInt(arr[j]);
			}
		}

		bfs();

		sb.append(visited[N-1][M-1]);

		System.out.println(sb);
	}

	private static void bfs() {
		Queue<int[]> q = new LinkedList<>();

		q.add(new int[] { 0, 0 });

		visited[0][0] = 1;

		while (!q.isEmpty()) {
			int r = q.peek()[0];
			int c = q.peek()[1];
			q.remove();
			answer++;

			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];

				if (can_go(nr, nc)) {
					q.add(new int[] { nr, nc });
					visited[nr][nc] = visited[r][c] + 1;
				}
			}
		}
		
		
	}

	private static boolean can_go(int r, int c) {
		if (r < 0 || r >= N || c < 0 || c >= M)
			return false;

		if (visited[r][c] > 0 || board[r][c] == 0)
			return false;
		return true;
	}

}