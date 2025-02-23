import java.io.*;
import java.util.*;

public class Main {
	static char[][] board;

	public static int case1(int r, int c) {
		char[][] std = { { 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B' }, { 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W' } };
		int cnt = 0;

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (board[r + i][c + j] != std[i % 2][j]) {
					cnt++;
				}
			}
		}
		return cnt;
	}

	public static int case2(int r, int c) {
		char[][] std = { { 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W' }, { 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B' } };
		int cnt = 0;

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (board[r + i][c + j] != std[i % 2][j]) {
					cnt++;
				}
			}
		}
		return cnt;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);

		board = new char[N][M];
		for (int i = 0; i < N; i++) {
			board[i] = br.readLine().toCharArray();
		}

		int minAns = Integer.MAX_VALUE;

		for (int r = 0; r <= N - 8; r++) {
			for (int c = 0; c <= M - 8; c++) {
				int ans1 = case1(r, c);
				int ans2 = case2(r, c);
				minAns = Math.min(minAns, Math.min(ans1, ans2));
			}
		}

		System.out.println(minAns);

	}
}