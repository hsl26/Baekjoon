import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static int MOD = 10007;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        int[][] dp = new int[N + 1][10];

        for (int j = 0; j < 10; j++) {
            dp[1][j] = 1;
        }

        for (int i = 2; i <= N; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = j; k < 10; k++) { 
                    dp[i][j] = (dp[i][j] + dp[i - 1][k]) % MOD;
                }
            }
        }

        int result = 0;
        for (int j = 0; j < 10; j++) {
            result = (result + dp[N][j]) % MOD;
        }

        System.out.println(result);
    }
}
