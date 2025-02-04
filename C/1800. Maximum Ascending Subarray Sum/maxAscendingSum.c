int maxAscendingSum(int* nums, int numsSize) {
    
    int sum = nums[0], max = 0;

    for (int i = 1; i < numsSize; i++){
        
        if (nums[i-1] < nums[i]){
            sum += nums[i];
        } else {
            max = fmax(max, sum);
            sum = nums[i];
        }
    }

    max = fmax(max, sum);
    return max;
}
