class Solution {
    public int minOperations(int[][] grid, int x) {
        
        ArrayList<Integer> arr = new ArrayList<>();
        int ret = 0;

        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                arr.add(grid[i][j]);
            }
        }
        Collections.sort(arr);
        int n = arr.size();
        int median = arr.get(n/2);

        for (int num : arr){
            if (num % x != median % x) return -1;

            ret += Math.abs(median-num) / x;
        }

        return ret;
    }
}
