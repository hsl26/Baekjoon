import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringBuilder sb = new StringBuilder();
		
		Stack<Integer> s = new Stack<>();

		int K = Integer.parseInt(br.readLine());

		for (int i = 0; i < K; i++) {
			int n = Integer.parseInt(br.readLine());
			
			if (n != 0)
				s.add(n);
			else
				s.pop();
		}
		
		int sum = 0;
		
		while (!s.isEmpty()) {
			sum += s.pop();
		}
		
		System.out.println(sum);
	}
}