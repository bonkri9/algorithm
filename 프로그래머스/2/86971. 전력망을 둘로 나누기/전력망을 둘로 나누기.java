import java.util.*;

public class Solution {
    public static List<List<Integer>> graph;
    
    public int solution(int n, int[][] wires) {
        int answer = n;
        graph = new ArrayList<>();
        
        // 인접 리스트 초기화
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        
        // 그래프에 간선 양방향 추가
        for (int i = 0; i < wires.length; i++) {
            int v1 = wires[i][0];
            int v2 = wires[i][1];
            
            graph.get(v1).add(v2);
            graph.get(v2).add(v1);
        }
        
        // 각 전선 제거하면서, 두 전력망 차이 계산
        for (int i = 0; i < wires.length; i++) {
            int v1 = wires[i][0];
            int v2 = wires[i][1];
            
            // 간선 제거
            graph.get(v1).remove(Integer.valueOf(v2));
            graph.get(v2).remove(Integer.valueOf(v1));
            
            // BFS를 통해 두 전력망의 크기 차이를 계산
            answer = Math.min(answer, bfs(n, v1));
            
            // 간선을 다시 연결한다
            graph.get(v1).add(v2);
            graph.get(v2).add(v1);
        }
        
        return answer;
    }
    
    // 넓이 우선 탐색 bfs
    public int bfs(int n, int start) {
        boolean[] visited = new boolean[n + 1];
        int cnt = 1;

        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.add(start);
        
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            for (int neighbor : graph.get(curr)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                    cnt++;
                }
            }
        }
        
        // 두 전력망의 크기 차이 반환
        return Math.abs(cnt - (n - cnt));
    }
}
