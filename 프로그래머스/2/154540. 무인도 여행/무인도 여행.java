import java.util.*;

class Solution {
    public static int[] dr = {1,-1,0,0};
    public static int[] dc = {0,0,1,-1};
    public static int[][] map;
    public static boolean[][] visited;

    public int[] solution(String[] maps) {
        int n = maps.length;
        int m = maps[0].length();
        
        map = new int[n][m];
        visited = new boolean[n][m];
        List<Integer> stay = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String tmp = maps[i];
            
            for (int j = 0; j < m; j++) {
                 map[i][j] = (tmp.charAt(j) == 'X') ? 0 : tmp.charAt(j) - '0';
            }
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && map[i][j] != 0) {
                   int cnt = dfs(i, j); 
                   stay.add(cnt);
                }
            }
        }
        
        Collections.sort(stay);
        
        if (stay.isEmpty()) {
            return new int[] {-1};
        }
        
        int[] answer = new int[stay.size()];
        for (int i = 0; i < stay.size(); i++) {
            answer[i] = stay.get(i);
        }
        Arrays.sort(answer);
        
        return answer;
    }

    public int dfs(int r, int c) {
        visited[r][c] = true;
        int cnt = map[r][c];
        
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (boundaryCheck(nr,nc) && !visited[nr][nc] && map[nr][nc] != 0) {
                cnt += dfs(nr, nc);
            } 
        }
        
        return cnt;
    }
    
    public boolean boundaryCheck(int r, int c) {
        return r >= 0 && c >= 0 && r < map.length && c < map[0].length;
    }
}