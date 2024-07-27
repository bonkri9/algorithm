import java.util.*;
import java.io.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        
        Map<String, Integer> mapCategory = new HashMap<>();
        
        // 의상 종류에 따른 갯수 세기
        for(int i = 0; i < clothes.length; i++){
            mapCategory.put(clothes[i][1], mapCategory.getOrDefault(clothes[i][1], 0) + 1);
        }
        
        // key 데이터를 순회하면서 각 의상 종류의 갯수에 따른 계산
        // {의상 갯수 + 1(안 입는 경우)} 를 다 곱하면 조합의 수 도출
        for(String key : mapCategory.keySet()){
            answer *= mapCategory.get(key) + 1;
        }
        
        // 의상을 모두 안 입는 조건인 1 빼기
        return answer - 1;
    }
}