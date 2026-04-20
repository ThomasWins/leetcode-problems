class Solution {
    public int maxDistance(int[] colors) {
        
        int ret = -1, n = colors.length;

        for (int i = 0; i < n; i++){
            for (int j = n - 1; j > i; j--){
                if (colors[i] != colors[j]){
                    ret = Math.max(ret, j-i);
                    break;
                }
            }
        }
    return ret;
    }
}
