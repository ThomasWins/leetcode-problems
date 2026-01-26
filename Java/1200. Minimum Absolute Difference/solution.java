class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        
        Arrays.sort(arr);
        int n = arr.length;
        int min = Integer.MAX_VALUE;
        
        // Find min abs value
        for (int i = 0; i < n-1; i++) {
            int tmp = arr[i+1] - arr[i];
            min = Math.min(tmp, min);
        }

        List<List<Integer>> ret = new ArrayList<>();
        // Add to array
        for (int i = 0; i < n-1; i++){
            if (arr[i+1] - arr[i] == min) {
                ret.add(Arrays.asList(arr[i], arr[i+1]));
            }
        }
        return ret;
    }
}
