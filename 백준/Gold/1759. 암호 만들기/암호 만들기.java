import java.util.*;
import java.io.*;

public class Main {

	static int L, C;
	static char[] arr;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);

		L = sc.nextInt();
		C = sc.nextInt();

		arr = new char[C];

		for (int i = 0; i < C; i++) {
			arr[i] = sc.next().charAt(0);
		}

		Arrays.sort(arr);

		ArrayList<Character> list = new ArrayList<>();
		bT(0, 0, 0, list);

		bw.flush();
		bw.close();

	}

	private static void bT(int d, int v, int c, ArrayList<Character> list) throws IOException {

		if (list.size() == L) {
			if (v >= 1 && c >= 2) {
				for (char l : list) {
					bw.write(l);
				}
				bw.write('\n');
			}
			return;
		}

		for (int i = d; i < C; i++) {
			list.add(arr[i]);
			if (arr[i] == 'a' || arr[i] == 'e' || arr[i] == 'i' || arr[i] == 'o' || arr[i] == 'u') {
				bT(i + 1, v + 1, c, list);
			} else {
				bT(i + 1, v, c + 1, list);
			}

			list.remove(list.size() - 1);
		}
	}

}
