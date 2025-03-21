import java.util.*;

class Solution {
    
    public int solution(String dirs) {
        int answer = 0;
        
        // 4방향 저장
        Map<String, int[]> dir = new HashMap<>();
        dir.put("U", new int[] {-1, 0, 0});
        dir.put("D", new int[] {1, 0, 2});
        dir.put("R", new int[] {0, 1, 1});
        dir.put("L", new int[] {0, -1, 3});
        
        // -5->0 , 0->5, 5->10 => 시작점은 (5, 5)
        int[][] board = new int[11][11];
        boolean[][][] visited = new boolean[11][11][4];
        
        String[] cmd = dirs.split("");
        
        // 경로 탐색
        int r = 5, c = 5, nr, nc, cmdNum;
        for (String s : cmd) {
            
            nr = r + dir.get(s)[0];
            nc = c + dir.get(s)[1];
            cmdNum = dir.get(s)[2];
            
            // 범위 벗어나면 무시
            if (nr < 0 || nr > 10 || nc < 0 || nc > 10) 
                continue;
            
            // 처음 방문하는 길이면 answer++하고, 방문 처리
            if (!(visited[r][c][cmdNum] || visited[nr][nc][(cmdNum + 2) % 4])) {
                answer++;
             
                visited[r][c][cmdNum] = true;
                visited[nr][nc][(cmdNum + 2) % 4] = true;
            }
            
            r = nr;
            c = nc;
        }
         
        return answer;
    }
}