class Solution {
    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        int arrLen = signs.length;
        for(int i=0;i<arrLen;i++){
            if(signs[i] == true){
                answer += absolutes[i];
            }else{
                answer -= absolutes[i];
            }
        }
        return answer;
    }
}