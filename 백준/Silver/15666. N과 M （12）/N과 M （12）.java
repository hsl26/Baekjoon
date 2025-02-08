import java.util.*;
import java.io.*;

public class Main {

	static BufferedWriter bw;
	static int N, M;
	static int[] Ns;
	static Set<ArrayList<Integer>> ts = new LinkedHashSet<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] arr = br.readLine().split(" ");
		N = Integer.parseInt(arr[0]);
		M = Integer.parseInt(arr[1]);

		Ns = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		Arrays.sort(Ns);

		bt(new ArrayList<>());

		for (ArrayList<Integer> a : ts) {
			for (int i = 0; i < a.size(); i++) {
				bw.write(a.get(i) + (i == a.size() - 1 ? "\n" : " "));
			}
		}

		bw.flush();
		bw.close();
	}

	private static void bt(ArrayList<Integer> a) {
		if (a.size() == M) {
			ts.add(new ArrayList<Integer>(a));
			return;
		}

		for (int i = 0; i < N; i++) {
			if (a.size() != 0 && Ns[i] < a.get(a.size() - 1))
				continue;
			a.add(Ns[i]);
			bt(a);
			a.remove(a.size() - 1);
		}
	}

}
