class Solution(object):
    def maxAlternatingSum(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        nums = sorted(nums, key = abs) # Treat negative ints as if they are pos since we square them
        ret = i = 0
        n = len(nums)-1

        while (i < n):
            ret += nums[n]**2 - nums[i]**2
            n -= 1
            i += 1

        if (i == n):
            ret += nums[i]**2

        
        return ret
        
        
