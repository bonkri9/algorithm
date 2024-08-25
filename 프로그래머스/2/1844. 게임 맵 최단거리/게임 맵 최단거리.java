import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public static int[] dr = {1, -1, 0, 0};
    public static int[] dc = {0, 0, 1, -1};
    
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> queue = new LinkedList<>();
        
        queue.add(new int[]{0, 0, 1}); // {row, col, distance}
        visited[0][0] = true;
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int r = current[0];
            int c = current[1];
            int dist = current[2];
            
            if (r == n - 1 && c == m - 1) {
                return dist; // 목표 지점 도달 시 거리 반환
            }
            
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                
                if (boundaryCheck(nr, nc, n, m) && !visited[nr][nc] && maps[nr][nc] != 0) {
                    queue.add(new int[]{nr, nc, dist + 1});
                    visited[nr][nc] = true;
                }
            }
        }
        
        return -1; // 목표 지점에 도달할 수 없는 경우
    }
    
    public boolean boundaryCheck(int r, int c, int n, int m) {
        return r >= 0 && c >= 0 && r < n && c < m;
    }
}
