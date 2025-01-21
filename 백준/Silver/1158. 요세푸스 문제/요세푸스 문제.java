import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N, K;
		N = sc.nextInt();
		K = sc.nextInt();

		Queue<Integer> q = new LinkedList<>();
		Queue<Integer> ans = new LinkedList<>();

		for (int i = 1; i <= N; i++) {
			q.add(i);
		}

		while (q.size() > 0) {
			for (int i = 1; i < K; i++) {
				q.add(q.remove());
			}
			ans.add(q.remove());
		}

		System.out.print("<");
		for (int i=0; i<N-1; i++) {
			System.out.print(ans.remove());
			System.out.print(", ");
		}
		System.out.print(ans.remove());
		System.out.print(">");
		
	}
}
