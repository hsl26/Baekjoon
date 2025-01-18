import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(), cnt = 0;
		
		for(int i=0; i<N; i++) {
			String str = sc.next();
			int[] arr = new int[26];
			int t = -1, tmp_cnt = 1;
			int a = (int)('a');
			
			for (char s: str.toCharArray()) {
				if (arr[(int)s-a] == 0) {
					arr[(int)s-a] = 1;
					t = (int)s-a;
				} else if (t == (int)s-a) {
					continue;
				} else {
					tmp_cnt = 0;
					break;
				}
			}
			
			cnt += tmp_cnt;
		}
		
		System.out.print(cnt);
		
	}

}
