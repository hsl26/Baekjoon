import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
				
		int N = sc.nextInt();
		
		for (int i=0; i<N; i++) {
			int cnt = 0;
			String str = sc.next();
			String[] arr = str.split("");
			
			for (String c : arr) {
				if (c.equals("(")) {
					cnt++;
				} else if (c.equals(")")){
					if (cnt == 0) {
						cnt = -1;
						break;
					}
					cnt--;
				} 
			}
			
			if (cnt == 0) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
		
	}
}
