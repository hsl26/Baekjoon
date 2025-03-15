import java.util.*;

public class Main {
    // 파이 배열 계산 함수
    public static int[] computePi(char[] P) {
        int m = P.length;
        int[] pi = new int[m + 1];
        int i = 1, j = 0;

        while (i < m) {
            if (P[i] == P[j]) {
                i++;
                j++;
                pi[i] = j;
            } else if (j == 0) {
                i++;
                pi[i] = j;
            } else {
                j = pi[j];
            }
        }
        return pi;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] T = scanner.nextLine().toCharArray();
        char[] P = scanner.nextLine().toCharArray();
        scanner.close();

        int[] PI = computePi(P);
        int n = T.length, m = P.length;
        int i = 0, j = 0;
        List<Integer> ans = new ArrayList<>();

        while (i < n) {
            if (T[i] == P[j]) {
                i++;
                j++;
                if (j == m) { // 매칭 성공
                    ans.add(i - j + 1);
                    j = PI[j];
                }
            } else if (j == 0) {
                i++;
            } else {
                j = PI[j];
            }
        }

        System.out.println(ans.size());
        if (!ans.isEmpty()) {
            for (int idx : ans) {
                System.out.print(idx + " ");
            }
            System.out.println();
        }
    }
}