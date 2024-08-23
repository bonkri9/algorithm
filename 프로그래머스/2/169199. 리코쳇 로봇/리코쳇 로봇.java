import java.util.*;

class Solution {

    // 델타 배열: 상, 하, 좌, 우
    public static int[] dr = {1, -1, 0, 0};
    public static int[] dc = {0, 0, 1, -1};

    public int solution(String[] board) {
        int n = board.length;
        int m = board[0].length();
        boolean[][] visited = new boolean[n][m]; // 방문배열 

        Queue<int[]> queue = new LinkedList<>();
        
        // 시작점 R 찾기, 큐 초기화
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i].charAt(j) == 'R') {
                    queue.add(new int[]{i, j});
                    visited[i][j] = true;
                    break;
                }
            }
        }

        // 이동 횟수
        int cnt = 0;

        // BFS 탐색 시작
        while (!queue.isEmpty()) {
            int qSize = queue.size();
            cnt++;

            for (int size = 0; size < qSize; size++) {
                int[] curr = queue.poll();
                int r = curr[0];
                int c = curr[1];

                for (int i = 0; i < 4; i++) {
                    int nr = r;
                    int nc = c;

                    // 한 방향으로 계속 이동
                    while (true) {
                        nr += dr[i];
                        nc += dc[i];
                        
                        // 범위 및 장애물 검사 
                        if (nr < 0 || nr >= n || nc < 0 || nc >= m || board[nr].charAt(nc) == 'D') {
                            nr -= dr[i];
                            nc -= dc[i];
                            break;
                        }
                    }

                    // 목표 G 확인 후 이동 횟수 반환
                    if (board[nr].charAt(nc) == 'G') {
                        return cnt;
                    }

                    // 방문하지 않은 곳이라면 큐에 추가, 방문체크
                    if (!visited[nr][nc]) {
                        visited[nr][nc] = true;
                        queue.add(new int[]{nr, nc});
                    }
                }
            }
        }

        // 목표를 찾지 못한 경우
        return -1;
    }
}
