import java.io.*;
import java.util.*;

public class Main  {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] arr = br.readLine().split("");
		
		ArrayList<Integer> sortArr = new ArrayList<>();

		for (int i = 0; i < arr.length; i++) {
			sortArr.add(Integer.parseInt(arr[i]));
		}
		
		Collections.sort(sortArr, Comparator.reverseOrder());
		
        StringBuilder sb = new StringBuilder();
		for (int num : sortArr) {
            sb.append(num);
        }
        System.out.print(sb);

	}

}