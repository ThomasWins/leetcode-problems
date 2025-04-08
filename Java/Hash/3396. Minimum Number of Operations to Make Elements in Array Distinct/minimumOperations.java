class Solution {
    public int minimumOperations(int[] nums) {

        int n = nums.length;

        if (n == 1) return 0;
        if (n == 2) return (nums[0] == nums[1]) ? 1 : 0;
        
        // Initialize variables
        int operations = 0, index = 0;
        int[] hash = new int[101];
        boolean done = false;

        // Start of loop
        while (!done) {

            done = true;
            // Initialize hash
            for (int i = 0; i < 101; i++) {
                hash[i] = 0;
            }
            
            for (int i = index; i < n && done; i++) {
                hash[nums[i]]++;
                // Check if number repeated
                if (hash[nums[i]] > 1){
                    index +=3;
                    operations++;
                    done = false;
                }
            }
        }
        return operations;
    }
}
