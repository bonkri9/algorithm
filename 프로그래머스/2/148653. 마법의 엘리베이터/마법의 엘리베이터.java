class Solution {
    public int solution( int storey) {

        int numLen = (int) (Math.log10(storey)+1);
        int[] arr = new int[numLen+1];

        for(int i=0;i<numLen;i++){
            arr[i] = storey % 10;
            storey/=10;
        }

        int cnt = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i] <5){
                cnt += arr[i];

//                if(i+1<arr.length) arr[i+1]--;

            }else if(arr[i]==5){
                cnt+=arr[i];
                if(arr[i+1]>=5){
                    arr[i+1]++;
                }else{
//                    arr[i+1]--;
                }
            }else{
                cnt += 10-arr[i];
                arr[i+1]++;
            }
        }




        return cnt;

    }
}