class Solution {
    public int[][] rotateGrid(int[][] grid, int k) {
        
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;

        if (n <= m) count = n/2;
        else count = m/2;

        for (int layer = 0; layer < count; layer++){

            List<Integer> r = new ArrayList<>(); // Row index
            List<Integer> c = new ArrayList<>(); // Col index
            List<Integer> val = new ArrayList<>(); // Val

            for (int j = layer; j < m - layer - 1; j++){ // Left
                r.add(j);
                c.add(layer);
                val.add(grid[j][layer]);
            }
            for (int j = layer; j < n - layer - 1; j++){ // Down
                r.add(m - layer - 1);
                c.add(j);
                val.add(grid[m - layer - 1][j]);
            }
            for (int j = m - layer - 1; j > layer; j--){ // right
                r.add(j);
                c.add(n - layer - 1);
                val.add(grid[j][n - layer - 1]);
            }
            for (int j = n - layer - 1; j > layer; j--){ // Up
                r.add(layer);
                c.add(j);
                val.add(grid[layer][j]);
            }

            int total = val.size();
            int kk = k % total;

            for (int j = 0; j < total; j++){
                int index = (j + total - kk) % total;
                grid[r.get(j)][c.get(j)] = val.get(index);
            }
        }
        return grid;
    }
}
