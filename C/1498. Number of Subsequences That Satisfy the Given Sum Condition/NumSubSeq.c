#define MOD 1000000007

int compare(const void* a, const void* b){
    return *(int*)a - *(int*)b;
}

int power(int a, int b){
    long long result = 1, base = a;
    while(b > 0){
        if(b % 2 == 1)
            result = (result * base) % MOD;
        base = (base * base) % MOD;
        b /= 2;
    }
    return (int)result;
}


int numSubseq(int* nums, int numsSize, int target) {
    long long int count =0;

    qsort(nums, numsSize, sizeof(int), compare);

    int left = 0, right = numsSize-1;
    while(left<=right){
        if(nums[left]+nums[right] <= target){
            count = (count + power(2, right - left)) % MOD;
            left++;
        }
        else{
            right--;
        }
    }   
    return (int)count;
}
