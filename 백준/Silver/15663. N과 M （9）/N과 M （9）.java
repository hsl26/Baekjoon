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

		bt(0, new ArrayList<>(), new ArrayList<>());
		
		for (ArrayList<Integer> a : ts) {
			for (int i = 0; i < a.size(); i++) {
                bw.write(a.get(i) + (i == a.size() - 1 ? "\n" : " "));
            }
		}

		bw.flush();
		bw.close();
	}

	private static void bt(int d, ArrayList<Integer> a, ArrayList<Integer> h) throws IOException {
		if (a.size() == M) {
			ts.add(new ArrayList<Integer>(a));
			return;
		}

		for (int i = 0; i < N; i++) {
			if (h.contains(i))
				continue;
			a.add(Ns[i]);
			h.add(i);
			bt(i, a,  h);
			a.remove(a.size() - 1);
			h.remove(h.size() - 1);
		}
	}

}
