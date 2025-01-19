import java.util.*;
import java.util.stream.Stream;

public class Main {
	
	public static boolean isHan(int a) {
		
		int[] numarr = Stream.of(String.valueOf(a).split("")).mapToInt(Integer::parseInt).toArray();
		
		int d = numarr[0] - numarr[1];
		
		for (int i=1; i<numarr.length-1; i++) {
			if (d != numarr[i] - numarr[i+1]) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int cnt = 0;
		
		int N = sc.nextInt();
		
		if (N < 100) {
			System.out.println(N);
		} else {
			for (int n = 100; n <= N; n++) {
				if (isHan(n)) {
					cnt++;
				}
			}
			System.out.println(cnt+99);
		}
		
	}
}
