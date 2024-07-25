class Solution {
    public String solution(String s) {
        char[] arr = s.toCharArray();
        
        if(arr[0] >= 'a' && arr[0] <= 'z'){
            arr[0] -= 32;
        }
        
        for(int i=1;i<arr.length;i++){
            if(arr[i-1] == ' ' && arr[i] >= 'a' && arr[i] <= 'z'){
                arr[i] -= 32;
            }
            
            if(arr[i-1] != ' ' && arr[i] >= 'A' && arr[i] <= 'Z'){
                arr[i] += 32;
            }
        }
        
        String answer = "";
        
        for(int i=0;i<arr.length;i++){
            answer += arr[i];
        }
        
        return answer;
    }
}