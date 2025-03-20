import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static class Node {
		int r;
		int c;
		boolean visit;

		public Node(int r, int c, boolean visit) {
			this.r = r;
			this.c = c;
			this.visit = visit;
		}

	}

	static Node home, penta;

	static int n, hr, hc, pr, pc;

	static int[] dr = { -1, -1, 1, 1 };
	static int[] dc = { -1, 1, 1, -1 };

	static List<Node> store;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			n = Integer.parseInt(br.readLine());

			st = new StringTokenizer(br.readLine());
			hr = Integer.parseInt(st.nextToken());
			hc = Integer.parseInt(st.nextToken());

			home = new Node(hr, hc, false);

			store = new ArrayList<>();
			for (int i = 1; i <= n; i++) {
				st = new StringTokenizer(br.readLine());
				int r = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());

				store.add(new Node(r, c, false));
			}

			st = new StringTokenizer(br.readLine());
			pr = Integer.parseInt(st.nextToken());
			pc = Integer.parseInt(st.nextToken());
			penta = new Node(pr, pc, false);
			store.add(penta);

			if (canGo(hr, hc, pr, pc) || bfs())
				sb.append("happy\n");

			else
				sb.append("sad\n");

		}
		System.out.println(sb);
	}

	private static boolean bfs() {

		Queue<Node> q = new LinkedList<>();

		q.add(home);

		while (!q.isEmpty()) {
			Node cur = q.poll();

			if (cur.r == penta.r && cur.c == penta.c)
				return true;

			for (int i = 0; i < store.size(); i++) {
				Node n = store.get(i);

				if (!n.visit) {
					if (canGo(cur.r, cur.c, n.r, n.c)) {
						n.visit = true;
						q.add(n);
					}
				}
			}
		}

		return false;
	}

	private static boolean canGo(int r, int c, int nr, int nc) {

		int dist = Math.abs(r - nr) + Math.abs(c - nc);

		if (dist / 50 > 20)
			return false;

		else if (dist / 50 == 20 && dist % 50 != 0)
			return false;

		return true;

	}
}
