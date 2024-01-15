class Solution {
    public String solution(String s) {
        String answer = "";
        String[] arrNum = s.split(" ");
        int num =0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int i=0;i< arrNum.length;i++){
            num = Integer.parseInt(arrNum[i]);
            if(min > num) min = num;
            if(max < num) max = num;
        }

        answer = String.valueOf(min+" "+max);
        return answer;
    }
}