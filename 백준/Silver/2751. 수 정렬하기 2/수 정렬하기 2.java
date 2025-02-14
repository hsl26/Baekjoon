import java.io.*;
import java.util.*;

public class Main  {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		ArrayList<Integer> arr = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			arr.add(Integer.parseInt(br.readLine()));
		}
		
		Collections.sort(arr);
		
        StringBuilder sb = new StringBuilder();
		for (int num : arr) {
            sb.append(num).append('\n');
        }
        System.out.print(sb);

	}

}