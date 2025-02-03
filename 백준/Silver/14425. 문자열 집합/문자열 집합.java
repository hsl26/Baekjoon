import java.util.*;
import java.io.*;

public class Main {
	static int[][] board;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] arr = br.readLine().split(" ");
		int n = Integer.parseInt(arr[0]);
		int m = Integer.parseInt(arr[1]);

		String[] S = new String[n];
		for (int i = 0; i < n; i++) {
			S[i] = br.readLine();
		}
		
		int ans = 0;

		for (int i = 0; i < m; i++) {
			if (Arrays.asList(S).contains(br.readLine())) {
				ans++;
			}
		}
		
		System.out.println(ans);
	}

}
