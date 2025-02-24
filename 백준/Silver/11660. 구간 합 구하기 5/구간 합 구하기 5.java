import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] board = new int[N + 1][N + 1]; 

		for (int r = 1; r <= N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 1; c <= N; c++) {
				board[r][c] = Integer.parseInt(st.nextToken());
			}
		}

		int[][] S = new int[N + 1][N + 1];

		for (int r = 1; r <= N; r++) {
			for (int c = 1; c <= N; c++) {
                S[r][c] = board[r][c] + S[r - 1][c] + S[r][c - 1] - S[r - 1][c - 1];
			}
		}

		for (int i = 0; i < M; i++) {
			int x1, y1, x2, y2;
			st = new StringTokenizer(br.readLine());
			x1 = Integer.parseInt(st.nextToken());
			y1 = Integer.parseInt(st.nextToken());
			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());

            int result = S[x2][y2] - S[x1 - 1][y2] - S[x2][y1 - 1] + S[x1 - 1][y1 - 1];
            System.out.println(result);

		}

	}

}