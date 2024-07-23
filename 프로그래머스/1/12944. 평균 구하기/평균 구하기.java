class Solution {
    public double solution(int[] arr) {
        int arrLen = arr.length;
        int sum = 0;
        
        for(int i=0;i<arrLen;i++){
            sum += arr[i];    
        }
        
        double answer = (double) sum / arrLen;
       
        return answer;
    }
}