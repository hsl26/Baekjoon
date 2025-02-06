import java.util.*;
import java.io.*;

public class Main {

	static int N;
	static int[][] board;
	static int[][] visited;
	static Queue<int[]> q = new LinkedList<>();
	static ArrayList<Integer> danji = new ArrayList<>();
	static int[] dr = { 0, 0, 1, -1 };
	static int[] dc = { 1, -1, 0, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		board = new int[N][N];
		visited = new int[N][N];

		for (int i = 0; i < N; i++) {
			String[] tmp = br.readLine().split("");
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(tmp[j]);
			}
		}

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (visited[r][c] == 0 && board[r][c] == 1) {
					q.clear();

					q.add(new int[] { r, c });
					visited[r][c] = 1;
					danji.add(bfs());
				}
			}
		}
		
		Collections.sort(danji);
		
		System.out.println(danji.size());
		for (int d : danji) {
			System.out.println(d);
		}
	}

	private static int bfs() {
		int r, c;
		int cnt = 1;
		while (!q.isEmpty()) {
			r = q.peek()[0];
			c = q.peek()[1];
			q.remove();

			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];

				if (can_go(nr, nc)) {
					q.add(new int[] { nr, nc });
					visited[nr][nc] = 1;
					cnt++;
				}
			}
		}
		return cnt;
	}

	private static boolean can_go(int r, int c) {
		if (r < 0 || r >= N | c < 0 || c >= N)
			return false;

		if (visited[r][c] == 1 || board[r][c] == 0)
			return false;

		return true;
	}

}
