import java.util.*;
import java.io.*;

class Solution
{
    
    static char[] tree;
	static int N;
    static StringBuilder sb = new StringBuilder();

    
	public static void main(String args[]) throws Exception
	{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int t = 1; t <= 10; t++) {
			N = Integer.parseInt(br.readLine());

			tree = new char[N + 1];

			for (int i = 1; i <= N; i++) {
				String[] v = br.readLine().split(" ");
				tree[Integer.parseInt(v[0])] = v[1].charAt(0);
			}

			sb.append("#" + t + " ");
			middle(1);
			sb.append("\n");
		}
		System.out.println(sb);
	}
    private static void middle(int i) {

		if (i > N) return;
		
		middle(2 * i);
		sb.append(tree[i]);
		middle(2 * i + 1);
	}
}