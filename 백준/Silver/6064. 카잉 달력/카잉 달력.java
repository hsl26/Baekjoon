import java.util.*;
import java.io.*;

public class Main {

	private static int GCD(int a, int b) {
		while (b != 0) {
			int temp = a % b;
			a = b;
			b = temp;
		}
		return a;
	}

	private static int LCM(int a, int b) {
		return a * b / GCD(a, b);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			int M, N, x, y;
			String[] arr = br.readLine().split(" ");

			M = Integer.parseInt(arr[0]);
			N = Integer.parseInt(arr[1]);
			x = Integer.parseInt(arr[2]);
			y = Integer.parseInt(arr[3]);

			int lcm = LCM(M, N);
			int ans = -1;

			for (int i = x; i <= lcm; i += M) {
				int remainY = (i % N == 0) ? N : i % N;
				if (remainY == y) {
					ans = i;
					break;
				}
			}
			bw.write(ans + "\n");
		}

		bw.flush();
		bw.close();
	}
}
