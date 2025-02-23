import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringBuilder sb = new StringBuilder();

		Queue<Integer> q = new LinkedList<>();

		int N = Integer.parseInt(br.readLine());
		
		for (int i=1;i<=N;i++) {
			q.add(i);
		}

		while (q.size() > 2) {
			q.remove();
			q.add(q.remove());
		}

	
		if (q.size() == 2)
			q.remove();
		
		int ans = q.remove();

		System.out.println(ans);
	}
}