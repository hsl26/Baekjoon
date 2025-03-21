import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        
        Map<Integer, Integer> g = new HashMap<>();
        
        for(int t : tangerine) {
            
            g.putIfAbsent(t, 0);
            
            g.put(t, g.get(t)+1);
            
        }
        
        ArrayList<Integer> cnt = new ArrayList<>();
        
        for (int key : g.keySet()) {
            cnt.add(g.get(key));
        }
        
        Collections.sort(cnt, (c1, c2) -> c2-c1);
        
        int i = 0;
        for (i = 0; i < cnt.size(); i++) {
            if (k <= 0) break;
            
            k -= cnt.get(i);
        }
        
        return i;
    }
}