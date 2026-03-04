class Solution {
    public int numSpecial(int[][] mat) {
        int ans = 0;
        int nrow = mat.length;
        int ncol = mat[0].length;
        
        for (int row = 0; row < nrow; row++) {
            for (int col = 0; col < ncol; col++) {
                if (mat[row][col] == 0) {
                    continue;
                }
                
                boolean good = true;
                for (int r = 0; r < nrow; r++) {
                    if (r != row && mat[r][col] == 1) {
                        good = false;
                        break;
                    }
                }
                
                for (int c = 0; c < ncol; c++) {
                    if (c != col && mat[row][c] == 1) {
                        good = false;
                        break;
                    }
                }
                
                if (good) {
                    ans++;
                }
            }
        }
        
        return ans;
    }
}
