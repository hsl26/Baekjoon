import java.util.*;


class Solution {
    
    private Map<Integer, List<Integer>> map;
    
    private int[] visited;
    
    private int[][] e;    
    
    public int[] solution(int[][] edges) {
        int[] answer = new int[4];

		map = new HashMap<>();
        int maxNode = 0; 

		for (int[] arr : edges) {

			map.putIfAbsent(arr[0], new ArrayList<>());
			map.putIfAbsent(arr[1], new ArrayList<>());

			map.get(arr[0]).add(arr[1]);

            maxNode = Math.max(maxNode, Math.max(arr[0], arr[1]));
		}

		int last = maxNode + 1;
        e = new int[last][2];
        visited = new int[last];

		for (int i = 1; i < last; i++) {
            if (!map.containsKey(i)) continue;
			for (int a : map.get(i)) {
				e[i][0]++;
				e[a][1]++;
			}
		}

		// 생성한 정점의 번호
		for (int i = 1; i < last; i++) {
			if (e[i][0] >= 2 && e[i][1] == 0) {
				answer[0] = i;
				break;
			}
		}

        
        for (int next : map.get(answer[0])) {
            e[next][1]--;
        }
        
        // 8자 모양 그래프의 수
        for (int i = 1; i < last; i++) {
            if (i == answer[0] || visited[i] == 1) continue;
            
            if (e[i][0] == 2 && e[i][1] == 2) {
                visited[i] = 1;
                answer[3]++;
            }
        }
        
        // 막대 모양 그래프의 수
		for (int i = 1; i < last; i++) {
            if (i == answer[0] || visited[i] == 1) continue;
            if (!map.containsKey(i)) continue;

			if (e[i][1] == 0) {
                visited[i] = 1;
                answer[2]++;
			}
		}
        
        // 도넛 모양 그래프 수

        answer[1] = map.get(answer[0]).size() - answer[2] - answer[3];
        
        return answer;
    }
}