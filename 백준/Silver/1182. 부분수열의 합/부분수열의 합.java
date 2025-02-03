
import java.util.*;
import java.io.*;

public class Main {

	static int ans = 0;
	static int N;
	static int S;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] ns = br.readLine().split(" ");
		N = Integer.parseInt(ns[0]);
		S = Integer.parseInt(ns[1]);

		arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		BT(0, 0);

		if (S == 0)
			System.out.println(ans - 1);
		else
			System.out.println(ans);

	}

	private static void BT(int d, int sum) {
		if (d == N) {
			if (sum == S)
				ans++;
			return;
		}

		BT(d + 1, sum + arr[d]);
		BT(d + 1, sum);
	}

}
