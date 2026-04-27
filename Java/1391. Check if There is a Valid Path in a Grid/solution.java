class Solution {
    int rows, cols;
    // Map street types to their 2 valid exit directions: {rowOffset, colOffset}
    int[][][] dir = {
        {}, 
        {{0, -1}, {0, 1}},  // 1: Left, Right
        {{-1, 0}, {1, 0}},  // 2: Up, Down
        {{0, -1}, {1, 0}},  // 3: Left, Down
        {{0, 1}, {1, 0}},   // 4: Right, Down
        {{0, -1}, {-1, 0}}, // 5: Left, Up
        {{0, 1}, {-1, 0}}   // 6: Right, Up
    };

    public boolean hasValidPath(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        return dfs(grid, 0, 0, visited);
    }

    private boolean dfs(int[][] grid, int row, int col, boolean[][] visited) {
        // Base case: reached the bottom-right corner
        if (row == rows - 1 && col == cols - 1) return true;

        visited[row][col] = true;
        int streetType = grid[row][col];

        // Explore the two possible exits for the current street type
        for (int[] d : dir[streetType]) {
            int newRow = row + d[0];
            int newCol = col + d[1];

            // 1. Boundary Check & Visited Check
            if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols
                && !visited[newRow][newCol]) {
                
                // 2. Handshake Check: Does the neighbor connect back to the current cell?
                if (canConnect(row, col, newRow, newCol, grid[newRow][newCol])) {
                    if (dfs(grid, newRow, newCol, visited)) return true;
                }
            }
        }
        return false;
    }

    /**
     * Checks if the street at (row, col) has an exit that leads back to (parentRow, parentCol)
     */
    private boolean canConnect(int parentRow, int parentCol, int row, int col, int neighType) {
        for (int[] d : dir[neighType]) {
            if (row + d[0] == parentRow && col + d[1] == parentCol) {
                return true;
            }
        }
        return false;
    }
}

/*class Solution {
    public boolean hasValidPath(int[][] grid) {
        
        int n = grid.length, n2 = grid[0].length;
        int dir = -1; // dir = 0 LEFT, dir = 1 RIGHT, dir = 2 DOWN, dir = 3 UP
        int x = 0, y = 0;
        boolean lastCheck = false;

        if (grid[0][0] == 1) dir = 1;
        else if (grid[0][0] == 2) dir = 

        while (true){
            try{
                if (x == n-1 && y == n2-1) lastCheck = true;

                if (grid[x][y] == 1){ // No Direction Change
                    if (dir > 1) return false; 
                    else if (dir == 0) y--;
                    else y++;
                }
                else if (grid[x][y] == 2){ // No Direction Change
                    if (dir < 2) return false; 
                    else if (dir == 2) x--;
                    else x++;
                }
                else if (grid[x][y] == 3){ 
                    if (dir == 0 || dir == 2) return false;
                    else if (dir == 1){
                        x++;
                        dir = 2; // Down
                    } 
                    else {
                        y--;
                        dir = 0; // Left
                    }
                }
                else if (grid[x][y] == 4){ // 
                    if (dir == 1 || dir == 2) return false;
                    else if (dir == 0){
                        x--;
                        dir = 2; // Down
                    } 
                    else {
                        y++;
                        dir = 1; // Right
                    }
                }
                else if (grid[x][y] == 5){
                    if (dir == 0 || dir == 3) return false;
                    else if (dir == 1) {
                        x--;
                        dir = 3; // Up
                    }
                    else {
                        y--;
                        dir = 0; // Left
                    }
                }
                else if (grid[x][y] == 6){
                    if (dir == 1 || dir == 3) return false;
                    else if (dir == 0) {
                        x--;
                        dir = 3; // Up
                    } 
                    else {
                        y++;
                        dir = 1; // Right
                    }
                }
                if (lastCheck) return true;
            }
            catch (Exception e){
                return false;
            }
        }
    }
} */
