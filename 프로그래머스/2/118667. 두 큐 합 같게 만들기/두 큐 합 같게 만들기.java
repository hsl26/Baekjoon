import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = -1;
        
        long sum1 = 0, sum2 = 0;
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        
        for (int i = 0; i < queue1.length; i++) {
            sum1 += queue1[i];
            sum2 += queue2[i];
            
            q1.add(queue1[i]);
            q2.add(queue2[i]);
        }
        
        int cnt = 0;
        while (cnt < 3 * queue1.length) {
            
            if (sum1 == sum2) {
                break;
            }
            
            else if (sum1 < sum2){
                sum2 -= q2.peek();
                sum1 += q2.peek();
                
                q1.add(q2.peek());
                q2.remove();
            }
            
            else {
                
                sum1 -= q1.peek();
                sum2 += q1.peek();
                
                q2.add(q1.peek());
                q1.remove();
            }
            
            cnt++;
        }
        
        if(cnt < 3 * queue1.length) answer = cnt;
            
        return answer;
    }
}