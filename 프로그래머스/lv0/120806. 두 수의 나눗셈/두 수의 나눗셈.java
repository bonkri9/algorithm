class Solution {
    public int solution(double num1, double num2) {
        int answer = 0;
        double num3 = num1 / num2;
        answer = (int)(num3 * 1000);
        return answer;
    }
}