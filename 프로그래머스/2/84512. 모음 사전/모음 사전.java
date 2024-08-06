import java.util.*;

class Solution {
    public static String[] vowels = {"A", "E","I", "O", "U"};
    public static final int MAX_LENGTH = 5;
    public static List<String> dict;
    
    public static void wordInsert(String str, int depth){
        dict.add(str);
        
        if(depth == MAX_LENGTH) return;
        
        for(int i=0;i<MAX_LENGTH;i++){
            wordInsert(str + vowels[i], depth + 1);
        }
        
    }
    
    public int solution(String word) {
        dict = new ArrayList<>();
        
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