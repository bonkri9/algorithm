class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        int goalLen = goal.length;
        boolean flag = true;
        int idxG =0;
        int idx1 = 0;
        int idx2 = 0;

        for(int i=0;i<goalLen;i++){
            if(idx1 < cards1.length && idxG < goalLen && goal[idxG].equals(cards1[idx1])){
                idxG++;
                idx1++;
            }
            if(idx2 < cards2.length &&  idxG < goalLen && goal[idxG].equals(cards2[idx2])){
                idxG++;
                idx2++;
            }

            if(i == idxG){
                flag = false;
                break;
            }
        }


        String answer = flag ? "Yes" : "No";
        return answer;
    }
}
