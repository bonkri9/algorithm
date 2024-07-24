class Solution {
    boolean solution(String s) {
        String[] arr = s.split("");
        int arrLen = arr.length;
        
        int cntP = 0;
        int cntY = 0;
        
        for(int i=0;i<arrLen;i++){
            if(arr[i].equals("P") || arr[i].equals("p")) cntP++;
            if(arr[i].equals("Y") || arr[i].equals("y")) cntY++;
        }
        
        boolean answer = false;
        
        if(cntP == cntY) answer = true;
        
        return answer;
    }
}