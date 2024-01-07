class Solution {
    public double solution(int[] numbers) {
        double answer = 0;
        int len = numbers.length;
        int sum = 0;
        for(int i=0;i<len;i++){
            sum += numbers[i];
        }
        answer = (double)sum / len;
        return answer;
    }
}