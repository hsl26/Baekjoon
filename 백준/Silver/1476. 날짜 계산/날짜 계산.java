import java.util.*;
import java.io.*;

public class Main {

	static int MAX_E = 15, MAX_S = 28, MAX_M = 19;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int E, S, M;

		E = sc.nextInt();
		S = sc.nextInt();
		M = sc.nextInt();

		int y = 0 * MAX_E + E;

		while (y <= Integer.MAX_VALUE) {
			int remain_S = (y % MAX_S != 0) ? y % MAX_S : MAX_S;
			int remain_M = (y % MAX_M != 0) ? y % MAX_M : MAX_M;
			if (remain_S == S && remain_M == M) {
				System.out.println(y);
				break;
			}
			y += MAX_E;
		}

	}
}
