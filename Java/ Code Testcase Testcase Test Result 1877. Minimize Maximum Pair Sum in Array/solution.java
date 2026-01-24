class Solution {

    public static int findMax(int[] arr) {
        
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    public int minPairSum(int[] nums) {

        Arrays.sort(nums);
        int n = nums.length;
        int [] sums = new int [n/2];

        for (int i = 0; i < n/2; i++){
            sums[i] = nums[i] + nums[n-i-1];
        }

        return findMax(sums);
    }
}
