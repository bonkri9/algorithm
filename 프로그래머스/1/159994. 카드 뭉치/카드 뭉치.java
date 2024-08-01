class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        int goalLen = goal.length;
        
        // 단어 배열을 성공적으로 모두 완성했는 지 판별 여부
        boolean flag = true;
        
        int idxG = 0; // goals 배열의 인덱스
        int idx1 = 0; // cards1 배열의 인덱스
        int idx2 = 0; // cards2 배열의 인덱스 

        for(int i = 0; i < goalLen; i++){
            // 다음으로 와야할 goals 배열의 글자와 cards1 배열의 가장 앞 글자 비교
            if(idx1 < cards1.length && idxG < goalLen && goal[idxG].equals(cards1[idx1])){
                idxG++;
                idx1++;
            }
            
            // 다음으로 와야할 goals 배열의 글자와 cards2 배열의 가장 앞 글자 비교
            if(idx2 < cards2.length &&  idxG < goalLen && goal[idxG].equals(cards2[idx2])){
                idxG++;
                idx2++;
            }
            
            // 만약 goals 배열의 idxG 인덱스가 다음 칸으로 못 갔다면
            // 두 카드 뭉치에서 꺼낼 카드가 없는 것이므로 반복문 중지 
            if(i == idxG){
                flag = false;
                break;
            }
        }


        String answer = flag ? "Yes" : "No";
        return answer;
    }
}
