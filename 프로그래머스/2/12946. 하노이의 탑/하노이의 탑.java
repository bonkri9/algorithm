import java.util.*;
import java.io.*;

class Solution {
    public static List<int[]> list;
    
    public static void dfs(int n, int st, int mid, int ed){
        if(n == 1){
            list.add(new int[]{st, ed});
            return;
        }
        
        dfs(n - 1, st, ed, mid);
        
        list.add(new int[]{st, ed});
        
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