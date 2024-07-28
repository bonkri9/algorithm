import java.util.*;
import java.io.*;

class Solution {
    // int 배열을 원소로 갖는 List 생성
    public static List<int[]> list;
    
    // n 개 원판, 시작 기둥 st, 중간 기둥 mid, 끝 기둥 ed
    public static void dfs(int n, int st, int mid, int ed){
        // 원판이 하나 남았으면 마지막 한 개를 list에 저장
        if(n == 1){
            list.add(new int[]{st, ed});
            return;
        }
        
        // n-1개 원판을 시작 기둥에서 중간 기둥으로 옮기기
        dfs(n - 1, st, ed, mid);
        
        // 가장 큰 마지막 원판을 시작 기둥에서 끝 기둥으로 옮기기
        list.add(new int[]{st, ed});
        
        // n-1개 원판을 중간 기둥에서 끝 기둥으로 옮기기
        dfs(n - 1, mid, st, ed);
    }
    
    public int[][] solution(int n) {
        list = new ArrayList<>();
        dfs(n, 1, 2, 3);
        
        int[][] answer = new int[list.size()][];
        for(int i=0;i<list.size();i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}