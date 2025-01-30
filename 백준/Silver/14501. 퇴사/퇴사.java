import java.util.*;
import java.io.*;

public class Main {

	static long ans = 0;
	static int N = 0;
	static int[] T;
	static int[] P;

	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		T = new int[N + 1];
		P = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			T[i] = sc.nextInt();
			P[i] = sc.nextInt();
		}

		ArrayList<Integer> list = new ArrayList<>();

		bT(0, list);

		System.out.println(ans);

	}

	private static void bT(int d, ArrayList<Integer> list) {

		if (d > N + 1) {
			return;
		}

		long total = list.stream().mapToInt(Integer::intValue).sum();
		;
		if (total > ans) {
			ans = total;
		}

		for (int i = d + 1; i <= N; i++) {
			if (i + (T[i] - 1) > N) {
				continue;
			}

			list.add(P[i]);
			bT(i + (T[i] - 1), list);
			list.remove(list.size() - 1);
		}

	}
}
