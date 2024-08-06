import java.util.*;

class Solution {
    public static String[] vowels = {"A", "E", "I", "O", "U"};
    public static final int MAX_LENGTH = 5;
    public static List<String> dict;
    
    // 단어 삽입 dfs 
    public static void wordInsert(String str, int depth){
        dict.add(str);
        
        // 최대 길이에 도달하면 return 
        if(depth == MAX_LENGTH) return;
        
        // 모음 하나씩 붙여가며 단어 길이 1 증가 
        for(int i = 0; i < MAX_LENGTH; i++){
            wordInsert(str + vowels[i], depth + 1);
        }
        
    }
    
    public int solution(String word) {
        // 사전 생성
        dict = new ArrayList<>();
        
        // 0 번째 단어가 "", 1 번째 단어가 A
        // 첫 시작 단어 길이는 0 
        wordInsert("", 0);
        
        
        int answer = 0;
        for(int i=0;i<dict.size();i++){
            if(word.equals(dict.get(i))){
                answer = i;
                break;
            }
        }
        
        return answer;
    }
}