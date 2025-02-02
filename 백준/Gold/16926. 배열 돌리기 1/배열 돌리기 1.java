import java.util.*;
import java.io.*;

public class Main {
	static int[][] board;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] nmr = br.readLine().split(" ");
		int N = Integer.parseInt(nmr[0]), M = Integer.parseInt(nmr[1]), R = Integer.parseInt(nmr[2]);

		board = new int[N][M];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		rotate(N, M, R);

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				bw.write(board[i][j] + " ");
			}
			bw.write("\n");
		}

		bw.flush();
		bw.close();
	}

	private static void rotate(int R, int C, int rot) {
		int[][] tmp = new int[R][C];
		for (int i = 0; i < R; i++) {
			tmp[i] = board[i].clone();
		}

		for (int i = 0; i < Math.min(R, C) / 2; i++) {
			Deque<Integer> dq = new LinkedList<>();

			for (int c = i; c < C - 1 - i; c++)
				dq.add(tmp[i][c]);
			for (int r = i; r < R - 1 - i; r++)
				dq.add(tmp[r][C - 1 - i]);
			for (int c = C - 1 - i; c > i; c--)
				dq.add(tmp[R - 1 - i][c]);
			for (int r = R - 1 - i; r > i; r--)
				dq.add(tmp[r][i]);

			for (int r = 0; r < rot; r++)
				dq.add(dq.removeFirst());

			for (int c = i; c < C - 1 - i; c++)
				board[i][c] = dq.removeFirst();
			for (int r = i; r < R - 1 - i; r++)
				board[r][C - 1 - i] = dq.removeFirst();
			for (int c = C - 1 - i; c > i; c--)
				board[R - 1 - i][c] = dq.removeFirst();
			for (int r = R - 1 - i; r > i; r--)
				board[r][i] = dq.removeFirst();
		}
	}
}
