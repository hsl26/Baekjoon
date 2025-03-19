import java.util.*;

class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        
        Deque<Integer> s = new ArrayDeque<>();
        s.add(0);
        
        while (n > 0) {
            s.add(n % k);
            n /= k;
        }
        
        List<Long> candidate = new ArrayList<>();
        
        long sum = 0;        
        while (!s.isEmpty()) {
            
            if(s.getLast() == 0) {
                if(sum != 0)
                   candidate.add(sum);
                sum = 0;
            }
            
            sum *= 10;
            sum += s.pollLast();
        }
        
        for (int i = 0; i < candidate.size(); i++) {
            
            if(candidate.get(i) == 1) continue;
                  
            if(isDecimal(candidate.get(i)))
                answer++;
        }
            
        return answer;
    }
    
    public boolean isDecimal(long n) {

        if (n < 2) return false;
        if (n == 2 || n == 3) return true;
        if (n % 2 == 0) return false;

        // 3부터 √n까지 홀수만 체크
        for (long i = 3; i * i <= n; i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }
}