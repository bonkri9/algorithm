import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());  // 돌의 개수
        int[] bridge = new int[n];
        boolean[] visited = new boolean[n];  // 방문 여부를 체크할 배열

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            bridge[i] = Integer.parseInt(st.nextToken());
        }
        int s = Integer.parseInt(br.readLine()) - 1;  // 시작점 (인덱스는 0부터 시작하므로 -1)

        // DFS 시작
        int reachableStones = dfs(s, bridge, visited);
        System.out.println(reachableStones);
    }

    public static int dfs(int current, int[] bridge, boolean[] visited) {
        // 현재 돌을 방문 처리
        visited[current] = true;
        int count = 1;  // 현재 돌은 이미 방문했으므로 1로 시작

        // 왼쪽으로 이동
        int left = current - bridge[current];
        if (left >= 0 && !visited[left]) {
            count += dfs(left, bridge, visited);
        }

        // 오른쪽으로 이동
        int right = current + bridge[current];
        if (right < bridge.length && !visited[right]) {
            count += dfs(right, bridge, visited);
        }

        return count;
    }
}