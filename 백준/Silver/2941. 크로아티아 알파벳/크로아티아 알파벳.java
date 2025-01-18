import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		String[] arr = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
		List<String> strList = new ArrayList<>(Arrays.asList(arr));

		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();
		
		int s = 0;
		int ans = 0;
		
		while (s < str.length()) {
			
			if (s + 2 <= str.length() && strList.contains(str.substring(s, s+2))) {
				ans += 1;
				s += 2;
			} else if (s + 3 <= str.length() && strList.contains(str.substring(s, s+3))) {
				ans += 1;
				s += 3;
			} else {
				ans += 1;
				s += 1;
			}
		}
		
		System.out.println(ans);
	}

}
