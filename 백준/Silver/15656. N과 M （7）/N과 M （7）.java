import java.util.*;
import java.io.*;

public class Main {

	static BufferedWriter bw;
	static int N, M;
	static int[] Ns;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] arr = br.readLine().split(" ");
		N = Integer.parseInt(arr[0]);
		M = Integer.parseInt(arr[1]);

		Ns = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		Arrays.sort(Ns);

		bt(new ArrayList<>());

		bw.flush();
		bw.close();
	}

	private static void bt(ArrayList<Integer> a) throws IOException {
		if (a.size() == M) {
			for (int n : a)
				bw.write(n + " ");
			bw.write("\n");
			return;
		}

		for (int i = 0; i < N; i++) {
			a.add(Ns[i]);
			bt(a);
			a.remove(a.size() - 1);
		}
	}

}
