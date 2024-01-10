class Solution {
    int count = 0;
    public int solution(int[] numbers, int target) {
        dfs(numbers, 0, 0, target);
        return count;
    }
    void dfs(int[] numbers, int depth, int sum, int target) {
        if (depth == numbers.length) {
            if (sum == target)
                count++;
            return;
        }
        int num = numbers[depth];
        depth++;
        dfs(numbers, depth, sum + num, target);
        dfs(numbers, depth, sum - num, target);
    }
}