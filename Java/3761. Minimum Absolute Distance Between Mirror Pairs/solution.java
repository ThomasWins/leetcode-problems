class Solution {

    public int reverse(int num){
        String reversedStr = new StringBuilder(String.valueOf(num)).reverse().toString();
        return Integer.parseInt(reversedStr);
    }

    public int minMirrorPairDistance(int[] nums) {
        Map<Integer, Integer> prev = new HashMap<>();
        int n = nums.length;
        int ans = n + 1;

        for (int i = 0; i < n; i++) {
            int x = nums[i];
            if (prev.containsKey(x)) {
                ans = Math.min(ans, i - prev.get(x));
            }
            prev.put(reverse(x), i);
        }

        return ans == n + 1 ? -1 : ans;
    }
}



// O(n^2) Solution
/*class Solution {

    public int reverse(int num){
        String reversedStr = new StringBuilder(String.valueOf(num)).reverse().toString();
        return Integer.parseInt(reversedStr);
    }

    public int minMirrorPairDistance(int[] nums) {
        
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        boolean found = false;

        for (int i = 0; i < n-1; i++){
            if (min == 1) return 1; // Closest pair possible is found
            for (int j = i+1; j < n; j++){
                
                if ((j - i) >= min) break; // Passed the closest pair just skip

                if (reverse(nums[i]) == nums[j]){
                    min = Math.min(min, j-i);
                    found = true;
                    break; // End the loop since closest pair is found
                }
            }
        }
        if (found) return min;
        return -1;
    }
} */
