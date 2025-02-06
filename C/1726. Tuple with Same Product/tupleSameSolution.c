int tupleSameProduct(int* nums, int numsSize) {
    int * hash = calloc(sizeof(int), 100000001);
    int ret = 0;

    for(int i = 0; i < numsSize - 1; i++){
        for(int j = i + 1; j < numsSize; j++){
            ret += (hash[nums[i] * nums[j]]++);
        }
    }
    free(hash);
    return ret * 8;

}
