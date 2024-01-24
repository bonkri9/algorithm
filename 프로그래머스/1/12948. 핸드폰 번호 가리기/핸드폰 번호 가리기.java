class Solution {
    public String solution(String phone_number) {
        String answer = "";
        String[] phoneArr = phone_number.split("");
        int numLen = phoneArr.length;
        int visNum = numLen - 4;
        for(int i=0;i<visNum;i++){
            answer += "*";
        }
        for(int i=0;i<4;i++){
            answer += phoneArr[i+visNum];
        }
        return answer;
    }
}