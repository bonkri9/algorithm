import java.util.Arrays;

class Solution {
    public int solution(int[] people, int limit) {
        int totalBoat = 0;
        Arrays.sort(people);
        int peopleCnt = people.length;
        boolean[] escape = new boolean[peopleCnt];

        for(int i=peopleCnt-1;i>=0;i--){
            if(escape[i]) continue;
            escape[i] = true;
            totalBoat++;

            for(int j=0;j<i;j++){
                if(!escape[j] && people[i] + people[j] <= limit){
                    escape[j] = true;
                    break;
                }
            }
        }



        return totalBoat;
    }
}