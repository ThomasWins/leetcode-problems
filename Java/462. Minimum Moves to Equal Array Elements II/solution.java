class Solution {
    public int minMoves2(int[] nums) {
        
        Arrays.sort(nums);
        int n = nums.length;
        int ret = 0, median = nums[n/2];

        for (int i = 0; i < n; i++){
            ret += Math.abs(median - nums[i]);
        }
        return ret;
    }
}
