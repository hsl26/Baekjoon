import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		int[] arr = new int[Math.max(6, N + 1)];

		arr[N] = -1;
		arr[3] = 1;
		arr[5] = 1;

		for (int i = 6; i <= N; i++) {
			if (arr[i - 5] == 0 && arr[i - 3] == 0)
				continue;
			else if (arr[i - 5] == 0)
				arr[i] = arr[i - 3] + 1;
			else if (arr[i - 3] == 0)
				arr[i] = arr[i - 5] + 1;
			else
				arr[i] = Math.min(arr[i - 5] + 1, arr[i - 3] + 1);
		}

		System.out.println(arr[N]);
	}
}