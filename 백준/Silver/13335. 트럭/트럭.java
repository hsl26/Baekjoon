import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 다리 위 트럭들의 무게의 합은 L보다 작거나 같다
		// 다리 위에는 w 대의 트럭만 동시에 올라갈 수 O

		String[] nwL = br.readLine().split(" ");

		int n = Integer.parseInt(nwL[0]), w = Integer.parseInt(nwL[1]), L = Integer.parseInt(nwL[2]);

		int[] a = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		Queue<Integer> q = new LinkedList<>();

		for (int i = 0; i < w; i++) {
			q.add(0);
		}

		int idx = 0;
		int wSum = 0;
		int time = 0;
		while (idx < a.length) {
			time += 1;
			// 맨 앞 트럭 빼기
			wSum -= q.remove();

			// 무게 가능한지 판별해서
			if (wSum + a[idx] <= L) {
				// 가능하면 트럭 추가
				q.add(a[idx]);
				wSum += a[idx];
				idx += 1;
			} else {
				// 불가능하면 0 추가
				q.add(0);
			}

		}
		
		while(wSum > 0) {
			wSum -= q.remove();
			time += 1;
		}

		System.out.println(time);
	}

}
