class Solution {
    public int solution(int[] numbers) {
        int answer = 45;
        int numLen = numbers.length;
        for(int i=0;i<numLen;i++){
            answer -= numbers[i];
        }
        return answer;
    }
}