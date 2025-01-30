import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) {
        
		Scanner sc = new Scanner(System.in);

		int sum = 0;
		int[] arr = new int[9];

		for (int i = 0; i < 9; i++) {
			arr[i] = sc.nextInt();
			sum += arr[i];
		}
		
		Arrays.sort(arr);

		for (int i = 0; i < 9; i++) {
			for (int j = i + 1; j < 9; j++) {
				if (sum - arr[i] -arr[j] == 100) {
					for (int h:arr) {
						if (h != arr[i] && h!= arr[j]) {
							System.out.println(h);
						}
					}
					sum = 100;
					break;
				}
			}
			if (sum == 100) {
				break;
			}
		}

	}

}
