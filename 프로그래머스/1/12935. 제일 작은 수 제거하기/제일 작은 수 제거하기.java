class Solution {
    public int[] solution(int[] arr) {
        int[] answer;
        if(arr.length != 1){
            answer = new int[arr.length-1];
        }else{
            answer = new int[1];
        }
        int min  = arr[0];
        for(int i=0;i<arr.length;i++){
            if(min>arr[i]){
                min = arr[i];
            }
        }
        
        int m =0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==min){
                continue;
            }else{
                answer[m] = arr[i];
                m++;
            }
        }
        if(answer.length ==1){
            answer[0] = -1;
        }
        return answer;
    }
}