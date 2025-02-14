
import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(br.readLine());

		String[] arr = new String[N];

		for (int i = 0; i < N; i++) {
			arr[i] = br.readLine();
		}

		Arrays.sort(arr, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				if (s1.length() == s2.length()) {
					for (int i = 0; i < s1.length(); i++) {
						if (s1.charAt(i) != s2.charAt(i))
							return s1.charAt(i) - s2.charAt(i);
					}
				}
				return s1.length() - s2.length();
			}
		});

		for (int i = 0; i < N; i++) {
			if (i != 0 && arr[i].equals(arr[i-1])) continue;
			bw.write(arr[i] + "\n");
		}

		bw.flush();
		bw.close();

	}

}
