class Solution {
    public int solution(int n) { //정수형 n 안에는 이미 정수가 들어가있음
        int answer = 0;          //answer
        for(int i=1;i<=n;i++){   //i가 n이 될 때까지 반복문 
            if(n%i==1){          //n을 i로 나눠서 나머지가 1이면
                answer = i;      //가장 작은 수가 i로 먼저 걸리므로 answer에 대입
                break;           //반복문 stop
            }
        }
        return answer;
    }
}