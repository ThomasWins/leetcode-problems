int longestMonotonicSubarray(int* nums, int numsSize) {
    int max = 1, count = 1;
    bool isIncreasing = true;

    for (int i = 1; i < numsSize; i++){
        if (nums[i-1] < nums[i]){
            if (isIncreasing){
                count++;
            } else {
                max = fmax(max, count);
                count = 2;
                isIncreasing = true;
            }
        } else if (nums[i-1] > nums[i]){
            if (!isIncreasing){
                count++;
            } else {
                max = fmax(max, count);
                count = 2;
                isIncreasing = false;
            }
        } else {
            max = fmax(max, count);
            count = 1;
        }
    }
    max = fmax(max, count);
    return max;
}