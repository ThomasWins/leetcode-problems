class Solution {
    public int minOperations(int[] nums) {
        int count = 0;
        while (1 == 1) {
            boolean done = true;
            int tmpCount = count;

            for (int i = 0; i < nums.length -2; i++) {
                if (nums[i] == 0){
                    nums[i] = 1;
                    nums[i+1] = 1 - nums[i+1];
                    nums[i+2] = 1 - nums[i+2];
                    count++;
                }
            }
            
            for (int i = 0; i < nums.length; i++){
                if (nums[i] == 0) {
                    if (tmpCount == count) return -1;
                    done = false;
                    break;
                }
            }
            if (done) return count;
        }
    }
}
