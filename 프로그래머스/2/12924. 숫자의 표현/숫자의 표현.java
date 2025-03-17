import java.util.*;

class Solution {
    ArrayList<Integer> arr = new ArrayList<>();
    
    public int solution(int n) {
        int answer = 0;
        
        divisor(2*n);
        
        for (int i=0;i<arr.size();i++) {
            int c = arr.get(i);
            for (int s=1;s<=n/c;s++) {
                     if (2*s + c -1 == 2*n/c) answer++;
             }
        }
        
        return answer;
    }
    
    public void divisor(int n) {
        
        for (int i=1;i<=n;i++) {
            if (n%i == 0) arr.add(i);
        }
    }
}