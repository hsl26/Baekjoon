class Solution {
    
    int answer, K;
    int[][] dun;
    boolean[] visited;
        
    public int solution(int k, int[][] dungeons) {
        answer = 0;            
    
        dun = dungeons;
        K = k;
        visited = new boolean[dun.length];
        
        dfs(0, 0);
        
        return answer;
    }
    
    public void dfs(int d, int cnt){
        
        if (d == dun.length) {
            answer = Math.max(answer, cnt);
            return;
        }
        
        for (int i=0; i<dun.length; i++) {
            if(!visited[i]) {
                if(K >= dun[i][0]) {
                    visited[i] = true;
                    K -= dun[i][1];
                    dfs(d+1, cnt+1);
                    K += dun[i][1];
                    visited[i] = false;
                } else {
                    dfs(d+1, cnt);
                }
            }
            
        }
    }
}