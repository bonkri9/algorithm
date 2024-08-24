class Solution {
    public int cnt = 0;
    public int solution(int[] numbers, int target) {
        return dfs(numbers, target, 0, 0);
    }

    public int dfs(int[] numbers, int target, int idx, int sum){
        // 모든 숫자 사용 시 처리
        if(idx == numbers.length){
            return (sum == target) ? 1 : 0;
        }
        
        // 더하는 경우와 빼는 경우 모두 탐색
        int plus = dfs(numbers, target, idx + 1, sum + numbers[idx]);
        int minus = dfs(numbers, target, idx + 1, sum - numbers[idx]);
        
        // 경우의 수 전체 합
        return plus + minus;
    }
}