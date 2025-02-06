import java.util.*;
import java.io.*;

public class Main {

	static int F, S, G, U, D;
	static int[] visited;
	static Queue<int[]> q = new LinkedList<>();
	static ArrayList<Integer> dir = new ArrayList<>();

	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);

		F = sc.nextInt();
		S = sc.nextInt();
		G = sc.nextInt();
		U = sc.nextInt();
		D = sc.nextInt();
		
		if (S == G) {
			System.out.println(0);
			return;
		}

		visited = new int[F + 1];
		dir.add(-1 * D);
		dir.add(U);

		q.add(new int[] { S, 1 });
		visited[S] = 1;
		int result  = bfs();

		if (result >= 0) {
            System.out.println(result);
        } else {
            System.out.println("use the stairs");
        }
	}

	private static int bfs() {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { S, 0 }); // 현재 층과 버튼 누른 횟수
		visited[S] = 1;

		while (!q.isEmpty()) {
			int[] arr = q.poll();
			int current = arr[0];
			int count = arr[1];

			int[] moves = { U, -D };

			for (int move : moves) {
				int next = current + move;

				if (next >= 1 && next <= F && visited[next] == 0) {
					if (next == G) {
						return count + 1;
					}
					q.add(new int[] { next, count + 1 });
					visited[next] = 1;
				}
			}
		}

		return -1; 
	}
}
