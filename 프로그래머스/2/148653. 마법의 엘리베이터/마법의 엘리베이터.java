class Solution {
    public int solution(int storey) {

        // 자릿수 구하기 
        int numLen = (int) (Math.log10(storey) + 1);
        
        // 자릿수보다 1 크게 만들어서 배열 생성
        int[] arr = new int[numLen + 1];
        
        // 1의 자리부터 역으로 배열에 삽입 
        for(int i = 0; i < numLen; i++){
            arr[i] = storey % 10;
            storey /= 10;
        }

        int minStone = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] > 5 || (arr[i] == 5 && arr[i + 1] >= 5)){
                minStone += 10 - arr[i];
                arr[i + 1]++;
            }else{
                minStone += arr[i];
            }
        }

        return minStone;
    }
}