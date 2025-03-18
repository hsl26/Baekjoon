class Solution {
    
    static int U, E;
    
    static int[] price, answer;
    
    static int[] discount = {40, 30, 20, 10};
        
    public int[] solution(int[][] users, int[] emoticons) {
        answer = new int[2];
        
        U = users.length;
        E = emoticons.length;
        
        price = new int[U];
        
        comb(0, users, emoticons);
        
        return answer;
    }
    
    public void comb(int d, int[][] users, int[] emoticons) {
        if(d == E) {
            int sum = 0, cnt = 0;
            for(int i=0; i<U; i++) {
                if (price[i] >= users[i][1]) cnt++;
                else sum += price[i];
            }
            
            if(answer[0] < cnt) {
                answer[0] = cnt;
                answer[1] = sum;
            } else if (answer[0] == cnt) {
                answer[1] = Math.max(answer[1], sum);
            }
            
            return;
        }
        
        for(int i = 0; i < 4; i++) {
            int p = emoticons[d] * (100 - discount[i]) / 100;
            
            for(int u = 0; u < U; u++) {
                if(users[u][0] <= discount[i])
                    price[u] += p;
            }
            
            comb(d+1, users, emoticons);
            
            for(int u = 0; u < U; u++) {
                if(users[u][0] <= discount[i])
                    price[u] -= p;
            }
        }
    }
}